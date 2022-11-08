package com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.search

import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainSearchStateUI
import com.example.kode.test_task.ui.activities.single_activity_fragments.searchable.models.UISearchInputState
import junit.framework.Assert.assertTrue
import kotlinx.coroutines.test.runTest
import org.junit.Test

class TestUISearchInputToMainSearchMapper {

    val mapper = UISearchInputToMainSearchMapper()

    @Test
    fun `test map 2 upper chars to NickName`() = runTest {
        val testValue = UISearchInputState.Search("LK")

        val actual = mapper.map(testValue)

        assertTrue(actual is MainSearchStateUI.NickName)
    }

    @Test
    fun `test map 2 lower chars to NickName`() = runTest {
        val testValue = UISearchInputState.Search("lk")

        val actual = mapper.map(testValue)

        assertTrue(actual is MainSearchStateUI.NickName)
    }

    @Test
    fun `test map 4 chars to FullName`() = runTest {
        val testValue = UISearchInputState.Search("Deniel")

        val actual = mapper.map(testValue)

        assertTrue(actual is MainSearchStateUI.FullName)
    }
}