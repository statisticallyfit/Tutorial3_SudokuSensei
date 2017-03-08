package cosc250.firststeps

/**
  * We're going to create a little Sudoku teacher. It won't solve the whole puzzle, but it'll tell you if there's an
  * obvious next move.
  *
  * If you've never played Sudoku before, you can find how to play it here:
  * http://www.sudoku.com/
  *
  */
object SudokuSensei {

  /**
    * First, let's introduce the concept of a type alias. This is where we give a convenient name to an existing type.
    * In this case, we've said that a Position in our grid is going to be an (Int, Int)
    *
    * It's still a tuple -- we can still say `val(x, y) = pos` to extract x and y, but we can refer to the type as
    * a Position.
    */
  type Position = (Int, Int)

  /**
    * Let's define a case class for a move -- putting a number in a position
    */
  case class Move(p:Position, n:Int)

  /**
    * And let's type alias Grid as a Map from Position to Int
    */
  type Grid = Map[Position, Int]

  /**
    * First, let's define a function that'll parse our Sudoku grid from a multi-line string.
    * We'll use '.' for an empty space, and a number is a number. So, here's a few grids
    */
  def parseGrid(gridString:String):Grid = {
    val split = gridString.split('\n')

    // Notice the for notation -- this turns into flatMap, map, and filterWith
    // the "if" in this part of the for notation translates to filterWith -- another higher order function
    // also notice `0 until 9` produces `Seq(0,1,2,3,4,5,6,7,8)`
    val tuples:Seq[(Position, Int)] = for {
      x <- 0 until 9
      y <- 0 until 9 if split(y).charAt(x).isDigit
    } yield (x, y) -> split(y).charAt(x).toString.toInt // if we just do char to int, we get the character code not the number

    tuples.toMap
  }

  /**
    * And now let's create a sample Sudoku that we'll work from
    */
  val grid1:Grid = parseGrid(
    """
      |...1.5.68
      |......7.1
      |9.1....3.
      |..7.26...
      |5.......3
      |...87.4..
      |.3....8.5
      |1.5......
      |79.4.1...
    """.stripMargin.trim)


  /*
   * Ok, now I've done some set-up for you, let's get into the exercise
   * In Sudoku, a number has to be unique in its row, in its column, and in its quadrant.
   */

  /**
    * Let's start with a function that, given a Position, will produce all the positions in
    * that row. For example, row((1, 2)) would produce
    * Seq( (0,2), (1,2), (2,2), (3,2), (4,2), (5,2), (6,2), (7,2), (8,2), (9,2) )
    *
    * Don't forget, Position is just an alias for a tuple (Int, Int)
    */
  def row(pos:Position):Seq[Position] = {
    ???
  }

  /**
    * Now let's make a function that will return all the Positions in the same column
    */
  def column(pos:Position):Seq[Position] = {
    ???
  }

  /**
    * For the quadrant, for both the horizontal and vertical axis, we're going to need to see
    * which group of three a number is in
    * 0, 1, 2 or 3, 4, 5 or 6, 7, 8
    *
    * So let's define that as a function. (No higher order functions required here)
    */
  def whichThree(n:Int):Seq[Int] = {
    ???
  }

  /**
    * And then let's use that function to return all the positions in the same quadrant.
    */
  def quadrant(pos:Position):Seq[Position] = {
    ???
  }

  /**
    * row, column, and quadrant are all functions from Position to Seq[Position]
    *
    * We can put them into a sequence if we want. A collection of functions!
    *
    * We have to give the value the type annotation
    * Seq[Position => Seq[Position]], otherwise when we put the functions into the list the
    * compiler is going to think we are trying to call them but forgot the parameters.
    */
  val positionFunctions:Seq[Position => Seq[Position]] = Seq(row, column, quadrant)


  /**
    * Now let's define a function that can take a grid, a number, and a sequence of positions,
    * and tell us if any of those positions contains that number.
    *
    * Don't forget, not all the positions will have been set in the grid - some might be empty.
    * You can use getOrElse(key, default) to return a default value.
    *
    * And you might want to use the exists method -- a higher order function on sequences.
    */
  def numberPresentIn(grid:Grid, n:Int, positions:Seq[Position]):Boolean = {
    ???
  }

  /**
    * Now let's define a function that takes a position and a grid, and returns what numbers
    * could go in that position. All we're going to do here is take the numbers from 1 to 9,
    * and filter out the numbers that cannot go there (because they are already present in
    * that row, column, or quadrant).
    *
    * filter is yet another higher order function!
    * Though you might want its inverse: filterNot
    *
    * Extra bonus (but not necessary): you can nest two higher order functions, if you have
    * positionFunctions.exists(...
    */
  def possibilitiesFor(pos:Position, grid:Grid):Seq[Int] = {
    ???
  }

  /**
    * Now let's put it all together. Scan the grid, from (0,0) to (8,8), looking for any
    * positions that can be filled in automatically -- that is, there is only one possibility for
    * what number goes there.
    */
  def nextMoves(grid:Grid):Seq[(Position, Int)] = {
    ???
  }

}
