package ch02

object Ex_2_3 {
  def main(args: Array[String]): Unit = {
    val f = (a: String, b: String) => a + b
    assert(curry(f)("A")("B") == "AB")
  }

  def curry[A, B, C](f: (A, B) => C): A => (B => C) = {
    (a: A) => (b: B) => f(a, b)
  }
}
