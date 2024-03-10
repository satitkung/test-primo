package com.example.testprimo.extension

fun String.findFirstIndex(condition: String): Int {
    return indexOf(condition)
}
fun String.findLastIndex(condition: String): Int {
    val lastStartIndex = this.lastIndexOf(condition)
    return lastStartIndex + condition.length - 1
}