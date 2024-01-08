package day4

import java.io.File

class ScratchCardParser {
    fun parse(filePath: String): List<ScratchCard> {
        val cards = mutableListOf<ScratchCard>()
        File(filePath).forEachLine { line ->
            val (cardNumber, numbersStr) = line.split(":")
            val (winningStr, yourStr) = numbersStr.split("|").map { it.trim() }

            val card = ScratchCard(
                winningNumbers = winningStr.split(" ").filter { it.isNotEmpty() }.map { it.toInt() },
                yourNumbers = yourStr.split(" ").filter { it.isNotEmpty() }.map { it.toInt() }
            )

            cards.add(card)
        }
        return cards
    }
}