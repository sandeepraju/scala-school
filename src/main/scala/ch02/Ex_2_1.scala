package ch02

import scala.annotation.tailrec

object Ex_2_1 {
  def main(args: Array[String]): Unit = {
    assert(fib(0) == 0)
    assert(fib(1) == 1)
    assert(fib(2) == 1)
    assert(fib(3) == 2)
    assert(fib(4) == 3)
    assert(fib(5) == 5)
  }

  def fib(n: Int): Int = {
    @tailrec
    def fibNumbers(a: Int, b: Int, n: Int): Int = n match {
      case 0 => a
      case _ => fibNumbers(b, a + b, n - 1)
    }

    fibNumbers(0, 1, n)
  }

  def fibNonTailRecursive(n: Int): Int = n match {
    case 0 => 0
    case 1 => 1
    case _ => fibNonTailRecursive(n - 1) + fibNonTailRecursive(n - 2)
  }
}
