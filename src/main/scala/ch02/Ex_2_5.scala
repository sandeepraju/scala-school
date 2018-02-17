package ch02

object Ex_2_5 {
  def main(args: Array[String]): Unit = {
    val twice = (s: String) => s * 2
    val thrice = (s: String) => s * 3

    assert(compose(twice, thrice)("") == "")
    assert(compose(twice, thrice)("*") == "******")
    assert(compose(thrice, twice)("*") == "******")
  }

  def compose[A, B, C](f: B => C, g: A => B): A => C = {
    (a: A) => f(g(a))
  }
}
