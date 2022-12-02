/**
 * Day :
 *
 * Part 1:
 * Part 2:
 */

fun main()
{
	val start = System.currentTimeMillis()
	val DAY: String = "03"
	println("Advent of Code 2022 - Day $DAY")

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
			//println(line)
		}
		return input.size
	}


	// test if implementation meets criteria from the description, like:
	val testInput = readInput("Day${DAY}_test")
	val input = readInput("Day${DAY}")

	// Part 1
	check(part1(testInput) == 24000)
	println("Part 1: ${part1(input)}")  //

	// Part 2
	//check(part2(testInput) == 24000)
	//println("Part 2: ${part2(input)}")  //

	val elapsedTime = System.currentTimeMillis() - start
	println("Elapsed time: $elapsedTime ms")
}
