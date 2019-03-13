
trait OutPut[-T] {
  def write[U <: T](x: U) //使用T的子类U来替换T
}

object AAA {

}

