package day4

class ScratchCardProcessor {
    fun calculatePoints(cards: List<ScratchCard>): Int {
        return cards.sumBy { card ->
            var points = 0
            val matchedNumbers = mutableSetOf<Int>()

            for (number in card.yourNumbers) {
                if (number in card.winningNumbers && number !in matchedNumbers) {
                    points = if (points == 0) 1 else points * 2
                    matchedNumbers.add(number)
                }
            }

            points
        }
    }

    fun calculateTotalCards(cards: List<ScratchCard>): Int {
        val ticketCopies = MutableList(cards.size) { 1 }

        for (i in cards.indices) {
            val originalCard = cards[i]
            var winnings = 0

            for (number in originalCard.yourNumbers) {
                if (number in originalCard.winningNumbers) {
                    winnings++
                }
            }

            for (next in (i + 1) until (i + winnings + 1)) {
                ticketCopies[next] += ticketCopies[i]
            }
        }

        return ticketCopies.sum()
    }
}