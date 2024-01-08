package day2

import java.io.File

class GameParser {
    fun readGamesFromFile(fileName: String): List<Game> {
        return File(fileName).readLines().mapIndexed { index, line ->
            val cubeCounts = parseGame(line)
            Game(index + 1, cubeCounts)
        }
    }

    private fun parseGame(game: String): List<CubeCount> {
        return game.substringAfter(":").split(";").map { parseCubeCount(it) }
    }

    private fun parseCubeCount(cubeCount: String): CubeCount {
        val colors = cubeCount.split(",").map {
            val (drawNum, color) = it.trim().split(" ", limit = 2)
            color to drawNum.toInt()
        }.toMap()

        return CubeCount(colors["red"] ?: 0, colors["green"] ?: 0, colors["blue"] ?: 0)
    }
}