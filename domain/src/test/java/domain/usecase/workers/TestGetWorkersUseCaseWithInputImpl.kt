package domain.usecase.workers

import com.example.kode.domain.core.Base
import com.example.kode.domain.core.exceptions.UseCaseExceptions
import com.example.kode.domain.core.sort.ToSortModel
import com.example.kode.domain.core.sort.UseCaseSortableModel
import com.example.kode.domain.core.usecase.UseCaseModel
import com.example.kode.domain.repository.WorkersRepository
import com.example.kode.domain.usecase.sort.AbstractStateSortableUseCase
import com.example.kode.domain.usecase.workers.GetWorkersUseCaseImpl
import domain.core.EmptyTestMapper
import domain.core.TestDomainState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.io.IOException
import kotlin.coroutines.CoroutineContext

class TestGetWorkersUseCaseWithInputImpl {

    // Для чего такие сложности?
    // Представим задачу.
    // Есть recycler view где отображаются обычные карточки (имя фамилия) и вместе с ними расширенные карточки(имя фамилия и тп)
    // Делаем 2 юзкейса. Один дает простые сущности(TestRepository<SimpleEntity> + DataToSimpleDomainMapper<TestDataModel, SimpleEntity)
    // Второй сложные(TestRepository<DifficultEntity> + DataToDifficultDomainMapper<TestDataModel, DifficultEntity)
    // И теперь все просто. Когда надо получить один тип данных, даем его, когда другой, то другой

    private lateinit var returnedStateMapper: Base.Mapper<TestDataState, TestDomainState> // из di
    private lateinit var exceptionToExceptionEntityMapper: TestExceptionToEntityMapper // из di

    // di
    @Before
    fun before() = runBlocking {
        returnedStateMapper = TestDataStateToEntityMapper()
        exceptionToExceptionEntityMapper = TestExceptionToEntityMapper()
    }

    private fun CoroutineScope.setupRepository(returnedRepositoryState: TestDataState) =
        GetWorkersUseCaseImpl(
            this.coroutineContext,
            exceptionToExceptionEntityMapper,
            TestWorkersRepository(returnedRepositoryState, returnedStateMapper),
            EmptyTestMapper(),
            TestStateSortableUseCase(this.coroutineContext, exceptionToExceptionEntityMapper)
        )

    @Test
    fun `get success workers list`(): Unit = runBlocking {
        val workersUseCase = setupRepository(TestDataState.Success())

        val actual = workersUseCase.get()
        val expected = TestDomainState.Success(
            "test"
        )

        Assert.assertEquals(expected, actual)
    }

    @Test
    fun `get success workers list with passed sort`(): Unit = runBlocking {
        val workersUseCase = setupRepository(TestDataState.SortSuccess())

        val actual = workersUseCase.get()
        val expected = PassedSortableTestDomainState()

        Assert.assertEquals(expected, actual)
    }

    @Test
    fun `get exception workers list`(): Unit = runBlocking {
        val workersUseCase = setupRepository(TestDataState.Exception())

        val actual = workersUseCase.get()
        val expected = TestDomainState.Fail(UseCaseExceptions.GenericException)

        Assert.assertEquals(expected, actual)
    }


    // TEST REALIZATION

    class TestWorkersRepository<R : UseCaseModel>(
        private val testReturnedState: TestDataState,
        private val testDataStateMapper: Base.Mapper<TestDataState, R>,
    ) : WorkersRepository<R> {

        override suspend fun getWorkers(): R {
            return testReturnedState.map(testDataStateMapper)
        }
    }

    class TestDataStateToEntityMapper : Base.Mapper<TestDataState, TestDomainState> {
        override fun map(model: TestDataState) = when (model) {
            is TestDataState.Success -> TestDomainState.Success("test")
            is TestDataState.SortSuccess -> SortableTestDomainState()
            is TestDataState.Exception -> throw IOException()
        }
    }

    class TestExceptionToEntityMapper : Base.Mapper<Exception, TestDomainState> {
        override fun map(model: Exception) =
            TestDomainState.Fail(UseCaseExceptions.GenericException)
    }

    open class SortableTestDomainState : TestDomainState(), UseCaseSortableModel,
        ToSortModel<SortableTestDomainState>

    class PassedSortableTestDomainState : SortableTestDomainState() {

        override fun equals(other: Any?): Boolean =
            other != null && (this === other || other is PassedSortableTestDomainState)

        override fun hashCode() = javaClass.hashCode()
    }

    class TestStateSortableUseCase(
        coroutineContext: CoroutineContext,
        failMapper: Base.Mapper<Exception, TestDomainState>,
    ) : AbstractStateSortableUseCase<SortableTestDomainState, TestDomainState>(
        coroutineContext,
        failMapper,
        EmptyTestMapper()
    ) {
        override fun sort(equalsAttribute: SortableTestDomainState): SortableTestDomainState {
            return PassedSortableTestDomainState()
        }
    }

    sealed class TestDataState : Base.IgnorantMapper<TestDataState> {
        override fun <I : Base.Mapper<TestDataState, R>, R> map(model: I): R =
            model.map(this)

        class Success() : TestDataState()

        class SortSuccess() : TestDataState()

        class Exception() : TestDataState()
    }
}