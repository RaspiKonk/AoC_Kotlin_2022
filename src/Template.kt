/**
 * Day :
 *
 * Part 1:
 * Part 2:
 */

fun main()
{
	val start = System.currentTimeMillis()
	val DAY: String = "01"
	println("Advent od Code 2022 - Day $DAY")

	// Solve part 1.
	fun part1(input: List<String>): Int
	{
		for(line in input)
		{
			println(line)
		}
		return input.size
	}


	// Solve part 2.
	fun part2(input: List<String>): Int
	{
		for(line in input)
		{
			println(line)
		}
		return input.size
	}


	// test if implementation meets criteria from the description, like:
	val testInput = readInput("Day${DAY}_test")
	check(part1(testInput) == 24000)


	val input = readInput("Day${DAY}")
	println("Part 1: ${part1(input)}")  //
	println("Part 2: ${part2(input)}")  //

	val elapsedTime = System.currentTimeMillis() - start
	println("Elasped time: $elapsedTime ms")
}
