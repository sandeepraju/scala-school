package ch03

import org.scalatest.Assertions.assertThrows

object Ex_3_22 {
  def main(args: Array[String]): Unit = {
    assert(List.addCorresponding(List(), List()) == List())
    assert(List.addCorresponding(List(1, 2, 3), List(1, 2, 3)) == List(2, 4, 6))

    assertThrows[IllegalArgumentException] {
      List.addCorresponding(List(1), List(1, 2))
    }
  }
}
