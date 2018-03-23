package ch03

import org.scalatest.Assertions.assertThrows

object Ex_3_4 {
  def main(args: Array[String]): Unit = {
    assert(List.drop(List(), 0) == List())
    assertThrows[IllegalArgumentException] {
      List.drop(List(), 5)
    }
    assertThrows[IllegalArgumentException] {
      List.drop(List(1), 5)
    }
    assert(List.drop(List(1), 0) == List(1))
    assert(List.drop(List(1), 1) == List())
    assert(List.drop(List(1, 2, 3), 0) == List(1, 2, 3))
    assert(List.drop(List(1, 2, 3), 1) == List(2, 3))
    assert(List.drop(List(1, 2, 3), 3) == List())
    assertThrows[IllegalArgumentException] {
      List.drop(List(1, 2, 3), 4)
    }
  }
}
