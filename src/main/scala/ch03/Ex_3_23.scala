package ch03

import org.scalatest.Assertions.assertThrows

object Ex_3_23 {
  def main(args: Array[String]): Unit = {
    def f[A, B](a: A, b: B) = a.toString + b.toString
    assert(List.zipWith(List(), List())(f) == List())
    assert(List.zipWith(List(1, 2, 3), List(1, 2, 3))(f) == List("11", "22", "33"))

    assertThrows[IllegalArgumentException] {
      List.zipWith(List(1), List(1, 2))(f)
    }
  }
}
