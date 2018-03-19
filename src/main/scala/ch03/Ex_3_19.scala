package ch03

object Ex_3_19 {
  def main(args: Array[String]): Unit = {
    assert(List.filter(List[Int]())(_ % 2 == 0) == List())
    assert(List.filter(List(1))(_ % 2 == 0) == List())
    assert(List.filter(List(1, 2, 3, 4))(_ % 2 == 0) == List(2, 4))
  }
}
