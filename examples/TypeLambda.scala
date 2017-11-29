enum Either[A, B] {
  case Left[A, B](a: A)
  case Right[A, B](b: B)
}

trait Functor[F[_]] {
  def map[A, B](fa: F[A])(f: A => B): F[B]
}

object Syntax {
  implicit class FunctorSyntax[F[_]: Functor, A](fa: F[A]) {
    def map[B](f: A => B): F[B] = implicitly[Functor[F]].map(fa)(f)
  }
}

object Std {
  import Either._
  
  // `[X] => Either[T, X]` is a type lambda
  implicit def EitherRightFunctor[T]: Functor[[X] => Either[T, X]] =
    new Functor[[X] => Either[T, X]] {
      def map[A, B](fa: Either[T, A])(f: A => B): Either[T, B] =
        fa match {
          case Left(x)  => Left(x)
          case Right(x) => Right(f(x))
        }
    }
}

object Main {
  def main(args: Array[String]): Unit = {
    import Either._, Syntax._, Std._
    
    println(Right(1).map(1.+))
  }
}