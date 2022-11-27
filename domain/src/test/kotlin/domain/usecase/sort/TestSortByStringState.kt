package domain.usecase.sort

import com.example.kode.domain.core.Base
import com.example.kode.domain.core.Save
import com.example.kode.domain.core.exceptions.UseCaseExceptions
import com.example.kode.domain.entity.sort.by_string.StringSortEntity
import com.example.kode.domain.entity.sort.by_string.StringSortableModel
import com.example.kode.domain.usecase.sort.StringStateSortUseCase
import domain.core.TestDomainState
import domain.core.sort.TestDomainSortStateFail
import domain.core.sort.TestDomainSortStateSuccess
import domain.core.sort.TestSortableModel
import domain.core.sort.string.TestDomainStringSortStateSuccess
import domain.core.sort.string.TestStringSortableModel
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.runBlocking
import org.junit.Test
import java.io.IOException

class TestSortByStringState {

    val testSortState = TestDomainStringSortStateSuccess(
        listOf(
            TestStringSortableModel("test2"),
            TestStringSortableModel("test1"),
            TestStringSortableModel("bad2est"),
        )
    )

    @Test
    fun `test sort with Success sort`(): Unit = runBlocking {
        val sortModel = StringSortEntity("test", testSortState)
        val sortUseCase = StringStateSortUseCase(
                this.coroutineContext,
                TestFailMapper(),
                TestToNormalStateMapper()
            )

        val actual = sortUseCase.get(sortModel)

        val expected = TestDomainSortStateSuccess(
            listOf(
                TestStringSortableModel("test2"),
                TestStringSortableModel("test1"),
            )
        )

        assertTrue(actual is TestDomainSortStateSuccess<*, *>)

        val castedActual = actual as TestDomainSortStateSuccess<*, *>
        assertEquals(castedActual.getSortableList().size, expected.getSortableList().size)
    }

    @Test
    fun `test sort with FailSort`(): Unit = runBlocking {
        val sortModel = StringSortEntity("aboba", testSortState)
        val sortUseCase = StringStateSortUseCase(
            this.coroutineContext,
            TestFailMapper(),
            TestToNormalStateMapper()
        )

        val actual = sortUseCase.get(sortModel)

        val expected = TestDomainState.Fail(TestFailSortException())

        assertTrue(actual is TestDomainState.Fail)
        val castedActual = actual as TestDomainState.Fail
        assertEquals(expected.useCaseExceptions, castedActual.useCaseExceptions)
    }

    @Test(expected = Throwable::class)
    fun `test sort with something Exception`(): Unit = runBlocking {
        //val withExceptionSortState =
        val sortModel = StringSortEntity("aboba", testSortState)
        val sortUseCase = StringStateSortUseCase(
            this.coroutineContext,
            TestFailMapper(),
            TestToNormalStateMapper()
        )

        val actual = sortUseCase.get(sortModel)
    }


    class TestToNormalStateMapper() :
        Base.Mapper<TestDomainStringSortStateSuccess, TestDomainState> {
        override fun map(model: TestDomainStringSortStateSuccess) =
            if (model.getSortableList().isNotEmpty()) {
                TestDomainSortStateSuccess(model.getSortableList())
            } else {
                TestDomainSortStateFail()
            }
    }
}

class TestFailMapper : Base.Mapper<Exception, TestDomainState> {
    override fun map(model: Exception): TestDomainState =
        TestDomainState.Fail(TestFailSortException())
}

class TestFailSortException : UseCaseExceptions()