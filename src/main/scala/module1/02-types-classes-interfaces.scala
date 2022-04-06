package module1

import sun.security.util.Password

import java.io.{Closeable, File}
import scala.io.{BufferedSource, Source}


object type_system {

  /**
   * Scala type system
   *
   */

  // AnyVal

  //


  // Unit



  // Null


  // Nothing

  def absurd(v: Nothing) = ???


  // Generics

  // работа с ресурсом

  lazy val file: File = ???

  lazy val source: BufferedSource = Source.fromFile(file)

  lazy val lines: Iterator[String] = source.getLines()

  // source.close()

  lazy val lines2: Iterator[String] = try{

    source.getLines()
  } finally {
    source.close()
  }

  def ensureClose[S <: Closeable, T](resource: S)(f: S => T): T = {
    try{
      f(resource)
    } finally {
      resource.close()
    }
  }

  lazy val lines3 = ensureClose(Source.fromFile(file))(_.getLines())




  // ограничения связанные с дженериками

  def print(seq: Seq[Int]): Unit = ???

  lazy val se1: Seq[Int] = ???
  lazy val se2: Seq[String] = ???

  // print(se1)
  // print(se2)


  /**
   *
   * class
   *
   * конструкторы / поля / методы / компаньоны
   */

   class User private(_email: String, _password: String){
      val a = ???
      var B = ???
      def this(email: String) = this(email, "")

      def foo: Int = ???
   }

   object User{
     def from(email: String, password: String) = new User(email, password)
     def from(email: String) = new User(email, "password")
   }

   lazy val u = User.from("foo", "")
   lazy val u2 = new User("foo")







  /**
   * Задание 1: Создать класс "Прямоугольник"(Rectangle), мы должны иметь возможность создавать прямоугольник с заданной
   * длиной(length) и шириной(width), а также вычислять его периметр и площадь
   *
   */

  class Rectangle2(val length: Int, val width: Int) {
    def p: Int = (length * 2) + (width * 2)
    def s: Int = length * width
  }


  class Rectangle(val length: Int = 2, val width: Int = 4){
    def square: Int = length*width
    def p: Int = (length + width) * 2
  }

  final case class Rectangle3(length: Int, width: Int)

  val r3 = Rectangle3(2, 4)
  val r4 = r3.copy(width = 8)

  object Rectangle{
    def apply(x: Int): Rectangle = new Rectangle(x, x)
  }
  Rectangle.apply(2)



  object Foo{
    println("Foo")
  }

lazy val foo: Foo.type = ???




  /**
   * object
   *
   * 1. Паттерн одиночка
   * 2. Линивая инициализация
   * 3. Могут быть компаньоны
   */




  /**
   * case class
   *
   */


  // создать case класс кредитная карта с двумя полями номер и cvc






  /**
   * case object
   *
   * Используются для создания перечислений или же в качестве сообщений для Акторов
   */



  /**
   * trait
   *
   */


   trait UserService{
    def get(id: String): User
    def insert(user: User): Unit
    def bar: Unit
    def foo: String
  }

  class UserServiceImpl extends UserService with WithId {
    def get(id: String): User = ???

    def insert(user: User): Unit = ???

    override def typedId: UserId = ???

    override val bar: Unit = ???

    override def foo: String = ???
  }


  trait WithId{
    type UserId
    def typedId: UserId
  }

  class A {
    def foo() = "A"
  }

  trait B extends A {
    override def foo() = "B" + super.foo()
  }

  trait C extends B {
    override def foo() = "C" + super.foo()
  }

  trait D extends A {
    override def foo() = "D" + super.foo()
  }

  trait E extends C {
    override def foo(): String = "E" + super.foo()
  }

  // A -> D -> B -> C
  val v = new A with D with C with B // CBDA

  // A -> B -> C -> E -> D
  val v1 = new A with E with D with C with B // DECBA







  /**
   * Value classes и Universal traits
   */


}