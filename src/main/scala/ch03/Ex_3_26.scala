package ch03

object Ex_3_26 {
  def main(args: Array[String]): Unit = {
    assert(Tree.maximum(Leaf(1)) == 1)
    assert(Tree.maximum(Branch(Leaf(1), Leaf(2))) == 2)
    assert(Tree.maximum(Branch(Branch(
      Branch(Leaf(2), Leaf(8)), Leaf(8)),
      Branch(Leaf(0), Leaf(-9)))) == 8)
  }
}
