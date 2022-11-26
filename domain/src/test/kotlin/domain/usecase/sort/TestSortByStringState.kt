package domain.usecase.sort

import com.example.kode.domain.core.Save
import domain.core.TestDomainState
import domain.core.sort.TestDomainSortStateFail
import domain.core.sort.TestDomainSortStateSuccess
import domain.core.sort.TestSortableModel
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Test

class TestSortByStringState {

    val testSortState = TestDomainSortStateSuccess(
        listOf(
            TestSortableModel("test2"),
            TestSortableModel("test1"),
            TestSortableModel("bad2est"),
        )
    )

    @Test
    fun `test sort with Success sort`(): Unit = runBlocking {
        val sortModel = BaseSortModel("test", testSortState)
        val sortUseCase = SortByStringUseCase(this.coroutineContext, TestFailMapper())

        val actual = sortUseCase.get(sortModel)

        val expected = TestDomainSortStateSuccess<String>(
            listOf(
                TestSortableModel("test2"),
                TestSortableModel("test1"),
            )
        )

        assertEquals(expected.getSortableList().size, actual.getSortableList().size)
        assertEquals(actual, expected)
    }

    @Test
    fun `test sort with FailSort`(): Unit = runBlocking {
        val sortModel = BaseSortModel("aboba", testSortState)
        val sortUseCase = SortByStringUseCase(this.coroutineContext, TestFailMapper())

        val actual = sortUseCase.get(sortModel)

        val expected = TestDomainSortStateFail()

        assertEquals(actual, expected)
        //assertTrue(actual is TestDomainSortStateFail)
    }

    @Test(expected = Throwable::class)
    fun `test sort with something Exception`(): Unit = runBlocking {
        val sortModel = BaseSortModel("aboba", testSortState)
        val sortUseCase = SortByStringUseCase(this.coroutineContext, TestFailMapper())

        val actual = sortUseCase.get(sortModel)
    }

    class TestFailMapper() : Save.Base<Exception, TestDomainState> {
        override fun save(model: Exception): TestDomainState =
            if (model is TestFailSortException) TestDomainState.Fail()
    }

    class TestFailSortException : IOException()
}