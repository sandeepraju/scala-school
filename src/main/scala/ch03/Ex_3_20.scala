package ch03

object Ex_3_20 {
  def main(args: Array[String]): Unit = {
    assert(List.flatMap(List())(List(_)) == List())
    assert(List.flatMap(List(1))(List(_)) == List(1))
    assert(List.flatMap(List(1, 2, 3, 4, 5))(List(_)) == List(1, 2, 3, 4, 5))
  }
}
