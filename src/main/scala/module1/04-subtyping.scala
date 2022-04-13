package module1

object subtyping{
    /**
   * Type Operators
   */

  trait Vehicle
  trait Car        extends Vehicle
  trait Moto       extends Vehicle
  object Harley    extends Moto
  object Mustang   extends Car

  type IsSubtypeOf[A, B >: A]

  type IsSupertypeOf[A, B <: A]


  /**
   *
   * С помощью типа IsSubtypeOf выразить отношение Car и Vehicle
   *
   */

   val t1 = ???


  /**
   *
   * С помощью типа IsSubtypeOf выразить отношение Car и Mustang
   *
   */

   val t2 = ???


  /**
   *
   * С помощью типа выразить отношение Vehicle и Harley, причем чтобы они шли в этом порядке
   *
   */

   val t3 = ???


  /**
   * В этом примере вам нужно правильно выбрать оператор отношения,
   * чтобы среди идущих ниже выражений, те которые корректны по смыслу компилировались, а остальные нет
   */

  def isInstanceOf[A, B >: A](a: A): Unit = ???




    // lazy val mustCompile1    = isInstanceOf[Car, Mustang.type](Mustang)
    // lazy val mustCompile2    = isInstanceOf[Moto, Harley.type](Harley)
    // lazy val mustNotCompile1 = isInstanceOf[Mustang.type, Moto](Mustang)
    // lazy val mustNotCompile2 = isInstanceOf[Harley.type, Car](Harley)

}