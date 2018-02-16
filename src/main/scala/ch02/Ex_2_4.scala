package ch02

object Ex_2_4 {
  def main(args: Array[String]): Unit = {
    val f = (a: String) => (b: String) => a + b
    assert(uncurry(f)("A", "B") == "AB")
  }

  def uncurry[A, B, C](f: A => B => C): (A, B) => C = {
    (a: A, b: B) => f(a)(b)
  }
}
