package ch03

object Ex_3_15 {
  def main(args: Array[String]): Unit = {
    assert(List.concat(List(List('a, 'b), List('c, 'd))) == List('a, 'b, 'c, 'd))
    assert(List.concat(List(List(), List())) == List())
    assert(List.concat(List(List('a), List())) == List('a))
    assert(List.concat(List(List(), List('a))) == List('a))
  }
}
