package ch02

import scala.annotation.tailrec

object Ex_2_2 {
  def main(args: Array[String]): Unit = {
    assert(isSorted[Int](Array(), (a, b) => { a < b }))
    assert(isSorted[Int](Array(1), (a, b) => { a < b }))
    assert(isSorted[Int](Array(1, 2), (a, b) => { a < b }))
    assert(!isSorted[Int](Array(2, 1), (a, b) => { a < b }))
    assert(isSorted[Int](Array(1, 2, 3, 4), (a, b) => { a < b }))
    assert(!isSorted[Int](Array(1, 6, 7, 4), (a, b) => { a < b }))
  }

  def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): Boolean = {

    @tailrec
    def isSortedRecursive(idx: Int): Boolean = idx match {
      case 0 | 1 => true
      case _ => ordered(as(idx - 2), as(idx - 1)) && isSortedRecursive(idx - 1)
    }

    isSortedRecursive(as.length)
  }
}
