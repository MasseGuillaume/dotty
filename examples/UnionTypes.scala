// scalaVersion := "0.4.0-bin-20171009-953a385-NIGHTLY"

import java.io.PrintStream

trait A

class JavaLib {
  def stdout: PrintStream | A = System.out
}

object Main {
  // (new JavaLib).stdout.println()

  def main(args: Array[String]): Unit =
    (new JavaLib).stdout match {
      // case p: PrintStream => p.println("hi")
      // case null           => throw new Exception("Ooops")
      case p  => p.println("hi")
    }
}