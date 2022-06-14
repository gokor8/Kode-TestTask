package com.example.kode.domain.core

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.rmi.MarshalledObject

class TestBaseMapper {

    @Test
    fun `success map`() {
        val testInMapper = TestInMapper()
        val testInModel = TestInModel("aboba")

        val expected = "aboba amogus"
        val actual = testInModel.map(testInMapper)

        Assert.assertEquals(expected, actual.testString)
    }

    // Такие сложности с мапперами для того, чтобы их можно было подменять
    // В работе я сталкивался с такой ситуацией. Когда нужно было поменять цену для показа.
    // И там не хватало таких мапперов
    class TestInModel(val testString: String) : Base.Mapper<TestInModelToOutModelMapper, TestOutModel> {
        override fun map(model: TestInModelToOutModelMapper): TestOutModel = model.map(this)
    }

    interface TestInModelToOutModelMapper : Base.Mapper<TestInModel, TestOutModel>

    class TestInMapper : TestInModelToOutModelMapper{
        override fun map(model: TestInModel): TestOutModel =
            TestOutModel("${model.testString} amogus")
    }

    class TestOutModel(val testString: String)

}