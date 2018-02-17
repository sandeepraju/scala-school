package ch03

sealed trait List[+A]
case object Nil extends List[Nothing]
case class Cons[+A](head: A, tail: List[A]) extends List[A]

object Ex_3_1 {
  def main(args: Array[String]): Unit = {}
}
