object MyModule {
    val testString = "fib(%d) = %d != %d"

    def fib(n:Int): Int = {
        @annotation.tailrec
        def go(n:Int, a:Int, b:Int): Int = {
            if (n <= 0) a
            else go(n-1, b, a+b)
        }

        go(n, 0, 1)
    }
    
    def main(args:Array[String]): Unit = {
        assert(fib(-1) == 0, testString.format(-1, fib(-1), 0))

        assert(fib(0) == 0, testString.format(0, fib(0), 0))
        assert(fib(1) == 1, testString.format(1, fib(1), 1))
        assert(fib(2) == 1, testString.format(2, fib(2), 1))
        assert(fib(3) == 2, testString.format(3, fib(3), 2))
        assert(fib(4) == 3, testString.format(4, fib(4), 3))
        assert(fib(5) == 5, testString.format(5, fib(5), 5))
        assert(fib(6) == 8, testString.format(6, fib(6), 8))
    }
}