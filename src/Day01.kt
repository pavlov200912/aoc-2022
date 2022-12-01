fun main() {
    fun elfWeights(input: List<String>): MutableList<Int> {
        val elfs = mutableListOf<Int>()
        elfs.add(0)
        input.forEach {
            if (it == "") {
                elfs.add(0)
            } else {
                elfs[elfs.size - 1] += it.toInt()
            }
        }
        return elfs
    }

    fun part1(input: List<String>): Int {
        val elfs = elfWeights(input)
        return elfs.max()
    }

    fun part2(input: List<String>): Int {
        val elfs = elfWeights(input)
        elfs.sort()
        return elfs.takeLast(3).sum()
    }

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
