package com.example.kode.test_task.ui.activities.single_activity_fragments

import com.example.kode.test_task.ui.core.TestCommunication
import junit.framework.TestCase.*
import org.junit.Before
import org.junit.Test

class TestSingleActivityViewModel {

    private var communicationListHistory = mutableListOf<SearchUIState>()
    private val singleActivityCommunication = TestCommunication(communicationListHistory)

    @Before
    fun before() {
        communicationListHistory = mutableListOf()
    }

    @Test
    fun `set text 'KM' and return Search state`() {
        val viewModel = SingleActivityViewModel(singleActivityCommunication)

        val testValue = "KM"

        viewModel.search(testValue)

        val expected = SearchUIState.Search(testValue)

        assertEquals(1, communicationListHistory.size)
        assertEquals(expected, communicationListHistory[0])
    }

    @Test
    fun `set text 'Dee' and return Search state`() {
        val viewModel = SingleActivityViewModel(singleActivityCommunication)

        val testValue = "Dee"

        viewModel.search(testValue)

        val expected = SearchUIState.Search(testValue)

        assertEquals(1, communicationListHistory.size)
        assertEquals(expected, communicationListHistory[0])
    }

    @Test
    fun `set empty text and return Cancel state`() {
        val viewModel = SingleActivityViewModel(singleActivityCommunication)

        val testValue = ""

        viewModel.search(testValue)

        val expected = SearchUIState.Cancel()

        assertEquals(1, communicationListHistory.size)
        assertEquals(expected, communicationListHistory[0])
    }
}

sealed interface SearchUIState {

    class Search(val text: String) : SearchUIState

    class Cancel() : SearchUIState
}