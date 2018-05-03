package ch04

sealed trait Option[+A] {

  def map[B](f: A => B): Option[B] = this match {
    case Some(a) => Some(f(a))
  }

  def getOrElse[B >: A](default: => B): B = this match {
    case None => default
    case Some(b) => b
  }

  def flatMap[B](f: A => Option[B]): Option[B] =
    this.map(f) getOrElse None

  def orElse[B >: A](ob: => Option[B]): Option[B] =
    Some(this) getOrElse ob

  def filter(f: A => Boolean): Option[A] = {
    this.map[Option[A]]{ a =>
      if (f(a)) Some(a) else None
    } getOrElse None
  }

}
case class Some[+A](get: A) extends Option[A]
case object None extends Option[Nothing]
