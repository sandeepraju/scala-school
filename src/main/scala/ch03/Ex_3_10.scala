package ch03

object Ex_3_10 {
  def main(args: Array[String]): Unit = {
    def f(b: String, a: Int) =  b + a.toString
    assert(List.foldLeft(List(), "")(f) == "")
    assert(List.foldLeft(List(1), "")(f) == "1")
    assert(List.foldLeft(List(1, 2), "")(f) == "12")
    assert(List.foldLeft(List(4, 5, 3), "")(f) == "453")
  }
}
