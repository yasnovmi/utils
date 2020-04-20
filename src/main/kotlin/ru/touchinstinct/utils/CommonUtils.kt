package ru.touchinstinct.utils

import org.springframework.core.io.ClassPathResource
import java.io.InputStream
import java.math.BigDecimal
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

fun getInputStreamOfResourceFile(fileName: String): InputStream = ClassPathResource(fileName).inputStream

fun getResourceAsString(filename: String): String = getInputStreamOfResourceFile(filename)
    .use { String(it.readBytes()) }

fun <T> Optional<T>.getOrNull(): T? = takeIf { it.isPresent }?.get()

fun BigDecimal.equalTo(number: BigDecimal): Boolean = compareTo(number) == 0

inline fun <T> Iterable<T>.sumBy(selector: (T) -> BigDecimal) =
    fold(BigDecimal.ZERO) { accumulator, element -> accumulator + selector(element) }

fun createLocalDateFromLocalDateString(jiraDate: String): LocalDate =
    LocalDate.parse(jiraDate, DateTimeFormatter.ISO_LOCAL_DATE)
