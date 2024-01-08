package day4

class ScratchCardProcessor {
    fun calculatePoints(cards: List<ScratchCard>): Int {
        return cards.sumBy { card ->
            var points = 0
            val matchedNumbers = mutableSetOf<Int>()

            for (playerNumber in card.playerNumbers) {
                if (playerNumber in card.winningNumbers && playerNumber !in matchedNumbers) {
                    points = if (points == 0) 1 else points * 2
                    matchedNumbers.add(playerNumber)
                }
            }

            points
        }
    }

    fun calculateTotalCards(cards: List<ScratchCard>): Int {
        val ticketCopies = MutableList(cards.size) { 1 }

        for (eachCard in cards.indices) {
            val originalCard = cards[eachCard]
            var wins = 0

            for (number in originalCard.playerNumbers) {
                if (number in originalCard.winningNumbers) {
                    wins++
                }
            }

            for (next in (eachCard + 1) until (eachCard + wins + 1)) {
                ticketCopies[next] += ticketCopies[eachCard]
            }
        }

        return ticketCopies.sum()
    }
}