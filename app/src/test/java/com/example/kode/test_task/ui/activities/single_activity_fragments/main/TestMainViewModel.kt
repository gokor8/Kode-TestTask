package com.example.kode.test_task.ui.activities.single_activity_fragments.main

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.kode.domain.core.Base
import com.example.kode.domain.core.usecase.UseCaseSuspend
import com.example.kode.domain.usecase.workers.GetWorkersUseCase
import com.example.kode.test_task.ui.activities.models.SingleActivityStatesUI
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.communications.MixSearchCommunication
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainCommunicationModel
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainSearchStates
import com.example.kode.test_task.ui.core.TestCommunication
import com.example.kode.test_task.ui.core.TestEntityStates
import com.example.kode.test_task.ui.core.TestFailMapper
import com.example.kode.test_task.ui.core.ViewModelDispatcherRule
import com.example.kode.test_task.ui.core.search.states.UISearchState
import com.example.kode.test_task.ui.core.search.states.factories.DefaultUISearchStateFactory
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import kotlin.coroutines.CoroutineContext

typealias TestEntityState = TestEntityStates<List<String>>
typealias TestEntitySuccess = TestEntityStates.Success<List<String>>

class TestMainViewModel {

    @get:Rule
    val mainDispatcherRule = ViewModelDispatcherRule()

    private val testSuccessEntity = TestEntityStates.WithConnection(listOf("test", "aboba"))
    var communicationStartList = TestSearchCommunication()

    fun CoroutineScope.setupViewModel(
        returnSearchState: TestEntitySuccess = testSuccessEntity,
        returnWorkersState: TestEntitySuccess = testSuccessEntity,
    ) =
        MainViewModel<SingleActivityStatesUI, TestMainViewModelState, TestMainSearchStates, TestEntityState>(
            communicationStartList,
            TestEntityStateToTestMainState(),
            TestGetWorkersUseCase(this.coroutineContext, returnWorkersState),
            TestEntityStateToTestSearchMainState(),
            TestSearchStatesFactory(),
            TestSearchSortUseCase(this.coroutineContext, returnSearchState)
        )

