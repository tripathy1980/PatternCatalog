import scroll.internal.support.DispatchQuery
import DispatchQuery._
import scroll.internal.Compartment
import scroll.internal.util.Many._

object Mediator2 extends App {

  class MediatorPattern() extends Compartment {
    import Relationship._

    class Mediator() {

      var land = false
      def registerFlight(flight: Flight): Unit ={
        println( flight.display + "is registered to mediator")
      }

      def registerRunway(runway: Runway): Unit ={
       println(runway.display + "is registered to mediator")
      }

      def setLandingStatus(status: Boolean ): Unit ={
        land = status
      }
      def getLandingStatus(): Boolean ={
        land
      }


    }

    class AtcMediator() {

      def display(): Unit ={
        println("redirecting to mediator....")
      }

    }

    class Colleague() {

      def landingStatus(status:Boolean): Unit={
      if (status)
       println("Landing...")
        else
        println("Waiting for landing....")
      }

      def isReady(s:String): Boolean =
      {
        println( s+ " is ready for landing...")
        return true
      }

    }



    class Flight(name:String)
    {
      def display(): Unit = {
        println("Flight Number:  " + name)

      }
    }
    class Runway(name: String)
    {
      def display(): Unit = {
        println("Runway name: "+ name)
      }
    }


   /* RoleGroup("ConcreteMediator").containing[ConcreteMediator1, ConcreteMediator2](1, 1)(2, 2)

    RoleEquivalence[Mediator, ConcreteMediator1]()

    RoleEquivalence[Mediator, ConcreteMediator2]()

    val MediatorColleague = Relationship("MediatorColleague").from[Mediator](1).to[Colleague](0 To *)

    AddRoleRestriction[GenericMediator, Mediator]

    AddRoleRestriction[GenericMediator, ConcreteMediator1]

    AddRoleRestriction[GenericMediator, ConcreteMediator2]

    AddRoleRestriction[GenericColleague, Colleague]*/
  }
  new MediatorPattern{
    var mediator = new Mediator
    var atcMediator = new AtcMediator
    var flight= new Flight("sparrow101")
    var runway= new Runway("Main Runway ")
    var colleague= new Colleague
    var x=false


    atcMediator play mediator
    flight play colleague
    runway play colleague



    +atcMediator registerFlight flight
    +atcMediator registerRunway runway

    +flight isReady "Flight"
    atcMediator.display()
    x = +runway isReady "Runway"
    +atcMediator setLandingStatus x
    +flight landingStatus x







  }

}