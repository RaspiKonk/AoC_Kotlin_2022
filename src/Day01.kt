/**
 * Day 1: Count the calories in the elves' backpacks
 *
 * Part 1: Who has the most calories?
 * Part 2: What are the top 3 calories combined?
 */
fun main()
{
    fun part1(input: List<String>): Int
    {
        return input.size
    }

    fun part2(input: List<String>): Int
    {
        return input.size
    }


    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 1)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
