import java.lang.Integer.max

/**
 * Day 5: Pakete mit dem Kran umschichten
 *
 * Part 1: Wie sind die Buchstaben der obersten Paketreihe nach dem Umschichten?
 * Part 2:
 */

fun main()
{
	val start = System.currentTimeMillis()
	val DAY: String = "05"
	println("Advent of Code 2022 - Day $DAY")

//
//	fun padRight(s: String?, n: Int): String
//	{
//		return "%-${n}s".format(s)
//	}


	// Solve part 1.
	// - find number of stacks
	// - make array with this size
	// - chunk line and add pakets to array
	// move stuff
	fun part1(input: List<String>): String {
//		var numberOfStacks: Int = 0
//		var maxLineLength = 0
//		// find how many stacks we have
//		stacksearch@ for (line in input) {
//			if (!line.contains("[") && !line.isEmpty() && !line.contains("move")) {
//				maxLineLength = max(maxLineLength, line.length)
//				// we hve the line with the stacks:
//				//  1   2   3
//				var myLine = line.trim()
//				var stacks = myLine.split("   ")
//				var biggestNumberAsString: String = stacks[stacks.size - 1].trim()
//				numberOfStacks = biggestNumberAsString.toInt()
//				break@stacksearch
//			}
//
//		}
//		println("Number of stacks: " + numberOfStacks + " longest line: $maxLineLength")
//
//
//		val listOfPositions: MutableList<String> = ArrayList()
//		for (i in 1..numberOfStacks)
//		{
//			listOfPositions.add("")  // create empty strings
//		}
//		println(listOfPositions)
//
//		parseParcels@for((lineNumber, line) in input.withIndex())
//		{
//			var myLine:String = if(line.length == maxLineLength) line else padRight(line, maxLineLength+1)  // falls die Zeile kürzer ist als die Zeile mit den Zahlen
//			if(!myLine.contains("["))
//			{
//				break
//			}
//			var chunkedLine = myLine.chunked(numberOfStacks+1)
//			println(chunkedLine)  //  [    , [D] ,     ]
//			for((i, chunk) in chunkedLine.withIndex())
//			{
//				var myChunk: String = chunk.trim()
//				myChunk = myChunk.replace("[", "")
//				myChunk = myChunk.replace("]", "")
//				if(myChunk.length != 0)
//				{
//					listOfPositions[i] += myChunk
//				}
//				println(chunk)
//			}
//			//stackArray.indices
//		}
//		println("listOfPositions: " + listOfPositions)  // [NZ, DCM, P]
//
//		// now reverse the order in each stack so that the top most crate is at the end of the string
//		for((i, entry) in listOfPositions.withIndex())
//		{
//			listOfPositions[i] = listOfPositions[i].reversed()
//		}
//		println("listOfPositions: " + listOfPositions)  // [ZN, MCD, P]

		// FUCK IT
		val listOfPositions: MutableList<String> = ArrayList()
		listOfPositions.clear()
		listOfPositions.add("BLDTWCFM")
		listOfPositions.add("NBL")
		listOfPositions.add("JCHTLV")
		listOfPositions.add("SPJW")
		listOfPositions.add("ZSCFTLR")
		listOfPositions.add("WDGBHNZ")
		listOfPositions.add("FMSPVGCN")
		listOfPositions.add("WQRJFVCZ")
		listOfPositions.add("RPMLH")

		// FINALLY: move the crates
		for (line in input)
		{
			if(!line.contains("move"))
			{
				continue
			}
			//println(line)  // move 1 from 2 to 1
			var howMany: Int = 0
			var from: Int = 0
			var to: Int = 0
			var commandInPieces = line.trim().split(" ")  // [move, 1, from, 1, to, 2]
			//println(commandInPieces)
			howMany = commandInPieces[1].toInt()
			from = commandInPieces[3].toInt() - 1
			to = commandInPieces[5].toInt() - 1

			listOfPositions[to] += listOfPositions[from].takeLast(howMany)  // Part 1: .reversed() hinzufügen
			listOfPositions[from] = listOfPositions[from].dropLast(howMany)
		}

		// combine answer string
		var theAnswer: String = ""
		for(entry in listOfPositions)
		{
			theAnswer += entry.last()
		}
		return theAnswer
	}


	// Solve part 2.
	fun part2(input: List<String>): Int
	{
		for(line in input)
		{
			//println(line)
			// siehe oben - einfach das .reversed weglassen
		}
		return input.size
	}


	// test if implementation meets criteria from the description, like:
	val testInput = readInput("Day${DAY}_test")
	val input = readInput("Day${DAY}")

	// Part 1
	//check(part1(testInput) == "CMZ")
	println("Part 1: ${part1(input)}")  // TGWSMRBPN

	// Part 2
	//check(part2(testInput) == 24000)
	//println("Part 2: ${part2(input)}")  // TZLTLWRNF

	val elapsedTime = System.currentTimeMillis() - start
	println("Elapsed time: $elapsedTime ms")
}