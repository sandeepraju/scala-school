package ch03

object Ex_3_5 {
  def main(args: Array[String]): Unit = {
    def isEven(x: Int) = x % 2 == 0
    assert(List.dropWhile(List(), isEven) == List())
    assert(List.dropWhile(List(1, 3, 5), isEven) == List(1, 3, 5))
    assert(List.dropWhile(List(1, 2, 3, 4, 5), isEven) == List(1, 3, 5))
  }
}
