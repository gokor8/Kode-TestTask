package data.repository.workers.mappers

import com.example.kode.data.repository.workers.mappers.ExceptionToFailEntityMapper
import com.example.kode.domain.core.Exceptions
import com.example.kode.domain.entity.custom_exceptions.NoConnectionException
import com.example.kode.domain.entity.workers.WorkersStateEntity
import org.junit.Assert
import org.junit.Test
import java.io.IOException

class TestExceptionToFailMapper {

    val exceptionToFailEntityMapper = ExceptionToFailEntityMapper()

    @Test
    fun `test Generic exception`() {
        val expected = WorkersStateEntity.Fail(Exceptions.GenericException)
        val exception = IOException()

        val actual = exceptionToFailEntityMapper.map(exception)

        Assert.assertEquals(expected, actual)
    }

    /*@Test
    fun `test BadRequest exception`() {
        val expected = WorkersStateEntity.Fail(Exceptions.BAD_REQUEST_EXCEPTION)
        val exception = IOException()

        val actual = exceptionToFailEntityMapper.map(exception)

        Assert.assertEquals(expected, actual)
    }*/
}