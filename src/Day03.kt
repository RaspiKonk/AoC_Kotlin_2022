/**
 * Day 3: Doppelte Items in den Rücksäcken finden
 *
 * Part 1: Den Buchstaben finden der doppelt vorkommt und zu einem Score zusammenrechnen
 * Part 2: Den Buchstaben finden der in jeder 3er Gruppe von Rucksäcken (Zeilen) vorkommt
 */

fun main()
{
	val start = System.currentTimeMillis()
	val DAY: String = "03"
	println("Advent of Code 2022 - Day $DAY")


	// Lowercase item types a through z have priorities 1 through 26.  ASCII: a=97 z=122 (dec)
	// Uppercase item types A through Z have priorities 27 through 52. ASCII: A=65 Z=90 (dec)
	fun getCharPrio(c: Char): Int
	{
		var ret:Int = 0
		if(c.code > 90) // Kleinbuchstabe
		{
			ret = c.code - 96
		}
		else
		{
			ret = c.code - 64 + 26
		}
		//println("Score of Char $c (${c.code}) is $ret")
		return ret
	}


	// Solve part 1.
	fun part1(input: List<String>): Int
	{
		var  prioScore: Int = 0
		for(line in input)
		{
			var chunked = line.chunked(line.length/2)  // in 2 Teile teilen
			//println(chunked)
			var doppelt = chunked[0].partition{chunked[1].contains(it)}  // in 2 Listen zerlegen: in der 1. Liste landet alles was in der 2. Liste vorkommt
			//println(doppelt)  // (sss, CrZJPPZGz)
			prioScore += getCharPrio(doppelt.first[0])
		}
		return prioScore
	}


	// Solve part 2.
	fun part2(input: List<String>): Int
	{
		var  prioScore: Int = 0
		val chunkedInput = input.chunked(3)
		for (chunky in chunkedInput)
		{
			//println(chunky)  // [[vJrwpWtwJgWrhcsFMMfFFhFp, jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL, PmmdzqPrVvPwwTWBwg], [wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn, ttgJtRGJQctTZtZT, CrZsJsPPZsGzwwsLwLmpwMDw]]
			//println(chunky[0])
			var tripleChar = chunky[0].partition { chunky[1].contains(it) && chunky[2].contains(it) }
			//println(tripleChar)
			prioScore += getCharPrio(tripleChar.first[0])
		}
		return prioScore
	}


	// test if implementation meets criteria from the description, like:
	val testInput = readInput("Day${DAY}_test")
	val input = readInput("Day${DAY}")

	// Part 1
	check(part1(testInput) == 157)
	println("Part 1: ${part1(input)}")  // 8240

	// Part 2
	check(part2(testInput) == 70)
	println("Part 2: ${part2(input)}")  // 2587

	val elapsedTime = System.currentTimeMillis() - start
	println("Elapsed time: $elapsedTime ms")
}
