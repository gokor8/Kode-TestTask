package domain.usecase.workers

import com.example.kode.domain.core.Base
import com.example.kode.domain.core.Exceptions
import com.example.kode.domain.entity.workers.WorkersStateEntity
import com.example.kode.domain.repository.WorkersRepository
import com.example.kode.domain.usecase.workers.GetWorkersUseCaseImpl
import domain.core.TestDomainModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.io.IOException

class TestGetWorkersUseCaseImpl {

    // Для чего такие сложности?
    // Представим задачу.
    // Есть recycler view где отображаются обычные карточки (имя фамилия) и вместе с ними расширенные карточки(имя фамилия и тп)
    // Делаем 2 юзкейса. Один дает простые сущности(TestRepository<SimpleEntity> + DataToSimpleDomainMapper<TestDataModel, SimpleEntity)
    // Второй сложные(TestRepository<DifficultEntity> + DataToDifficultDomainMapper<TestDataModel, DifficultEntity)
    // И теперь все просто. Когда надо получить один тип данных, даем его, когда другой, то другой

    private lateinit var returnedStateMapper: Base.Mapper<TestDataState, TestDomainModel> // из di
    private lateinit var exceptionToExceptionEntityMapper: TestExceptionToEntityMapper // из di

    // di
    @Before
    fun before_test() {
        returnedStateMapper = TestDataStateToEntityMapper()
        exceptionToExceptionEntityMapper = TestExceptionToEntityMapper()
    }

    @Test
    fun `get success workers list`(): Unit = runBlocking {
        val returnedState = TestDataState.Success()
        val testWorkersRepository = TestWorkersRepository(returnedState, returnedStateMapper)
        val workersUseCase =
            GetWorkersUseCaseImpl(
                this.coroutineContext,
                testWorkersRepository,
                exceptionToExceptionEntityMapper
            )

        val actual = workersUseCase.getWorkers()
        val expected = TestDomainModel.Success(
            "test"
        )

        Assert.assertEquals(expected, actual)
    }

    @Test
    fun `get exception workers list`(): Unit = runBlocking {
        val returnedState = TestDataState.Exception()
        val testWorkersRepository = TestWorkersRepository(returnedState, returnedStateMapper)
        val workersUseCase =
            GetWorkersUseCaseImpl(
                this.coroutineContext,
                testWorkersRepository,
                exceptionToExceptionEntityMapper
            )

        val actual = workersUseCase.getWorkers()
        val expected = TestDomainModel.Fail(Exceptions.GenericException)

        Assert.assertEquals(expected, actual)
    }


    // TEST REALIZATION

    class TestWorkersRepository<R>(
        private val testReturnedState: TestDataState,
        private val testDataStateMapper: Base.Mapper<TestDataState, R>
    ) : WorkersRepository<R> {

        override suspend fun getWorkers(): R {
            return testReturnedState.map(testDataStateMapper)
        }
    }

    class TestDataStateToEntityMapper : Base.Mapper<TestDataState, TestDomainModel> {
        override fun map(model: TestDataState) = when (model) {
            is TestDataState.Success ->
                TestDomainModel.Success(
                    "test"
                )
            is TestDataState.Exception -> throw IOException()
        }
    }

    class TestExceptionToEntityMapper : Base.Mapper<Exception, TestDomainModel> {
        override fun map(model: Exception) = TestDomainModel.Fail(Exceptions.GenericException)
    }

    sealed class TestDataState : Base.IgnorantMapper<TestDataState> {
        override fun <I : Base.Mapper<TestDataState, R>, R> map(model: I): R =
            model.map(this)

        class Success() : TestDataState()

        class Exception() : TestDataState()
    }
}