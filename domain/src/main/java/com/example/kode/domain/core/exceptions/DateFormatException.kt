package com.example.kode.domain.core.exceptions

import java.io.IOException

class DateFormatException(date: Any, formatPattern: String) :
    IOException("$date | PATTERN: $formatPattern")