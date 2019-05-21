import scroll.internal.support.DispatchQuery
import DispatchQuery._
import scroll.internal.Compartment
import scroll.internal.util.Many._

object MediatorExample extends App {

  class MediatorCompartment() extends Compartment {
    import Relationship._

    class Mediator() {
      var landStatus = false

      def registerFlight(flight: Flight): Unit ={
        println( flight.display + "is registered to mediator")
      }

      def registerRunway(runway: Runway): Unit ={
       println(runway.display + "is registered to mediator")
      }

      def setLandingStatus(status: Boolean ): Unit ={
        landStatus = status
      }

      def getLandingStatus(): Boolean ={
        landStatus
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
  }


  new MediatorCompartment{
    var mediator = new Mediator
    var atcMediator = new AtcMediator
    var flight= new Flight("sparrow101")
    var runway= new Runway("Main Runway ")
    var colleague= new Colleague
    var status=false

    //ATCMediator is playing the mediator role
    //Flight & Runway play the colleague role. They communicated via mediator
    atcMediator play mediator
    flight play colleague
    runway play colleague

    //Colleagues get registered with mediator
    +atcMediator registerFlight flight
    +atcMediator registerRunway runway

    println("----------------------------------")
    println("ATCMediator is communicating between Flight & Runway")
    +flight isReady "Flight"
    atcMediator.display()
    status = +runway isReady "Runway"
    +atcMediator setLandingStatus status
    +flight landingStatus status
  }

}