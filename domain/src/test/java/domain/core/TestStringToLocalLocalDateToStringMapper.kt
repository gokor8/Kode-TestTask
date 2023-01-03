package domain.core

import com.example.kode.domain.core.date_mappers.StringToLocalDateMapper
import org.junit.Assert
import org.junit.Test
import java.time.LocalDate
import java.time.format.DateTimeParseException

class TestStringToLocalLocalDateToStringMapper {

    private val mapper = StringToLocalDateMapper()

    @Test
    fun `success mapping`() {
        val date = "2004-08-02"

        val actual = mapper.map(date)
        val expected = LocalDate.of(2004 , 8, 2)

        Assert.assertEquals(expected, actual)
    }

    @Test(expected = DateTimeParseException::class)
    fun `fail mapping`() {
        val date = "2004002"

        val actual = mapper.map(date)
        val expected = LocalDate.of(2004 , 8, 2)

        Assert.assertEquals(expected, actual)
    }
}