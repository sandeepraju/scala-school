package ch03

object Ex_3_29 {
  def main(args: Array[String]): Unit = {
    val f = (value: String, acc: String) => acc + value
    assert(Tree.fold(Leaf("0"), "")(f) == "0")
    assert(Tree.fold(Branch(Leaf("0"), Leaf("1")), "")(f) == "01")
  }
}
