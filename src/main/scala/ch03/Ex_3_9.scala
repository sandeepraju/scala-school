package ch03

object Ex_3_9 {
  def main(args: Array[String]): Unit = {
    assert(List.length(List()) == 0)
    assert(List.length(List(1)) == 1)
    assert(List.length(List(1, 2)) == 2)
    assert(List.length(List(1, 2, 3, 4)) == 4)
  }
}
