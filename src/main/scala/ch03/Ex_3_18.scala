package ch03

object Ex_3_18 {
  def main(args: Array[String]): Unit = {
    assert(List.map(List(1, 2, 3))(_.toString) == List("1", "2", "3"))
    assert(List.map(List(1))(_.toString) == List("1"))
    assert(List.map(List())(_.toString) == List())
  }
}
