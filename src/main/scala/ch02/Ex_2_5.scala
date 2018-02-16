package ch02

object Ex_2_5 {
  def main(args: Array[String]): Unit = {
    val twox = (s: String) => s * 2
    val threex = (s: String) => s * 3
    
    assert(compose(twox, threex)("") == "")
    assert(compose(twox, threex)("*") == "******")
  }

  def compose[A, B, C](f: B => C, g: A => B): A => C = {
    (a: A) => f(g(a))
  }
}
