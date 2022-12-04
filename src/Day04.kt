/**
 * Day 4: den Strand aufräumen
 *
 * Part 1: Wie viele Assignments liegen vollständig in einem anderen Assignment?
 * Part 2:
 */

fun main()
{
	val start = System.currentTimeMillis()
	val DAY: String = "04"
	println("Advent of Code 2022 - Day $DAY")

	// Solve part 1.
	fun part1(input: List<String>): Int
	{
		var encapsulationCounter: Int = 0
		for(line in input)  // 2-4,6-8
		{
			val elf1: String = line.split(",")[0]
			val elf2: String = line.split(",")[1]
			//println(elf1 + " " + elf2)

			// check if one task is inside the other or vice versa
			val elf1Start: Int = elf1.split("-")[0].toInt()
			val elf1End: Int   = elf1.split("-")[1].toInt()
			val elf2Start: Int = elf2.split("-")[0].toInt()
			val elf2End: Int   = elf2.split("-")[1].toInt()

			if(((elf1Start >= elf2Start) && (elf1Start <= elf2End) &&
				(elf1End <= elf2End) && (elf1End >= elf2Start))
				||
				((elf2Start >= elf1Start) && (elf2Start <= elf1End) &&
						(elf2End <= elf1End) && (elf2End >= elf1Start))
			)
			{
				encapsulationCounter++
			}

		}
		return encapsulationCounter
	}


	// Solve part 2.
	fun part2(input: List<String>): Int
	{
		var overlapCounter: Int = 0
		for(line in input)  // 2-4,6-8
		{
			val elf1: String = line.split(",")[0]
			val elf2: String = line.split(",")[1]
			//println(elf1 + " " + elf2)

			// check if one task is inside the other or vice versa
			val elf1Start: Int = elf1.split("-")[0].toInt()
			val elf1End: Int   = elf1.split("-")[1].toInt()
			val elf2Start: Int = elf2.split("-")[0].toInt()
			val elf2End: Int   = elf2.split("-")[1].toInt()

			if(((elf1Start >= elf2Start) && (elf1Start <= elf2End) ||
						(elf1End <= elf2End) && (elf1End >= elf2Start))
				||
				((elf2Start >= elf1Start) && (elf2Start <= elf1End) ||
						(elf2End <= elf1End) && (elf2End >= elf1Start))
			)
			{
				overlapCounter++
			}

		}
		return overlapCounter
	}


	// test if implementation meets criteria from the description, like:
	val testInput = readInput("Day${DAY}_test")
	val input = readInput("Day${DAY}")

	// Part 1
	check(part1(testInput) == 2)
	println("Part 1: ${part1(input)}")  // 524

	// Part 2
	check(part2(testInput) == 4)
	println("Part 2: ${part2(input)}")  //

	val elapsedTime = System.currentTimeMillis() - start
	println("Elapsed time: $elapsedTime ms")
}
