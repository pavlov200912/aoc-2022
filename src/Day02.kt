fun main() {
    fun transformMove(move: String): Int {
        return when (move) {
            "A" -> 0 // rock
            "B" -> 1 // paper
            "C" -> 2 // scissors
            "X" -> 0
            "Y" -> 1
            "Z" -> 2
            else -> {
                -1
            }
        }
    }

    fun movePrize(move: Int): Int {
        return move + 1
    }

    fun findMyMove(otherMove: Int, result: String): Int {
        if (result == "Y") return otherMove
        if (result == "Z") {
            return when (otherMove) {
                0 -> 1
                1 -> 2
                2 -> 0
                else -> -1
            }
        }
        return when (otherMove) {
            0 -> 2
            1 -> 0
            2 -> 1
            else -> -1
        }
    }


    fun playMoves(move1: Int, move2: Int): Int {
        if (move1 == move2) return 3
        if (move1 == 0 && move2 == 1) return 6
        if (move1 == 1 && move2 == 2) return 6
        if (move1 == 2 && move2 == 0) return 6
        return 0
    }

    fun part1(input: List<String>): Int {
        return input.map {
            val split = it.split(" ")
            val move1 = transformMove(split[0])
            val move2 = transformMove(split[1])
//            println(playMoves(move1, move2).toString() + " " + movePrize(move2))
            playMoves(move1, move2) + movePrize(move2)
        }.sum()
    }

    fun part2(input: List<String>): Int {
        return input.map {
            val split = it.split(" ")
            val move1 = transformMove(split[0])
            val game = split[1]
            val move2 = findMyMove(move1, game)
//            println(move1.toString() + " " + move2.toString() + " " + playMoves(move1, move2).toString() + " " + movePrize(move2))
            playMoves(move1, move2) + movePrize(move2)
        }.sum()
    }

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
