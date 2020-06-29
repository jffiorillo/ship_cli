package com.adevinta.utils

class HelpWrappedError(val help: String, val original: Throwable) : Exception(original)

fun userError(message: String, help: String? = null): Nothing {
    val exception = IllegalArgumentException(message)
    if (help != null) throw HelpWrappedError(help = help, original = exception) else throw exception
}