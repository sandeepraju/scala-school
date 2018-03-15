package ch03

import scala.annotation.tailrec

sealed trait List[+A]
case object Nil extends List[Nothing]
case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List {
  def sum(ints: List[Int]): Int = ints match {
    case Nil => 0
    case Cons(x, xs) => x + sum(xs)
  }

  def product(ds: List[Double]): Double = ds match {
    case Nil => 1.0
    case Cons(0.0, _) => 0.0 // short circuit
    case Cons(x, xs) => x * product(xs)
  }

  def apply[A](as: A*): List[A] =
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail : _*))

  // Ex 3.2
  def tail[A](ls: List[A]): List[A] = ls match {
    case Nil => throw new IllegalArgumentException("List cannot be empty")
    case Cons(_, t) => t
  }

  // Ex 3.3
  def setHead[A](ls: List[A], h: A): List[A] = ls match {
    case Nil => Cons(h, Nil)
    case Cons(_, t) => Cons(h, t)
  }

  // Ex 3.4
  def drop[A](ls: List[A], n: Int): List[A] = n match {
    case n if n <= 0 => ls
    case n => drop(tail(ls), n - 1)
  }

  // Ex 3.5
  def dropWhile[A](ls: List[A], f: A => Boolean): List[A] = ls match {
    case Cons(h, t) if f(h) => dropWhile(t, f)
    case _ => ls
  }

  def append[A](a1: List[A], a2: List[A]): List[A] = a1 match {
    case Nil => a2
    case Cons(h, t) => Cons(h, append(t, a2))
  }

  // Ex 3.6
  def init[A](ls: List[A]): List[A] = ls match {
    case Nil => throw new IllegalArgumentException("List cannot be empty")
    case Cons(_, Nil) => Nil
    case Cons(h, t) => Cons(h, init(t))
  }

  // Listing 3.2
  // Cons(1, Cons(2, Nil)) <===> f(1, f(2, z))
  def foldRight[A, B](as: List[A], z: B)(f: (A, B) => B): B =
    as match {
      case Nil => z
      case Cons(x, xs) => f(x, foldRight(xs, z)(f))
    }

  // Ex 3.7
  // Doesn't look possible in the current implementation

  // Ex 3.8
  // Returns the same list we passed.
  // Shows 1:1 mapping between data constructors of List
  // and foldRight (they are essentially the same)

  // Ex. 3.9
  def length[A](as: List[A]): Int = foldRight(as, 0) { (_, s) => s + 1 }

  // Ex. 3.10
  // Easy approach is to reverse and perform foldRight
  @tailrec
  def foldLeft[A, B](as: List[A], z: B)(f: (B, A) => B): B = as match {
    case Nil => z
    case Cons(x, xs) => foldLeft(xs, f(z, x))(f)
  }
}