    @Before
    fun before() {
        communicationStartList = TestSearchCommunication()
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `test search give good Search return Success`(): Unit = runTest {
        val viewModel = setupViewModel(TestEntityStates.WithConnection(listOf("test")))
        val testData = SingleActivityStatesUI.Search("test")

        viewModel.getWorkers().join()
        viewModel.search(testData)

        advanceUntilIdle()

        val actual = communicationStartList.searchCommunication.get()
        val expected = TestMainSearchStates.SearchSuccess(
            listOf(
                TestSuccessModel("test")
            )
        )

        assertEquals(1, communicationStartList.baseCommunication.communicationModel.size)
        assertEquals(1, communicationStartList.searchCommunication.communicationModel.size)
        assertEquals(expected, actual)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `test search give bad Search return NotFound`(): Unit = runTest {
        val viewModel = setupViewModel(TestEntityStates.WithConnection(emptyList()))
        val testData = SingleActivityStatesUI.Search("test")

        viewModel.getWorkers().join()
        viewModel.search(testData)

        advanceUntilIdle()

        val actual = communicationStartList.searchCommunication.get()
        val expected = TestMainSearchStates.SearchNotFound()

        assertEquals(1, communicationStartList.baseCommunication.communicationModel.size)
        assertEquals(1, communicationStartList.searchCommunication.communicationModel.size)
        assertEquals(expected, actual)
    }

    @Test
    fun `test search give Search when startList empty return Skip`() = runTest {
        val viewModel = setupViewModel()
        val testData = SingleActivityStatesUI.Search("test")

        viewModel.search(testData)

        val actual = communicationStartList.searchCommunication.get()
        val expected = TestMainSearchStates.SearchSkip()

        assertEquals(0, communicationStartList.baseCommunication.communicationModel.size)
        assertEquals(1, communicationStartList.searchCommunication.communicationModel.size)
        assertEquals(expected, actual)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `test search give Cancel return full Success`() = runTest {
        val viewModel = setupViewModel()
        val testData = SingleActivityStatesUI.Cancel()

        viewModel.getWorkers().join()
        viewModel.search(testData)

        advanceUntilIdle()

        val actual = communicationStartList.baseCommunication.get()
        val expected = TestMainViewModelState.BaseSuccess(
            listOf(
                TestSuccessModel("test"),
                TestSuccessModel("aboba")
            )
        )

        assertEquals(2, communicationStartList.baseCommunication.communicationModel.size)
        assertEquals(0, communicationStartList.searchCommunication.communicationModel.size)
        assertEquals(expected, actual)
    }

    @Test
    fun `test search give Cancel when startList empty return Skip`() = runTest {
        val viewModel = setupViewModel()
        val testData = SingleActivityStatesUI.Cancel()

        viewModel.search(testData)

        val actual = communicationStartList.searchCommunication.get()
        val expected = TestMainSearchStates.SearchSkip()

        assertEquals(0, communicationStartList.baseCommunication.communicationModel.size)
        assertEquals(1, communicationStartList.searchCommunication.communicationModel.size)
        assertEquals(expected, actual)
    }


    // TEST REALIZATION
    // MODELS
    sealed interface TestMainViewModelState : MainCommunicationModel {

        data class BaseSuccess(override val list: List<TestSuccessModel>) : Success()

        abstract class Success : TestMainViewModelState {
            abstract val list: List<TestSuccessModel>
        }

        open class Fail : TestMainViewModelState
    }

    data class TestSuccessModel(val id: String)

    class TestSearchStatesFactory : DefaultUISearchStateFactory<TestMainSearchStates> {
        override fun createSkip() = TestMainSearchStates.SearchSkip()
    }

    sealed interface TestMainSearchStates : UISearchState {
        data class SearchSuccess(override val list: List<TestSuccessModel>) :
            TestMainViewModelState.Success(), TestMainSearchStates,
            UISearchState.Success

        class SearchNotFound : TestMainViewModelState.Fail(), TestMainSearchStates,
            UISearchState.Fail {

            override fun equals(other: Any?): Boolean {
                return this === other || other is SearchNotFound
            }

            override fun hashCode(): Int {
                return javaClass.hashCode()
            }
        }

        class SearchSkip : TestMainSearchStates, UISearchState.Skip {
            override fun equals(other: Any?): Boolean {
                return this.hashCode() === other.hashCode() || other is SearchNotFound
            }

            override fun hashCode(): Int {
                return javaClass.hashCode()
            }
        }
    }


    // MAPPERS
    class TestEntityStateToTestSearchMainState :
        Base.Mapper<TestEntityState, TestMainSearchStates> {

        private val mapper = TestEntitySuccessToTestSuccessModel()

        override fun map(model: TestEntityState): TestMainSearchStates = when (model) {
            is TestEntitySuccess -> if (model.model.isNotEmpty()) {
                TestMainSearchStates.SearchSuccess(mapper.map(model))
            } else {
                TestMainSearchStates.SearchNotFound()
            }
            is TestEntityStates.Fail -> TestMainSearchStates.SearchNotFound()
        }
    }

    class TestEntityStateToTestMainState :
        Base.Mapper<TestEntityState, TestMainViewModelState> {

        private val mapper = TestEntitySuccessToTestSuccessModel()

        override fun map(model: TestEntityState): TestMainViewModelState = when (model) {
            is TestEntitySuccess -> TestMainViewModelState.BaseSuccess(mapper.map(model))
            is TestEntityStates.Fail<List<String>> -> TestMainViewModelState.Fail()
        }
    }

    class TestEntitySuccessToTestSuccessModel :
        Base.Mapper<TestEntitySuccess, List<TestSuccessModel>> {
        override fun map(model: TestEntitySuccess): List<TestSuccessModel> {
            return model.model.map { TestSuccessModel(it) }
        }
    }


    // USECASES
    class TestGetWorkersUseCase(
        coroutineContext: CoroutineContext,
        private val returnSuccessState: TestEntitySuccess,
        private val exception: Exception? = null,
    ) : GetWorkersUseCase<TestEntityState>(coroutineContext, TestFailMapper()) {

        override suspend fun getSafely(): TestEntityState {
            exception?.run { throw this }

            return returnSuccessState
        }
    }

    class TestSearchSortUseCase(
        coroutineContext: CoroutineContext,
        private val returnSuccessState: TestEntitySuccess,
        private val exception: Exception? = null,
    ) : UseCaseSuspend.UseCaseWithInput<Pair<String, TestMainViewModelState>, TestEntityState>(
        coroutineContext,
        TestFailMapper()
    ) {

        override suspend fun withSafe(equalsAttribute: Pair<String, TestMainViewModelState>): TestEntityState {
            exception?.run { throw this }

            return returnSuccessState
        }
    }


    class TestSearchCommunication :
        MixSearchCommunication<TestMainViewModelState, TestMainSearchStates> {

        val baseCommunication = TestCommunication<TestMainViewModelState>()
        val searchCommunication = TestCommunication<TestMainSearchStates>()

        override fun observeSearch(
            lifecycleOwner: LifecycleOwner,
            observer: Observer<TestMainSearchStates>,
        ) {
        }

        override fun searchSave(model: TestMainSearchStates) = searchCommunication.save(model)

        override fun observe(
            lifecycleOwner: LifecycleOwner,
            observer: Observer<TestMainViewModelState>,
        ) {
        }

        override fun notifyIt() {
            baseCommunication.get()?.let { baseCommunication.save(it) }
        }

        override fun isEmpty() = baseCommunication.communicationModel.isEmpty()

        override fun isNotEmpty() = baseCommunication.communicationModel.isNotEmpty()

        override fun get(): TestMainViewModelState? = baseCommunication.get()

        override fun save(model: TestMainViewModelState) {
            baseCommunication.save(model)
        }
    }
}