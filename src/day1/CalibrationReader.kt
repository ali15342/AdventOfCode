package day1

import java.io.File

class CalibrationReader(private val input: String) {
    fun readLines(): List<String> {
        val file = File(input)
        return if (file.exists()) {
            file.readLines()
        } else {
            emptyList()
        }
    }
}