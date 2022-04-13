package module1

import java.time.LocalDate

object adt {

  object tuples {

    /** Tuples ()
      */
    type ProductUnitBoolean = (Unit, Boolean)

    /** Создать возможные экземпляры с типом ProductUnitBoolean
      */

      lazy val p1: ProductUnitBoolean = ((), true)
      lazy val p2: ProductUnitBoolean = ((), false)

    /** Реализовать тип Person который будет содержать имя и возраст
      */

    type Person = (String, Int)

    /**  Реализовать тип `CreditCard` который может содержать номер (String),
      *  дату окончания (java.time.YearMonth), имя (String), код безопастности (Short)
      */

    type CreditCard = (String, java.time.YearMonth, String, Short)

    lazy val cc: CreditCard = ???

  }

  object case_classes {

    /** Case classes
      */

    def getPerson(): (Person, Int) = ???

    //  Реализовать Person с помощью case класса
    case class Person(name: String, age: Int)

    // Создать экземпляр для Tony Stark 42 года
    lazy val tonyStark = Person("Tony Stark", 42)


    // Создать case class для кредитной карты
    case class CreditCard(number: String, expire: java.time.YearMonth, name: String, cvc: Short)

    lazy val cc: CreditCard = ???

  }

  object either {

    /** Sum
      */

    /** Either - это наиболее общий способ хранить один из двух или более кусочков информации в одно время.
      * Также как и кортежи обладает целым рядом полезных методов
      * Иммутабелен
      */

    // trait Ether   Right() extends Either Left() extends Either

    type IntOrString = Either[Int, String]

    /** Реализовать экземпляр типа IntOrString с помощью конструктора Right(_)
      */
    val intOrString: IntOrString = Left(1)

    val intOrString2: IntOrString = Right("")

    final case class CreditCard()
    final case class WireTransfer()
    final case class Cash()

    /** \
      * Реализовать тип PaymentMethod который может быть представлен одной из альтернатив
      */
    type PaymentMethod = Either[CreditCard, Either[WireTransfer, Cash]]

  }

  object sealed_traits {

    /** Также Sum type можно представить в виде sealed trait с набором альтернатив
      */
    sealed trait PaymentMethod
    final case object CreditCard extends PaymentMethod
    final case object WireTransfer extends PaymentMethod
    final case object Cash extends PaymentMethod

    val pm: PaymentMethod = ???

  }

  object cards {

    sealed trait Suit // Clubs | Diamonds | ...

    case object Clubs extends Suit
    case object Diamonds extends Suit
    case object Spades extends Suit
    case object Hearts extends Suit

    sealed trait Rank

    case object Two extends Rank
    case object Three extends Rank
    case object Four extends Rank
    case object Five extends Rank
    case object Six extends Rank
    case object Seven extends Rank
    case object Eight extends Rank
    case object Nine extends Rank
    case object Ten extends Rank
    case object Jack extends Rank
    case object Queen extends Rank
    case object King extends Rank

    case class Card(suit: Suit, rank: Rank)


    type Deck = Set[Card]
    type Hand = Set[Card]

    case class Player(name: String, hand: Hand)

    case class Game(deck: Deck, players: Set[Player])

    type PickupCard = (Hand, Card) => Card

  }

}
