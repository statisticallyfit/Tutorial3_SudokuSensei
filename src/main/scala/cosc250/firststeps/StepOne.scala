package cosc250.firststeps

import scala.annotation.tailrec

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
  def doubleArray(arr:Array[Int]):Array[Int] = ???

  /**
    * Multiply every element in an array by its position in the array
    * eg, for [3, 4, 2, 6, 2] [3 * 0, 4 * 1, 2 * 2, 6 * 3, 2 * 4]
    *
    * You might need zipWithIndex here...
    */
  def timesPosition(arr:Array[Int]):Array[Int] = ???


  /**
    * Ok, we did that for arrays. Now, what if we want to do it for lists?
    * Hint: if you're working imperatively and mutably, you can start with an Array and then go .toList on it at the end
    */
  def doubleList(arr:List[Int]):List[Int] = ???


  /**
    * Suppose we are compiling a crossword. Given two words, find all the pairs of positions where those
    * words have letters in commong. eg, for "frogs" and "eggs", we would return
    * List((3,1), (3,2), (4,3)
    */
  def matchingLetters(wordA:String, wordB:String):List[(Int, Int)] = ???

  /**
    * Ok, the Roman Numerals one is harder to do this way, but I'll leave it here for anyone who's keen. You can skip
    * it and head on to the Sudoku exercise if you'd prefer.
    */
  def roman(i:Int):String = ???


  /*
   * Ok, now that's done, time to write a little Sudoku solver, and meet another higher order function: filter
   */

}
