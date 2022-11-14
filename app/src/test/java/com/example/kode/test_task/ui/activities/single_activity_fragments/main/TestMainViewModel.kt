package com.example.kode.test_task.ui.activities.single_activity_fragments.main

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.kode.domain.core.Base
import com.example.kode.domain.core.Read
import com.example.kode.domain.core.sort.SortUseCaseModel
import com.example.kode.domain.entity.custom_exceptions.NotFoundSearchException
import com.example.kode.domain.entity.workers.WorkerInfoEntity
import com.example.kode.domain.entity.workers.WorkerSortableEntity
import com.example.kode.domain.entity.workers.WorkersStateEntity
import com.example.kode.domain.usecase.workers.GetWorkersUseCase
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.entity_to_ui.*
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.search.UISearchInputStateToMainSearchState
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainResultStatesUI
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainSearchStateUI
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.PreviewWorkerInfoUIModel
import com.example.kode.test_task.ui.activities.single_activity_fragments.searchable.communications.SearchableCommunication
import com.example.kode.test_task.ui.activities.single_activity_fragments.searchable.models.UISearchInputState
import com.example.kode.test_task.ui.base.BaseTestCommunication
import com.example.kode.test_task.ui.base.UnconfinedTestDispatcherRule
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import kotlin.coroutines.CoroutineContext

class TestMainViewModel {

    @get:Rule
    val mainDispatcherRule = UnconfinedTestDispatcherRule()

    lateinit var testCommunication: MainStatesTestSearchableCommunication
    lateinit var mainViewModel: MainViewModel

    @Before
    fun before() = runTest {
        val mapper = WorkerInfoEntityToUIMapper()

        testCommunication = MainStatesTestSearchableCommunication()

        mainViewModel = MainViewModel(
            TestGetWorkerUseCase(coroutineContext),
            TestSortUseCase(),
            WorkersStateEntityToUIMapper(
                WorkersCloudEntityToUIMapper(mapper),
                WorkersCacheEntityToUIMapper(mapper),
                WorkersFailEntityToUIMapper()
            ),
            UISearchInputStateToMainSearchState(TestUISearchInputToMainSearchMapper()),
            testCommunication
        )
    }


    @Test
    fun `test search with search model`() = runTest {
        mainViewModel.search(UISearchInputState.Search("name"))

        val actual = testCommunication.searchState.last()

        assertEquals(testCommunication.state.size, 1)
        assertTrue(actual is MainResultStatesUI.Success.Cloud)
    }

    @Test
    fun `test search with search model return not found`() = runTest {

        mainViewModel.search(UISearchInputState.Search("not found"))

        assertEquals(testCommunication.state.size, 1)
        assertTrue(testCommunication.searchState.last() is MainResultStatesUI.Fail.SearchError)
    }

    @Test
    fun `test search with cancel model`() = runTest {

        mainViewModel.search(UISearchInputState.Cancel())

        assertEquals(testCommunication.state.size, 2)
        assertTrue(testCommunication.searchState.isEmpty())
    }
}



class MainStatesTestSearchableCommunication : TestSearchableCommunication<MainResultStatesUI>(
    MainResultStatesUI.Success.Cloud(listOf(
        PreviewWorkerInfoUIModel("id",
            "avatarUrl",
            "name",
            "lastName",
            "userTag",
            "position")
    ))
)

abstract class TestSearchableCommunication<M>(startState: M) : BaseTestCommunication<M>(),
    SearchableCommunication<M> {

    final override var state: MutableList<M> = mutableListOf()
    var searchState: MutableList<M> = mutableListOf()

    init {
        state.add(startState)
    }

    override fun saveSearch(saveModel: M) {
        searchState.add(saveModel)
    }

    override fun observeSearch(lifecycleOwner: LifecycleOwner, observer: Observer<M>) {}
}

class TestUISearchInputToMainSearchMapper :
    Base.Mapper<UISearchInputState.Search, MainSearchStateUI.SearchUI<*>> {

    override fun map(model: UISearchInputState.Search): MainSearchStateUI.SearchUI<*> =
        when (model.text) {
            "name" -> MainSearchStateUI.FullName("name")
            else -> MainSearchStateUI.FullName("not found")
        }
}

class TestSortUseCase : Read.AbstractInput.SuspendEquable<SortUseCaseModel<WorkerSortableEntity>, WorkersStateEntity> {

    override suspend fun get(equalsAttribute: SortUseCaseModel<WorkerSortableEntity>): WorkersStateEntity {
        val sortedList = equalsAttribute.sort()
        return if (sortedList.isEmpty())
            WorkersStateEntity.Fail(NotFoundSearchException())
        else
            WorkersStateEntity.Success(sortedList)
    }
}

class TestGetWorkerUseCase(coroutineContext: CoroutineContext) :
    GetWorkersUseCase<WorkersStateEntity>(coroutineContext, TestFailMapper()) {

    override suspend fun getSafely() = WorkersStateEntity.Success(
        listOf(
            WorkerInfoEntity("id", "avatarUrl", "name", "lastName", "userTag", "position")
        )
    )
}

class TestFailMapper : Base.Mapper<Exception, WorkersStateEntity> {

    override fun map(model: Exception) = WorkersStateEntity.Fail(NotFoundSearchException())
}