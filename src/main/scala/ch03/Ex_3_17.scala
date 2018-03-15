package ch03

object Ex_3_17 {
  def main(args: Array[String]): Unit = {
    assert(List.transformDoubleToString(List(1.0, 2.3)) == List("1.0", "2.3"))
    assert(List.transformDoubleToString(List(3.4)) == List("3.4"))
    assert(List.transformDoubleToString(List()) == List())
  }
}
