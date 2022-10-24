package com.example.kode.test_task.ui.activities.single_activity_fragments

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.kode.domain.core.Base
import com.example.kode.domain.core.Read
import com.example.kode.domain.core.usecase.UseCaseModel
import com.example.kode.domain.usecase.worker.GetWorkerUseCase
import com.example.kode.test_task.ui.activities.single_activity_fragments.worker.WorkerViewModel
import com.example.kode.test_task.ui.core.communications.BaseCommunication
import kotlinx.coroutines.runBlocking

class WorkerViewModelTest {

  /*  fun `test get workers first run`() = runBlocking {
        val searchableCommunication = SearchableCommunication(
            TestCommunication(),
            TestCommunication()
        )

        val workerViewModel = WorkerViewModel(
            searchableCommunication,
            TestUseCase(),

        )
    }

    abstract class TestUIModel(val id: Int) : UseCaseModel<TestUIModel> {
        override fun <I : Base.Mapper<TestUIModel, R>, R> map(model: I): R = model.map(this)
    }

    class TestDefaultUIModel : TestUIModel(0), SearchResultStatesUI.Deafault

    class TestSuccessUIModel: TestUIModel(1), SearchResultStatesUI.Success

    class TestFailUIModel: TestUIModel(2), SearchResultStatesUI.Fail

    class TestCommunication : BaseCommunication<SearchResultStatesUI> {
        private var value: SearchResultStatesUI = TestFailUIModel(0)

        override fun observe(
            lifecycleOwner: LifecycleOwner,
            observer: Observer<SearchResultStatesUI>,
        ) {
        }

        override fun get() = value

        override fun save(model: SearchResultStatesUI) {
            value = model
        }

    }

    class TestUseCase : Read.AbstractInput.SuspendEquable<SearchResultStatesUI, SearchResultStatesUI> {

        override suspend fun get(equalsAttribute: SearchResultStatesUI): SearchResultStatesUI = equalsAttribute
    }*/
}