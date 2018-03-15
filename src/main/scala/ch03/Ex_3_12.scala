package ch03

object Ex_3_12 {
  def main(args: Array[String]): Unit = {
    assert(List.reverse(Nil) == Nil)
    assert(List.reverse(Cons('a, Nil)) == List.apply('a))
    assert(List.reverse(Cons('a, Cons('b, Nil))) == List.apply('b, 'a))
  }
}
