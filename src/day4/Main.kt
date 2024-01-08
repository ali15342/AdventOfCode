package day4

//Day 4 Part 1 & Part 2
fun main(){
    val inputFile = "scratchCardInput.txt"

    val parser = ScratchCardParser()
    val processor = ScratchCardProcessor()

    val cards = parser.parse(inputFile)
    val totalPoints = processor.calculatePoints(cards)
    val totalCards = processor.calculateTotalCards(cards)

    println("Total points: $totalPoints")
    println("Total scratchcards: $totalCards")


}