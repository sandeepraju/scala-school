package ch03

object Ex_3_16 {
  def main(args: Array[String]): Unit = {

    assert(List.transformByAddingOne(List()) == List())
    assert(List.transformByAddingOne(List(0)) == List(1))
    assert(List.transformByAddingOne(List(0, 0, 0)) == List(1, 1, 1))
    assert(List.transformByAddingOne(List(1, 2, 3)) == List(2, 3, 4))
  }
}
