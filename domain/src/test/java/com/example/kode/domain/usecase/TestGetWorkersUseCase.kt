package com.example.kode.domain.usecase

import com.example.kode.domain.core.Base
import com.example.kode.domain.core.Exceptions
import com.example.kode.domain.entity.custom_exceptions.NoConnectionException
import com.example.kode.domain.entity.workers.WorkersEntity
import com.example.kode.domain.repository.WorkersRepository
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.io.IOException

class TestGetWorkersUseCase {

    // Для чего такие сложности?
    // Представим задачу. Есть recycler view где отображаются обычные карточки (имя фамилия) и вместе с ними расширенные карточки(имя фамилия и тп)
    // Делаем 2 юзкейса. Один дает простые сущности(TestRepository<SimpleEntity> + DataToSimpleDomainMapper<TestDataModel, SimpleEntity)
    // Второй сложные(TestRepository<DifficultEntity> + DataToDifficultDomainMapper<TestDataModel, DifficultEntity)
    // И теперь все просто. Когда надо получить один тип данных, даем его, когда другой, то другой

    private lateinit var returnedStateMapper: Base.Mapper<TestDataStates, WorkersEntity> // из di
    private lateinit var exceptionToExceptionEntityMapper: TestExceptionToExceptionEntityMapper // из di

    // di
    @Before
    fun before_test() {
        returnedStateMapper = TestDataStatesToEntityMapper()
        exceptionToExceptionEntityMapper = TestExceptionToExceptionEntityMapper()
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

    @Test
    fun `get exception workers list`() {
        val returnedState = TestDataStates.Exception()
        val testWorkersRepository = TestWorkersRepository(returnedState, returnedStateMapper)
        val workersUseCase = GetWorkers(testWorkersRepository, exceptionToExceptionEntityMapper)

        val actual = workersUseCase.getWorkers()
        val expected = WorkersEntity.ExceptionEntity(Exceptions.GENERIC_EXCEPTION)

        Assert.assertEquals(expected, actual)
    }

    class TestWorkersRepository<out R>(
        private val testReturnedState: TestDataStates,
        private val testDataStatesMapper: Base.Mapper<TestDataStates, R>
    ) : WorkersRepository<R> {

        override fun getWorkers(): R = testReturnedState.map(testDataStatesMapper)
    }

    class TestDataStatesToEntityMapper : Base.Mapper<TestDataStates, WorkersEntity> {
        override fun map(model: TestDataStates) = when (model) {
            is TestDataStates.Success -> WorkersEntity.SuccessEntity("success","success","success","success")
            is TestDataStates.Fail -> WorkersEntity.FailEntity("fail", "fail")
            is TestDataStates.Exception -> throw IOException()
        }
    }

    class TestExceptionToExceptionEntityMapper : Base.Mapper<Exception, WorkersEntity.ExceptionEntity> {
        override fun map(model: Exception) = when (model) {
            is NoConnectionException -> WorkersEntity.ExceptionEntity(Exceptions.NO_CONNECTION_EXCEPTION)
            else -> WorkersEntity.ExceptionEntity(Exceptions.GENERIC_EXCEPTION)
        }
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

}