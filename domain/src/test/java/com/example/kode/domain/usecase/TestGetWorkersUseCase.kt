package com.example.kode.domain.usecase

import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.workers.WorkersEntity
import com.example.kode.domain.mappers.ExceptionToExceptionEntityMapper
import com.example.kode.domain.repository.WorkersRepository
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.io.IOException

class TestGetWorkersUseCase {

    private lateinit var returnedStateMapper: Base.Mapper<TestDataStates, WorkersEntity> // из di
    private lateinit var exceptionToExceptionEntityMapper: ExceptionToExceptionEntityMapper

    @Before
    fun before_test() {
        returnedStateMapper = TestDataStatesToEntityMapper()
        exceptionToExceptionEntityMapper = ExceptionToExceptionEntityMapper()
    }

    @Test
    fun `get success workers list`() {
        val returnedState = TestDataStates.Success()
        val testWorkersRepository = TestWorkersRepository(returnedState, returnedStateMapper)
        val workersUseCase = GetWorkers(testWorkersRepository, exceptionToExceptionEntityMapper)

        val actual = workersUseCase.getWorkers()
        val expected = WorkersEntity.SuccessEntity("success", "success", "success", "success")

        Assert.assertEquals(expected, actual)
    }

    // Сделать маппер BaseState : Base.IgnorantMapper<BaseState>
    // BaseStateToTestEntity : Mapper<BaseState,
    @Test
    fun `get fail workers list`() {
        val returnedState = TestDataStates.Fail()
        val testWorkersRepository = TestWorkersRepository(returnedState, returnedStateMapper)
        val workersUseCase = GetWorkers(testWorkersRepository, exceptionToExceptionEntityMapper)

        val actual = workersUseCase.getWorkers()
        val expected = WorkersEntity.FailEntity("fail", "fail")

        Assert.assertEquals(expected, actual)
    }

    sealed interface TestDataStates : Base.IgnorantMapper<TestDataStates> {
        class Success : TestDataStates {
            override fun <I : Base.Mapper<TestDataStates, R>, R> map(model: I): R =
                model.map(this)
        }

        class Fail : TestDataStates {
            override fun <I : Base.Mapper<TestDataStates, R>, R> map(model: I): R =
                model.map(this)
        }

        class Exception : TestDataStates {
            override fun <I : Base.Mapper<TestDataStates, R>, R> map(model: I): R =
                model.map(this)
        }
    }

    class TestDataStatesToEntityMapper : Base.Mapper<TestDataStates, WorkersEntity> {
        override fun map(model: TestDataStates) = when (model) {
            is TestDataStates.Success -> WorkersEntity.SuccessEntity("success","success","success","success")
            is TestDataStates.Fail -> WorkersEntity.FailEntity("fail", "fail")
            is TestDataStates.Exception -> throw IOException()
        }
    }

    class TestWorkersRepository(
        private val testReturnedState: TestDataStates,
        private val testDataStatesMapper: Base.Mapper<TestDataStates, WorkersEntity>
    ) : WorkersRepository {
        override fun getWorkers(): WorkersEntity = testReturnedState.map(testDataStatesMapper)
    }
}