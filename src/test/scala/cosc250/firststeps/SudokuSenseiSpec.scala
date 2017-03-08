package cosc250.firststeps

import org.scalatest._


/**
  * This is a specification file for ScalaTest. It's a set of unit tests written in a way that's designed to be
  * read easily.
  */
class SudokuSenseiSpec extends FlatSpec with Matchers {

  import SudokuSensei._

  "parseGrid" should "parse the sample grid correctly" in {
    grid1.get((0, 0)) should be(None)
    grid1.get((2, 2)) should be(Some(1))
  }

  "row" should "identify the positions in a row" in {
    row((3, 4)).toSet should be (
      (0 until 9).map((_, 4)).toSet
    )
  }

  "column" should "identify the positions in a column" in {
    column((3, 4)).toSet should be (
      (0 until 9).map((3, _)).toSet
    )
  }

  "quadrant" should "identify the positions in a quadrant" in {
    quadrant((3, 4)).toSet should be (
      (for { i <- 3 until 6; j <- 3 until 6} yield (i,j)).toSet
    )
  }


  "possibilitiesFor" should "identify possible numbers for a location" in {
    possibilitiesFor((0, 0), grid1) should be (Seq(2, 3, 4))
  }

  "nextMove" should "identify the first available location where there is only one possibility" in {
    nextMoves(grid1).toSet should be (Seq(
      (3,4) -> 9,
      (7,8) -> 2,
      (8,3) -> 9
    ).toSet)
  }

}
