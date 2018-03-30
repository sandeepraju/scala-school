package ch03

object Ex_3_27 {
  def main(args: Array[String]): Unit = {
    assert(Tree.depth(Leaf(0)) == 1)
    assert(Tree.depth(Branch(Leaf(0), Leaf(0))) == 2)
    assert(Tree.depth(Branch(Leaf(0), Branch(Branch(Branch(Leaf(1), Leaf(1)), Leaf(9)), Leaf(0)))) == 5)
  }
}
