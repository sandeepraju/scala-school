package ch03

import org.scalatest.Assertions.assertThrows

object Ex_3_2 {
  def main(args: Array[String]): Unit = {
    assertThrows[IllegalArgumentException] {
      List.tail(Nil)
    }

    assert(List.tail(Cons('a, Nil)) == Nil)
    assert(List.tail(Cons('a, Cons('b, Nil))) == Cons('b, Nil))
  }
}
