package ch03

object Ex_3_11 {
  def main(args: Array[String]): Unit = {
    assert(List.sum2(List()) == 0)
    assert(List.sum2(List(1)) == 1)
    assert(List.sum2(List(3, 3)) == 6)
    assert(List.sum2(List(1, 2, 3)) == 6)
  }
}
