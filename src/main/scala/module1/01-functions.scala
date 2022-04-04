package module1

object functions {


  /**
   * Функции
   */


  /**
   * Реализовать ф-цию  sum, которая будет суммировать 2 целых числа и выдавать результат
   */

   def sum(x: Int, y: Int): Int = x + y

   val r1: Int = sum(2, 3) // 5

   val sum2: (Int, Int) => Int = (x, y) => x + y

   sum2(2, 3) // 5

  val c = sum _




  // Currying

  // val c1 = sum _.curried

  // val v2: Int => Int = c1(2)

  def foo(s: String)(i: Int) = ???

  
  // Partial function

  def divide(x: Int, y: Int): Int = x / y

  val divide2 = new PartialFunction[(Int, Int), Int] {
    override def isDefinedAt(x: (Int, Int)): Boolean = x._2 != 0

    override def apply(v1: (Int, Int)): Int = v1._1 / v1._2
  }

  val strToInt: PartialFunction[String, Int] = {
    case x if x.toIntOption.nonEmpty => x.toInt
  }

  divide2.isDefinedAt(1, 3)



  // SAM Single Abstract Method

  trait Printer{
    def apply(s: String): Unit
  }

  val p: Printer = x => println(x)

  p("Hi")


  /**
   *  Задание 1. Написать ф-цию метод isEven, которая будет вычислять является ли число четным
   */


  /**
   * Задание 2. Написать ф-цию метод isOdd, которая будет вычислять является ли число нечетным
   */


  /**
   * Задание 3. Написать ф-цию метод filterEven, которая получает на вход массив чисел и возвращает массив тех из них,
   * которые являются четными
   */



  /**
   * Задание 4. Написать ф-цию метод filterOdd, которая получает на вход массив чисел и возвращает массив тех из них,
   * которые являются нечетными
   */


  /**
   * return statement
   *
   */
}
