package com.example.kode.domain.usecase.workers

import com.example.kode.domain.core.Base
import com.example.kode.domain.core.Exceptions
import com.example.kode.domain.core.TestBadRequestException
import com.example.kode.domain.entity.custom_exceptions.NoConnectionException
import com.example.kode.domain.entity.workers.WorkersEntity
import com.example.kode.domain.repository.WorkersRepository
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.io.IOException

class TestGetWorkersUseCase {

    // Для чего такие сложности?
    // Представим задачу.
    // Есть recycler view где отображаются обычные карточки (имя фамилия) и вместе с ними расширенные карточки(имя фамилия и тп)
    // Делаем 2 юзкейса. Один дает простые сущности(TestRepository<SimpleEntity> + DataToSimpleDomainMapper<TestDataModel, SimpleEntity)
    // Второй сложные(TestRepository<DifficultEntity> + DataToDifficultDomainMapper<TestDataModel, DifficultEntity)
    // И теперь все просто. Когда надо получить один тип данных, даем его, когда другой, то другой

    private lateinit var returnedStateMapper: Base.Mapper<TestDataState, WorkersEntity> // из di
    private lateinit var exceptionToExceptionEntityMapper: TestExceptionToEntityMapper // из di

    // di
    @Before
    fun before_test() {
        returnedStateMapper = TestDataStateToEntityMapper()
        exceptionToExceptionEntityMapper = TestExceptionToEntityMapper()
    }

    @Test
    fun `get success workers list`() {
        val returnedState = TestDataState.Success()
        val testWorkersRepository = TestWorkersRepository(returnedState, returnedStateMapper)
        val workersUseCase =
            GetWorkersUseCase(testWorkersRepository, exceptionToExceptionEntityMapper)

        val actual = workersUseCase.getWorkers()
        val expected = WorkersEntity.SuccessEntity(
            "success", "success", "success", "success"
        )

        Assert.assertEquals(expected, actual)
    }

    @Test
    fun `get exception workers list`() {
        val returnedState = TestDataState.Exception()
        val testWorkersRepository = TestWorkersRepository(returnedState, returnedStateMapper)
        val workersUseCase =
            GetWorkersUseCase(testWorkersRepository, exceptionToExceptionEntityMapper)

        val actual = workersUseCase.getWorkers()
        val expected = WorkersEntity.FailEntity(Exceptions.GENERIC_EXCEPTION)

        Assert.assertEquals(expected, actual)
    }

    class TestWorkersRepository<out R>(
        private val testReturnedState: TestDataState,
        private val testDataStateMapper: Base.Mapper<TestDataState, R>
    ) : WorkersRepository<R> {

        override fun getWorkers(): R {
            return testReturnedState.map(testDataStateMapper)
        }
    }

    class TestDataStateToEntityMapper : Base.Mapper<TestDataState, WorkersEntity> {
        override fun map(model: TestDataState) = when (model) {
            is TestDataState.Success ->
                WorkersEntity.SuccessEntity(
                    "success",
                    "success",
                    "success",
                    "success"
                )
            is TestDataState.Exception -> throw IOException()
        }
    }

    class TestExceptionToEntityMapper : Base.Mapper<Exception, WorkersEntity> {
        override fun map(model: Exception) = WorkersEntity.FailEntity(Exceptions.GENERIC_EXCEPTION)
    }

    sealed class TestDataState : Base.IgnorantMapper<TestDataState> {
        override fun <I : Base.Mapper<TestDataState, R>, R> map(model: I): R =
            model.map(this)

        class Success : TestDataState()

        class Exception() : TestDataState()
    }
}