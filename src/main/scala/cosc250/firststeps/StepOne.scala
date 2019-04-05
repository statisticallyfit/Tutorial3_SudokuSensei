package cosc250.firststeps

import scala.annotation.tailrec
import scala.collection.immutable

/**
  * Now we know about higher order functions, let's go back to the first tutorial and see if they can help us solve
  * the exercises. You are welcome to use the "for" notation, which is syntactic sugar for map and flatMap, and so
  * is calling higher order functions!
  */
object StepOne {

	/**
	  * Double every element in an array.
	  *
	  * Start off by doing this iteratively. And then we'll discover how much shorter it is functionally.
	  */
	def doubleArray(arr:Array[Int]):Array[Int] = arr.map(_ * 2)

	/**
	  * Multiply every element in an array by its position in the array
	  * eg, for [3, 4, 2, 6, 2] [3 * 0, 4 * 1, 2 * 2, 6 * 3, 2 * 4]
	  *
	  * You might need zipWithIndex here...
	  */
	def timesPosition(arr:Array[Int]):Array[Int] = arr.zipWithIndex.map(pair => pair._1 * pair._2)


	/**
	  * Ok, we did that for arrays. Now, what if we want to do it for lists?
	  * Hint: if you're working imperatively and mutably, you can start with an Array and then go .toList on it at the end
	  */
	def doubleList(arr:List[Int]):List[Int] = arr.map(_ * 2)


	/**
	  * Suppose we are compiling a crossword. Given two words, find all the pairs of positions where those
	  * words have letters in commong. eg, for "frogs" and "eggs", we would return
	  * List((3,1), (3,2), (4,3)
	  */
	def matchingLetters(wordA:String, wordB:String):List[(Int, Int)] = {
		//for all letters in first word, find the common letter in wordB and return the index pair
		val pairsA = wordA.zipWithIndex
		val pairsB = wordB.zipWithIndex

		val allLetterIndexPairs: Seq[(Char, Int, Char, Int)] = pairsA.flatMap{case(lA, iA) =>
			pairsB.map{case(lB, iB) =>
				(lA, iA, lB, iB)
			}
		}
		allLetterIndexPairs.filter{case(lA, iA, lB, iB) => lA == lB}.map{case(_, iA, _, iB) => (iA, iB)}.toList

		//OR can do (this is actually nested for loop)
		/*(for {
			(lA, iA) <- wordA.zipWithIndex
			(lB, iB) <- wordB.zipWithIndex if (lA == lB)
		} yield (iA, iB)).toList*/
	}


	/*
	 * Fibonacci with fold left
	 */
	def fibonacci(n: Int): Int = {
		val theWholeSequence = (0 to n).foldLeft(Seq.empty[Int])({
			case (accSeq, number) => number match {
				case 0 => accSeq :+ 1
				case 1 => accSeq :+ 1
				case other => accSeq :+ accSeq(other - 1) + accSeq(other - 2)
			}
		})
		theWholeSequence(n)
	}




	/**
	  * Ok, the Roman Numerals one is harder to do this way, but I'll leave it here for anyone who's keen. You can skip
	  * it and head on to the Sudoku exercise if you'd prefer.
	  */
	def roman(i:Int):String = {

		//descending order
		val allNumerals = Seq(
			"M" -> 1000, "CM" -> 900,
			"C" -> 100, "XC" -> 90,
			"L" -> 50, "XL" -> 40,
			"X" -> 10, "IX" -> 9,
			"V" -> 5, "IV" -> 4, "I" -> 1
		)

		val (zero, finalRoman) = allNumerals.foldLeft( (i, "") )(
			{case ( (accRemainder, accRoman), (newLetter, newValue)) => {
			val numTimesGoIn: Int = accRemainder / newValue
			val newRomanPart: String = newLetter * numTimesGoIn
			val newRemainder = accRemainder % newValue
			(newRemainder, accRoman + newRomanPart)
		}})

		finalRoman
	}

	/*def nextNumeral(n:Int, numerals:Seq[(String, Int)] = allNumerals):(String, Int) = {
		numerals match {
			case (romanLetter, value) :: _  if value <= n  => (romanLetter, value)
			case (_, value) :: tail if value > n          => nextNumeral(n, tail)
		}
	}

	def intRom(n:Int, accRoman:String = ""):String = {

		nextNumeral(n) match {
			case (_, value) if value == 0 => accRoman //when no more numerals, return the accumulator string
			case (romanLetter, value)  => intRom(n - value, accRoman + romanLetter)
		}
	}*/


	/*
	 * Ok, now that's done, time to write a little Sudoku solver, and meet another higher order function: filter
	 */

}
