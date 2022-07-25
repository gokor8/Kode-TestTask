package com.example.kode.test_task.ui.activities.single_activity_fragments.main

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.example.kode.domain.usecase.workers.GetWorkersUseCase
import com.example.kode.test_task.ui.TestEntityStates
import com.example.kode.test_task.ui.TestUIStates
import com.example.kode.test_task.ui.core.BaseCommunication
import org.junit.Test

@Deprecated("Think about how test it")
class TestMainViewModel {

    @Test
    fun `test success getWorkers`() {
        val testUseCase =  TestUseCase(
            TestEntityStates.Success("1")
        )
        val communication = TestCommunications()
        val viewModel = MainViewModel(communication, testUseCase)

    }

    class TestCommunications : BaseCommunication<TestUIStates>()

    class TestUseCase(private val testEntityStates: TestEntityStates) :
        GetWorkersUseCase<TestEntityStates> {
        override suspend fun getWorkers(): TestEntityStates = testEntityStates
    }
}