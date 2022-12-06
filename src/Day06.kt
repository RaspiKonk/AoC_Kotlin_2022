/**
 * Day 6: Funkgerät reparieren: Die ersten 4 Character im String finden die sich nicht wiederholen.
 *
 * Part 1: Die ersten 4 Character im String finden die sich nicht wiederholen.
 * Part 2: same same with 14 chars
 */

fun main()
{
	val start = System.currentTimeMillis()
	val DAY: String = "06"
	println("Advent of Code 2022 - Day $DAY")

	// Solve part 1.
	fun part1(input: List<String>, windowSize: Int): Int
	{
		for(line in input)
		{
			//print(line)
			// sliding window
			var windows = line.windowed(windowSize, 1)
			// println(windows)  // [mjqj, jqjp, qjpq, jpqm, pqmg, ...
			for((index, w) in windows.withIndex())
			{
				val array: CharArray = w.toCharArray()
				val tmp = array.distinct()
				//print(tmp.size)
				if(tmp.size == windowSize)
				{
					// first string with different characters found - show score
					var pos: Int = index + windowSize
					return pos
				}
			}
		}
		return 0
	}


	// test if implementation meets criteria from the description, like:
	val testInput = readInput("Day${DAY}_test")
	val input = readInput("Day${DAY}")

	// Part 1
	//check(part1(testInput) == 24000)
	println("Part 1: ${part1(input, 4)}")  // 1235

	// Part 2
	//check(part2(testInput) == 24000)
	println("Part 2: ${part1(input, 14)}")  // 3051

	val elapsedTime = System.currentTimeMillis() - start
	println("Elapsed time: $elapsedTime ms")
}
