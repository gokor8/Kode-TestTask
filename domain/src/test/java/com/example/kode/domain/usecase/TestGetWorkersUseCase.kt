package com.example.kode.domain.usecase

import com.example.kode.domain.core.Base
import com.example.kode.domain.core.BaseState
import com.example.kode.domain.entity.fail.SimpleFail
import com.example.kode.domain.mappers.ExceptionToSimpleFailMapper
import com.example.kode.domain.repository.WorkersRepository
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.io.IOException

class TestGetWorkersUseCase {

    private lateinit var returnedStateMapper: Base.Mapper<TestReturnedStates, BaseState>
    private lateinit var exceptionToSimpleFailMapper: ExceptionToSimpleFailMapper

    @Before
    fun before_test() {
        returnedStateMapper = TestReturnedStatesMapper()
        exceptionToSimpleFailMapper = ExceptionToSimpleFailMapper(
            SimpleFail("test", "test"),
            SimpleFail("unknownTest", "unknownTest")
        )
    }

    @Test
    fun `get success workers list`() {
        val returnedState = TestReturnedStates.Success()
        val testWorkersRepository = TestWorkersRepository(returnedState, returnedStateMapper)
        val workersUseCase = GetWorkers(testWorkersRepository, exceptionToSimpleFailMapper)

        val actual = workersUseCase.getWorkers()
        val expected = TestSuccessEntity("success")

        Assert.assertEquals(expected, actual)
        Assert.assertEquals(expected.message, (actual as TestSuccessEntity).message)
    }
    // Сделать маппер BaseState : Base.IgnorantMapper<BaseState>
    // BaseStateToTestEntity : Mapper<BaseState,
    @Test
    fun `get fail workers list`() {
        val returnedState = TestReturnedStates.Fail()
        val testWorkersRepository = TestWorkersRepository(returnedState, returnedStateMapper)
        val workersUseCase = GetWorkers(testWorkersRepository, exceptionToSimpleFailMapper)

        val actual = workersUseCase.getWorkers()
        val expected = TestFailEntity("fail")

        Assert.assertEquals(expected, actual)
        Assert.assertEquals(expected.message, (actual as TestFailEntity).message)
    }

    sealed class TestReturnedStates : Base.IgnorantMapper<TestReturnedStates> {
        class Success : TestReturnedStates() {
            override fun <I : Base.Mapper<TestReturnedStates, R>, R> map(model: I): R = model.map(this)
        }
        class Fail : TestReturnedStates() {
            override fun <I : Base.Mapper<TestReturnedStates, R>, R> map(model: I): R = model.map(this)
        }
        class Exception : TestReturnedStates() {
            override fun <I : Base.Mapper<TestReturnedStates, R>, R> map(model: I): R = model.map(this)
        }
    }

    class TestReturnedStatesMapper : Base.Mapper<TestReturnedStates, BaseState> {
        override fun map(model: TestReturnedStates): BaseState = when (model) {
            is TestReturnedStates.Success -> TestSuccessEntity("success")
            is TestReturnedStates.Fail -> TestFailEntity("fail")
            is TestReturnedStates.Exception -> throw IOException()
        }
    }

    data class TestSuccessEntity(val message: String) : BaseState.Success
    data class TestFailEntity(val message: String) : BaseState.Fail

    class TestWorkersRepository(
        private val testReturnedState: TestReturnedStates,
        private val testReturnedStatesMapper: Base.Mapper<TestReturnedStates, BaseState>
    ) : WorkersRepository {
        override fun getWorkers(): BaseState = testReturnedState.map(testReturnedStatesMapper)
    }
}