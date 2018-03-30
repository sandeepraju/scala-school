package ch03

object Ex_3_28 {
  def main(args: Array[String]): Unit = {
    assert(Tree.map(Leaf(0))(_.toString) == Leaf("0"))
    assert(Tree.map(Branch(Leaf(0), Leaf(0)))(_.toString) == Branch(Leaf("0"), Leaf("0")))
  }
}
