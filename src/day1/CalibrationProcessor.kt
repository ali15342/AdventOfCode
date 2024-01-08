package day1

class CalibrationProcessor {
    fun extractCalibrationValues(lines: List<String>): List<Int> {
        return lines.mapNotNull { line ->
            val firstDigit = line.firstOrNull { it.isDigit() }
            val lastDigit = line.lastOrNull { it.isDigit() }

            if (firstDigit != null && lastDigit != null) {
                "$firstDigit$lastDigit".toIntOrNull()
            } else {
                null
            }
        }
    }

    fun sumOfCalibrationValues(calibrationValues: List<Int>): Int {
        return calibrationValues.sum()
    }



}