package com.example.kode.test_task.ui.activities.single_activity_fragments

import com.example.kode.domain.core.Base
import com.example.kode.test_task.ui.activities.SingleActivityViewModel
import com.example.kode.test_task.ui.activities.mappers.StringToSingleActivityStateMapper
import com.example.kode.test_task.ui.activities.models.SingleActivityStatesUI
import com.example.kode.test_task.ui.core.TestCommunication
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import org.junit.Before
import org.junit.Test

class TestSingleActivityViewModel {

    private var communicationListHistory = mutableListOf<TestSearchUIState>()
    private var singleActivityCommunication = TestCommunication(communicationListHistory)
    private lateinit var viewModel: SingleActivityViewModel<TestSearchUIState>

    @Before
    fun before() {
        communicationListHistory = mutableListOf()
        singleActivityCommunication = TestCommunication(communicationListHistory)
        viewModel = SingleActivityViewModel(
            singleActivityCommunication,
            TestMapper(
            StringToSingleActivityStateMapper()
            )
        )
    }

    @Test
    fun `set text 'KM' and return Search state`() {

        val testValue = "KM"

        viewModel.setSearchText(testValue)

        val expected = TestSearchUIState.Search(testValue)

        assertEquals(1, communicationListHistory.size)
        assertEquals(expected, communicationListHistory[0])
    }

    @Test
    fun `set text 'Dee' and return Search state`() {

        val testValue = "Dee"

        viewModel.setSearchText(testValue)

        val expected = TestSearchUIState.Search(testValue)

        assertEquals(1, communicationListHistory.size)
        assertEquals(expected, communicationListHistory[0])
    }

    @Test
    fun `set empty text and return Cancel state`() {

        val testValue = ""

        viewModel.setSearchText(testValue)

        assertEquals(1, communicationListHistory.size)
        assertTrue(communicationListHistory[0] is TestSearchUIState.Cancel)
    }

    sealed interface TestSearchUIState {

        data class Search(val text: String) : TestSearchUIState

        class Cancel : TestSearchUIState
    }

    class TestMapper(
        private val realMapper: StringToSingleActivityStateMapper,
    ) : Base.Mapper<String, TestSearchUIState> {

        override fun map(model: String): TestSearchUIState {
            val state = realMapper.map(model)
            return if (state is SingleActivityStatesUI.Search) {
                TestSearchUIState.Search(state.searchText)
            } else {
                TestSearchUIState.Cancel()
            }
        }
    }
}