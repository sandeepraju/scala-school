package ch03

object Ex_3_24 {
  def main(args: Array[String]): Unit = {
    assert(List.hasSubsequence(List(1, 2, 3), List(1)))
    assert(List.hasSubsequence(List(1, 2, 3), List()))
    assert(!List.hasSubsequence(List(1, 2, 3), List(3, 2)))
    assert(!List.hasSubsequence(List(1, 2, 3), List(4, 3)))
    assert(!List.hasSubsequence(List(1, 2, 3), List(3, 7)))
    assert(List.hasSubsequence(List(1, 2, 3), List(3)))
    assert(List.hasSubsequence(List(1, 2, 3), List(2, 3)))
    assert(!List.hasSubsequence(List(1, 2, 3), List(1, 3)))
    assert(!List.hasSubsequence(List(1, 2, 3, 4, 5, 6, 7), List(1, 3, 7)))
    assert(List.hasSubsequence(List(1, 2, 3, 4, 5, 6, 7), List(3, 4, 5)))
  }
}
