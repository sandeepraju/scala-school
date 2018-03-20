package ch03

object Ex_3_21 {
  def main(args: Array[String]): Unit = {
    assert(List.filter2(List[Int]())(_ % 2 == 0) == List())
    assert(List.filter2(List(1))(_ % 2 == 0) == List())
    assert(List.filter2(List(1, 2, 3, 4))(_ % 2 == 0) == List(2, 4))
  }
}
