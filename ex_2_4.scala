object MyModule {
    def uncurry[A, B, C](f: A => B => C): (A, B) => C = (a: A, b:B) => f(a)(b)

    case class Person(name: String, age: Int)
    def testFunction(n: String): Int => Person = (a: Int) => Person(name=n, age=a)

    def main(args: Array[String]): Unit = {
        assert(uncurry(testFunction)("foo", 42) == Person(name="foo", age=42))
    }
}
