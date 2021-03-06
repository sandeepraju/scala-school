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
    case Nil => Nil
    case Cons(h, t) if f(h) => dropWhile(t, f)
    case Cons(h, t) => Cons(h, dropWhile(t, f))
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

  // Ex. 3.11
  def sum2(ints: List[Int]): Int = foldLeft(ints, 0)(_ + _)

  def product2(ds: List[Double]): Double = foldLeft(ds, 1.0)(_ * _)

  // Ex. 3.12
  def reverse[A](as: List[A]): List[A] = foldLeft(as, Nil: List[A]) { (list, item) => Cons(item, list) }

  // Ex. 3.13 (Hard)
  // Easy but probably stupid approach: reverse and use foldRight/foldLeft
  def foldLeftUsingFoldRight[A, B](as: List[A], z: B)(f: (B, A) => B): B = ???
  def foldRightUsingFoldLeft[A, B](as: List[A], z: B)(f: (A, B) => B): B = ???

  // Ex. 3.14
  def appendUsingFoldRight[A](ls1: List[A], ls2: List[A]): List[A] =
    foldRight(ls1, ls2) { (item, list) => Cons(item, list) }

  // Ex. 3.15 (Hard)
  // Complexity: O(n) where n is the sum of number of elements of all lists
  def concat[A](ls: List[List[A]]): List[A] =
    foldLeft(ls, Nil:List[A]) { (acc, item) =>
      appendUsingFoldRight(acc, item)
    }

  // Ex. 3.16
  def transformByAddingOne(ls: List[Int]): List[Int] =
//    ls match {
//    case Nil => Nil
//    case Cons(x, xs) => Cons(x + 1, transformByAddingOne(xs))
//  }
  foldRight(ls, Nil:List[Int]) { (item, acc) => Cons(item + 1, acc)}

  // Ex. 3.17
  def transformDoubleToString(ls: List[Double]): List[String] =
    foldRight(ls, Nil:List[String]) { (item, acc) => Cons(item.toString, acc) }

  // Ex. 3.18
  def map[A, B](as: List[A])(f: A => B): List[B] = foldRight(as, Nil: List[B]) { (item, acc) => Cons(f(item), acc)}

  // Ex. 3.19
  def filter[A](as: List[A])(f: A => Boolean): List[A] =
    foldRight(as, Nil: List[A]) { (item, acc) => if (f(item)) Cons(item, acc) else acc }

  // Ex. 3.20
  def flatMap[A, B](as: List[A])(f: A => List[B]): List[B] =
    foldLeft(map(as)(f), Nil: List[B]) { (acc, item) => append(acc, item) }

  def flatMapWithoutFold[A, B](as: List[A])(f: A => List[B]): List[B] = as match {
    case Nil => Nil
    case Cons(h, t) => append(f(h), flatMapWithoutFold(t)(f))
  }

  // The most intuitive implementation of flatMap: map, then flatten it
  def flatMapWithoutFold2[A, B](as: List[A])(f: A => List[B]): List[B] =
    concat(map(as)(f))

  // Ex. 3.21
  // Implement filter using flatMap
  def filter2[A](as: List[A])(f: A => Boolean): List[A] =
    flatMap(as)(item => if (f(item)) List(item) else Nil)

  // Ex. 3.22
  // TODO: ask how to define type that can be added (addable)
  def addCorresponding(ls1: List[Int], ls2: List[Int]): List[Int] = (ls1, ls2) match {
    case (Nil, Nil) => Nil
    case (Cons(h1, t1), Cons(h2, t2)) => Cons(h1 + h2, addCorresponding(t1, t2))
    case (_, _) => throw new IllegalArgumentException("Both the lists have to be of equal length")
  }

  // Ex. 3.23
  def zipWith[A,B,C](ls1: List[A], ls2: List[B])(f: (A,B) => C): List[C] = (ls1, ls2) match {
    case (Nil, Nil) => Nil: List[C]
    case (Cons(h1, t1), Cons(h2, t2)) => Cons(f(h1, h2), zipWith(t1, t2)(f))
    case (_, _) => throw new IllegalArgumentException("Both the lists have to be of equal length")
  }

  def take[A](ls: List[A], n: Int): List[A] = ls match {
    case Nil => Nil
    case _ if n == 0 => Nil
    case Cons(h, t) => Cons(h, take(t, n - 1))
  }

  // Ex. 3.24
  // NOTE: Here, the meaning of subsequence is different from how it
  // is used in math. Here, subsequence just means contiguous sequence
  // (kind of similar to substring... rather sublist?)
  // The most optimal algorithm is the KMP; complexity: O(n+k)
  // where n -> length of string (or the text)
  // and k -> length of substring (query) being searched
  // The algorithm implemented below is sub optimal (naive)
  // O(n*2k) == O(n*k)
  def hasSubsequence[A](sup: List[A], sub: List[A]): Boolean = {

    val lenSub = List.length(sub)

    def hs(ls: List[A]): Boolean = ls match {
      case Nil => false
      case Cons(_, t) =>
        if (List.take(ls, lenSub) == sub) true
        else hs(t)
    }

    if (lenSub > List.length(sup)) false else hs(sup)
  }
}
