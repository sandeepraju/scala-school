package ch03

object Ex_3_3 {
  def main(args: Array[String]): Unit = {
    assert(List.setHead(Nil, 'a) == Cons('a, Nil))
    assert(List.setHead(Cons('b, Cons('c, Nil)), 'a) == Cons('a, Cons('c, Nil)))
  }
}
