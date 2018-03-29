package ch03

object Ex_3_25 {
  def main(args: Array[String]): Unit = {
    assert(Tree.size(Leaf(1)) == 1)
    assert(Tree.size(Branch(Leaf(1), Leaf(2))) == 3)
    assert(Tree.size(Branch(Leaf(1), Branch(Leaf(2), Leaf(3)))) == 5)
  }
}
