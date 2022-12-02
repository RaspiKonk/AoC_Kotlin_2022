/**
 * Day 1: Count the calories in the elves' backpacks
 *
 * Part 1: Who has the most calories?
 * Part 2: What are the top 3 calories combined?
 */

fun main()
{
	val start = System.currentTimeMillis()
	val DAY: String = "01"
	println("Advent of Code 2022 - Day $DAY")

	var calorieList: List<Int> = listOf()

	fun part1(input: List<String>): Int
	{
		//println(input)
		var tempAdder: Int = 0
		for(line in input)
		{
			//println(line)
			if (line.length == 0)
			{
				calorieList += tempAdder
				tempAdder = 0
			}
			else
			{
				tempAdder += line.toInt()
			}
		}
		return calorieList.maxOrNull() ?: 0
	}

	fun part2(): Int
	{
		//println(calorieList)
		calorieList = calorieList.sorted()
		//println(calorieList)
		return calorieList[calorieList.size-1] + calorieList[calorieList.size-2] + calorieList[calorieList.size-3]
	}


	// test if implementation meets criteria from the description, like:
	val testInput = readInput("Day01_test")
	check(part1(testInput) == 24000)


	val input = readInput("Day01")
	println("Part 1: ${part1(input)}")  // 66487
	println("Part 2: ${part2()}")       // 197301
	println("Number of elves: ${calorieList.size}")  // 258

	val elapsedTime = System.currentTimeMillis() - start
	println("Elapsed time: $elapsedTime ms")
}
