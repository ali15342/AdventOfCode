package day1

// Day 1 - Part 1
fun main() {
    val calibrationReader = CalibrationReader("calibrationReader.txt")
    val lines = calibrationReader.readLines()

    if (lines.isNotEmpty()) {
        val calibrationProcessor = CalibrationProcessor()
        val calibrationValues = calibrationProcessor.extractCalibrationValues(lines)

        if (calibrationValues.isNotEmpty()) {
            val sum = calibrationProcessor.sumOfCalibrationValues(calibrationValues)
            println("Sum of Recovered Calibration Values: $sum")
        } else {
            println("No calibration values found in the input.")
        }
    } else {
        println("Input file is empty or not found.")
    }
}
