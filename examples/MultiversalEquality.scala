
case class A()
case class B()

object Main {

  def doesNotCompile1: Unit = {
    import scala.language.strictEquality
    // println(A() == B())
  }
  
  def doesNotCompile2: Unit = {
    // implicit def eqA: Eq[A, A] = Eq
    // println(A() == B())
  }
  
  def doesCompile1: Unit = {
    println(A() == B() )
  }
  
  def doesCompile2: Unit = {
    implicit def eqA: Eq[A, B] = Eq
    println(A() == B())
  }

  def main(arg: Array[String]): Unit = {
    doesNotCompile1
    doesNotCompile2
    doesCompile1
    doesCompile2
  }
}
