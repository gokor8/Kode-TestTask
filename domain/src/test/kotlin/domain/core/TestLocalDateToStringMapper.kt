package domain.core

import com.example.kode.domain.core.date_mappers.LocalDateToStringMapper
import org.junit.Assert
import org.junit.Test
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

class TestLocalDateToStringMapper {

    private val mapper = LocalDateToStringMapper(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG))

    @Test
    fun `success mapping`() {
        val testDate = LocalDate.of(2004, 8, 2)

        val actual = mapper.map(testDate)
        val expected = "2 августа 2004 г."

        Assert.assertEquals(expected, actual)
    }
}