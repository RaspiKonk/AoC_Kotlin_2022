/**
 * Day 2: Stein Schere Papier spielen
 *
 * Part 1: ABC - XYZ aus dem geheimen Strategiepapier spielen und den Score berechnen
 * Part 2: Im Strategiepapier steht wie die Runde ausgehen muss - eigenen Zug entsprechen berechnen
 *
 *  1. Spalte: A for Rock, B for Paper, and C for Scissors (Gegner)
 *  2. Spalte: X for Rock, Y for Paper, and Z for Scissors (selber)
 *  Score (selber): 1 for Rock, 2 for Paper, and 3 for Scissors
 *                  outcome of the round (0 if you lost, 3 if the round was a draw, and 6 if you won)
 *
 *  schlauer wärs mit nem Dictionary gewesen :-/
 */

fun main()
{
	val start = System.currentTimeMillis()
	val DAY: String = "02"
	println("Advent of Code 2022 - Day $DAY")


	// calculate score for single game
	fun evaluateGame(line: String): Int
	{
		/*
		A-X  3    B-X  6   C-X  0   |   3 6 0
		A-Y  0    B-Y  3   C-Y  6   |   0 3 6
		A-Z  6    B-Z  0   C-Z  3   |   6 0 3

		A-A  3    B-A  6   C-A  0
		A-B  0    B-B  3   C-B  6
		A-C  6    B-C  0   C-C  3
		*/
		var retValue:Int = 0
		val otherPlayer: Char = line[0]
		val me: Char = line[line.length-1]

		// calculate score from other players' choice
		when (me)
		{
			'X' -> {
						retValue += 1
						when(otherPlayer)
						{
							'A' -> retValue += 3
							'C' -> retValue += 6
						}
					}

			'Y' -> {
						retValue += 2
						when(otherPlayer)
						{
							'A' -> retValue += 6
							'B' -> retValue += 3
						}
					}

			'Z' -> {
						retValue += 3
						when(otherPlayer)
						{
							'B' -> retValue += 6
							'C' -> retValue += 3
						}
					}

			else -> {println("Komisches Zeichen beim Gegner: $otherPlayer")}
		}
		//println("$otherPlayer $me Score: $retValue")
		return retValue
	}


	// Solve part 1.
	fun part1(input: List<String>): Int
	{
		var score: Int = 0
		for(line in input)
		{
			if(line.trim().length == 0) {
				continue }

			score += evaluateGame(line)
			//println(line)
		}

		return score
	}


	// Solve part 2.
	// X means you need to lose, Y means you need to end the round in a draw, and Z means you need to win
	fun part2(input: List<String>): Int
	{
		/*
		A-X  3    B-X  6   C-X  0   |   3 6 0
		A-Y  0    B-Y  3   C-Y  6   |   0 3 6
		A-Z  6    B-Z  0   C-Z  3   |   6 0 3
		*/
		// ABC - Gegner
		// XYZ - Ausgang
		// X loose
		// Y draw
		// Z win
		var retValue:Int = 0
		for(line in input)
		{
			if(line.trim().length == 0) {
				continue }

			// ersetzen was der Gegner spielt um meine Bugs einfacher zu finden
			var gamePlan: String
			gamePlan = line.replace("A", "rock")
			gamePlan = gamePlan.replace("B", "paper")
			gamePlan = gamePlan.replace("C", "scissors")

			gamePlan = gamePlan.replace("X", "loose")
			gamePlan = gamePlan.replace("Y", "draw")
			gamePlan = gamePlan.replace("Z", "win")
			//println("Game plan: $gamePlan")

			val otherPlayer: String = gamePlan.split(" ")[0]
			val gameResult: String = gamePlan.split(" ")[1]
			//println(otherPlayer + " " + gameResult)

			// calculate score from other players' choice
			when (otherPlayer)
			{
				"rock" -> {
					var newLine = "A "
					when(gameResult)
					{
						"loose" -> newLine += 'Z'  // scissors
						"draw" -> newLine += 'X'  // rock
						"win" -> newLine += 'Y'  // paper
					}
					retValue += evaluateGame(newLine)
				}

				"paper" -> {
					var newLine = "B "
					when(gameResult)
					{
						"loose" -> newLine += 'X'  // rock
						"draw" -> newLine += 'Y'  // paper
						"win" -> newLine += 'Z'  // scissors
					}
					retValue += evaluateGame(newLine)
				}

				"scissors" -> {
					var newLine = "C "
					when(gameResult)
					{
						"loose" -> newLine += 'Y'  // paper
						"draw" -> newLine += 'Z'  // scissors
						"win" -> newLine += 'X'  // rock
					}
					retValue += evaluateGame(newLine)
				}

				else -> {println("Komisches Zeichen beim Gegner: $otherPlayer")}
			}
			//println("$otherPlayer $me Score: $retValue")
		}
		return retValue
	}


	// test if implementation meets criteria from the description, like:
	val testInput = readInput("Day${DAY}_test")
	val input = readInput("Day${DAY}")

	// Part 1
	check(part1(testInput) == 15)
	println("Part 1: ${part1(input)}")  // 10624

	// Part 2
	check(part2(testInput) == 12)
	println("Part 2: ${part2(input)}")  // 14060

	val elapsedTime = System.currentTimeMillis() - start
	println("Elapsed time: $elapsedTime ms")
}
