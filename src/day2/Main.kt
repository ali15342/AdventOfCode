package day2

// Day 2 - Part 1
fun main(){
    val targetCubeCount = CubeCount(12, 13, 14)

    val inputFileName = "gameInput.txt"

    val gameParser = GameParser()
    val games = gameParser.readGamesFromFile(inputFileName)

    val gameLogic = GameLogic()
    val possibleGames = gameLogic.findPossibleGames(games, targetCubeCount)
    val sumOfPossibleGameIds = possibleGames.sumBy { it.id }

    println("Sum of IDs of those games: $sumOfPossibleGameIds")
}