object MyModule {
    val intComparator = (x:Int, y:Int) => x > y
    val stringComparator = (x:String, y:String) => x > y

    def isSorted[A](as:Array[A], f:(A,A) => Boolean): Boolean = {
        @annotation.tailrec
        def go(n:Int): Boolean = {
            if (n+1 >= as.length) true
            else if (f(as(n), as(n+1))) false
            else go(n+1)
        }
        go(0)
    }

    def main(args:Array[String]): Unit = {
        assert(isSorted(Array(), intComparator) == true, "Test #0 failed")
        assert(isSorted(Array(1), intComparator) == true, "Test #1 failed")

        assert(isSorted(Array(1, 1, 2), intComparator) == true, "Test #2 failed")
        assert(isSorted(Array(1, 2, 3), intComparator) == true, "Test #3 failed")
        assert(isSorted(Array(1, 3, 2), intComparator) == false, "Test #4 failed")
        assert(isSorted(Array(3, 2, 1), intComparator) == false, "Test #5 failed")

        assert(isSorted(Array("a", "a"), stringComparator) == true, "Test #6 failed")
        assert(isSorted(Array("a", "b", "c"), stringComparator) == true, "Test #7 failed")
        assert(isSorted(Array("a", "c", "b"), stringComparator) == false, "Test #8 failed")
        assert(isSorted(Array("c", "b", "a"), stringComparator) == false, "Test #9 failed")

        case class Foo(bar:Double)
        assert(isSorted(Array(Foo(bar=1.2), Foo(bar=1.21)), (x:Foo, y:Foo) => x.bar > y.bar) == true, "Test #9 failed")
        assert(isSorted(Array(Foo(bar=1.21), Foo(bar=1.2)), (x:Foo, y:Foo) => x.bar > y.bar) == false, "Test #10 failed")
    }
}
