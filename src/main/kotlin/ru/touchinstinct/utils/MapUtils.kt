package ru.touchinstinct.utils

fun <T, F, R> Map<F, R>.remap(iterable: Iterable<T>, mappingKey: T.() -> F): Map<T, R> {
    val result = HashMap<T, R>()
    iterable.forEach {
        val key = it.mappingKey()
        val value = this[key]
        if (value != null) {
            result[it] = value
        }
    }
    return result
}
