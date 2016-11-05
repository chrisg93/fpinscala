object MyModule {
    def compose[A, B, C](f: B => C, g: A => B): A => C = a => f(g(a))

    def testF(n: Int): Int = n + 2
    def testG(n: Int): Int = n * 3

    def main(args: Array[String]): Unit =
        assert(compose(testF, testG)(2) == 8)
}