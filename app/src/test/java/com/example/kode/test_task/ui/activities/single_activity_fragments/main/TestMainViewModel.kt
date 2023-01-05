package com.example.kode.test_task.ui.activities.single_activity_fragments.main

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.kode.test_task.ui.activities.models.SingleActivityStatesUI
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.communications.MixSearchCommunication
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.communications.temp_searchable.UISearchState
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainStatesUI
import com.example.kode.test_task.ui.core.BaseCommunication
import junit.framework.TestCase.assertEquals
import org.junit.Test

class TestMainViewModel {

    val communicationStartList: BaseCommunication<TestMainViewModelState>
    val viewModel = MainViewModel<SingleActivityStatesUI, MainStatesUI, *>()

    @Test
    fun `test search give good Search return Success`() {
        val testData = SingleActivityStatesUI.Search("test")

        val actual = viewModel.search(testData)

        val expected = TestMainViewModelState.BaseSuccess(
            listOf(
                TestSuccessModel("test")
            )
        )

        assertEquals(1, actual.workers.size)
        assertEquals(expected, actual)
    }

    @Test
    fun `test search give bad Search return NotFound`() {
        val testData = SingleActivityStatesUI.Search("test1")

        val actual = viewModel.search(testData)

        val expected = TestMainViewModelState.NotFound()

        assertEquals(expected, actual)
    }

    @Test
    fun `test search give Search when startList empty return Skip`() {
        val testData = SingleActivityStatesUI.Search("test")

        val actual = viewModel.search(testData)

        assertEquals(communicationStartList, actual)
    }

    @Test
    fun `test search give Cancel return full Success`() {
        val testData = SingleActivityStatesUI.Cancel()

        val actual = viewModel.search(testData)

        assertEquals(communicationStartList, actual)
    }

    @Test
    fun `test search give Cancel when startList empty return Skip`() {
        val testData = SingleActivityStatesUI.Cancel()

        val actual = viewModel.search(testData)

        val expected = TestMainViewModelState.Skip()

        assertEquals(expected, actual)
    }


    // TEST REALIZATION

    sealed interface TestMainViewModelState {

        data class BaseSuccess(override val list: List<TestSuccessModel>) : Success()

        abstract class Success : TestMainViewModelState {
            abstract val list: List<TestSuccessModel>
        }

        class Skip : TestMainViewModelState

        class NotFound() : TestMainViewModelState
    }

    class TestSuccessModel(val id: String)

    class TestSearchCommunication : MixSearchCommunication<TestMainViewModelState> {
        override fun isEmpty(): Boolean {
            TODO("Not yet implemented")
        }

        override fun isNotEmpty(): Boolean {
            TODO("Not yet implemented")
        }

        override fun searchSave(model: UISearchState) {
            TODO("Not yet implemented")
        }

        override fun observeSearch(
            lifecycleOwner: LifecycleOwner,
            observer: Observer<UISearchState>,
        ) {
            TODO("Not yet implemented")
        }

        override fun notifyIt() {
            TODO("Not yet implemented")
        }

        override fun observe(
            lifecycleOwner: LifecycleOwner,
            observer: Observer<TestMainViewModelState>,
        ) {
            TODO("Not yet implemented")
        }

        override fun get(): TestMainViewModelState? {
            TODO("Not yet implemented")
        }

        override fun save(model: TestMainViewModelState) {
            TODO("Not yet implemented")
        }

    }
}