package ch03

object Ex_3_14 {
  def main(args: Array[String]): Unit = {
    assert(List.appendUsingFoldRight(List.apply('a, 'b), List.apply('c, 'd))
      == List.apply('a, 'b, 'c, 'd))
    assert(List.appendUsingFoldRight(Nil:List[Symbol], Nil:List[Symbol]) == List())
    assert(List.appendUsingFoldRight(List('a, 'b), Nil:List[Symbol]) == List('a, 'b))
    assert(List.appendUsingFoldRight(Nil:List[Symbol], List('a, 'b)) == List('a, 'b))
  }
}
