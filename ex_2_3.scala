object MyModule {
    def curry[A,B,C](f: (A, B) => C): A => B => C =
      (a: A) => (b: B) => f(a, b)

    case class Person(name: String, age: Int)
    def testFunction(n: String, a: Int): Person = Person(name=n, age=a)

    def main(args:Array[String]): Unit = {
        assert(curry(testFunction)("foo")(5) == Person(name="foo", age=5))
    }
}
