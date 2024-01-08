package day4

import java.io.File

class ScratchCardParser {
    fun parse(filePath: String): List<ScratchCard> {
        val cards = mutableListOf<ScratchCard>()
        File(filePath).forEachLine { line ->
            val (_, numbersStr) = line.split(":")
            val (winningNumbers, playerNumbers) = numbersStr.split("|").map { it.trim() }

            val card = ScratchCard(
                winningNumbers = winningNumbers.split(" ").filter { it.isNotEmpty() }.map { it.toInt() },
                playerNumbers = playerNumbers.split(" ").filter { it.isNotEmpty() }.map { it.toInt() }
            )

            cards.add(card)
        }
        return cards
    }
}