package com.example.kode.data.repository.workers.mappers

import com.example.kode.domain.core.Exceptions
import com.example.kode.domain.entity.custom_exceptions.NoConnectionException
import com.example.kode.domain.entity.workers.WorkersEntity
import org.junit.Assert
import org.junit.Test
import java.io.IOException

class TestExceptionToFailEntityMapper {

    val exceptionToFailEntityMapper = ExceptionToFailEntityMapper()

    @Test
    fun `test Generic exception`() {
        val expected = WorkersEntity.FailEntity(Exceptions.GENERIC_EXCEPTION)
        val exception = IOException()

        val actual = exceptionToFailEntityMapper.map(exception)

        Assert.assertEquals(expected, actual)
    }

    @Test
    fun `test NoConnection exception`() {
        val expected = WorkersEntity.FailEntity(Exceptions.NO_CONNECTION_EXCEPTION)
        val exception = NoConnectionException()

        val actual = exceptionToFailEntityMapper.map(exception)

        Assert.assertEquals(expected, actual)
    }

    /*@Test
    fun `test BadRequest exception`() {
        val expected = WorkersEntity.FailEntity(Exceptions.BAD_REQUEST_EXCEPTION)
        val exception = IOException()

        val actual = exceptionToFailEntityMapper.map(exception)

        Assert.assertEquals(expected, actual)
    }*/
}