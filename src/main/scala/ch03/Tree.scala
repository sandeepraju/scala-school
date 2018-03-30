package ch03

sealed trait Tree[+A]
case class Leaf[A](value: A) extends Tree[A]
case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]

object Tree {
  // Ex. 3.25
  def size[A](tree: Tree[A]): Int = tree match {
    case Leaf(_) => 1
    case Branch(l, r) => size(l) + size(r) + 1
  }

  // Ex. 3.26
  def maximum(tree: Tree[Int]): Int = tree match {
    case Leaf(value) => value
    case Branch(l, r) => maximum(l) max maximum(r)
  }

  // Ex. 3.27
  def depth[A](tree: Tree[A]): Int = ???

  // Ex. 3.28
  def map[A, B](tree: Tree[A])(f: A => B): Tree[B] = ???

  // Ex. 3.29
  def fold[A, B](tree: Tree[A], acc: B)(f: (A, B) => B): B = ???
}
