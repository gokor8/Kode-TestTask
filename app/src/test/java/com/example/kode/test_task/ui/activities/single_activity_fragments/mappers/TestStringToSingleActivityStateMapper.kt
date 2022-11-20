package com.example.kode.test_task.ui.activities.single_activity_fragments.mappers

import com.example.kode.test_task.ui.activities.mappers.StringToSingleActivityStateMapper
import com.example.kode.test_task.ui.activities.models.SingleActivityStatesUI
import junit.framework.TestCase
import org.junit.Test

class TestStringToSingleActivityStateMapper {

    private val mapper = StringToSingleActivityStateMapper()

    @Test
    fun `set text 'KM' and return Search state`() {

        val testValue = "KM"

        val actual = mapper.map(testValue)
        val expected = SingleActivityStatesUI.Search(testValue)

        TestCase.assertEquals(expected, actual)
    }

    @Test
    fun `set text 'Dee' and return Search state`() {

        val testValue = "Dee"

        val actual = mapper.map(testValue)
        val expected = SingleActivityStatesUI.Search(testValue)

        TestCase.assertEquals(expected, actual)
    }

    @Test
    fun `set empty text and return Cancel state`() {

        val testValue = ""

        val actual = mapper.map(testValue)

        TestCase.assertTrue(actual is SingleActivityStatesUI.Cancel)
    }
}