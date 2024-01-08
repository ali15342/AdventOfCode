package day2

class GameLogic {
    fun findPossibleGames(games: List<Game>, targetCubeCount: CubeCount): List<Game> {
        return games.filter { game ->
            game.cubeCounts.all { isValidConfiguration(it, targetCubeCount) }
        }
    }

    private fun isValidConfiguration(cubeCount: CubeCount, targetCubeCount: CubeCount): Boolean {
        return cubeCount.red <= targetCubeCount.red &&
                cubeCount.green <= targetCubeCount.green &&
                cubeCount.blue <= targetCubeCount.blue
    }

}