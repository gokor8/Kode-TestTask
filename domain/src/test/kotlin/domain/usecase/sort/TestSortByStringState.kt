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
import domain.core.sort.string.TestExceptionDomainStringSortStateSuccess
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

        val expected = TestDomainStringSortStateSuccess(
            listOf(
                TestStringSortableModel("test2"),
                TestStringSortableModel("test1"),
            )
        )

        assertTrue(actual is TestDomainStringSortStateSuccess)

        val castedActual = actual as TestDomainStringSortStateSuccess
        assertEquals(castedActual.getSortableList().size, expected.getSortableList().size)
        assertEquals(castedActual.getSortableList(), expected.getSortableList())
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

        assertTrue(actual is TestDomainSortStateFail)
    }

    @Test
    fun `test sort with something Exception`(): Unit = runBlocking {
        val testData = TestExceptionDomainStringSortStateSuccess(
            testSortState.getSortableList()
        )

        val sortModel = StringSortEntity("aboba", testData)
        val sortUseCase = StringStateSortUseCase(
            this.coroutineContext,
            TestFailMapper(),
            TestToNormalStateMapper()
        )

        val actual = sortUseCase.get(sortModel)

        assertTrue(actual is TestDomainState.Fail)

        actual as TestDomainState.Fail
        assertTrue(actual.useCaseExceptions is TestFailSortException)
    }


    class TestToNormalStateMapper : Base.Mapper<TestDomainStringSortStateSuccess, TestDomainState> {
        override fun map(model: TestDomainStringSortStateSuccess): TestDomainState {
            if (model is TestExceptionDomainStringSortStateSuccess) {
                throw IOException("Was give exception model")
            }

            return if (model.getSortableList().isNotEmpty()) {
                TestDomainStringSortStateSuccess(model.getSortableList())
            } else {
                TestDomainSortStateFail()
            }
        }
    }
}

class TestFailMapper : Base.Mapper<Exception, TestDomainState> {
    override fun map(model: Exception): TestDomainState =
        TestDomainState.Fail(TestFailSortException())
}

class TestFailSortException : UseCaseExceptions()