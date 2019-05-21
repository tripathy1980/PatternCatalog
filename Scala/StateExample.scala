import scroll.internal.support.DispatchQuery
import DispatchQuery._
import scroll.internal.Compartment
import scroll.internal.util.Many._

object StateExample extends App {

  case class StateCompartment() extends Compartment {
    import Relationship._
    //Set Mobile state here
    class MobileAlertState {
      def displayState: Unit ={
        println("Setting mobile state:")
      }
    }

    //Set Mobile in vibration state
    class Vibration {
      def alert(s:String): Unit ={
        println("Vibration mode set for : "+s)
      }
    }

    //Set Mobile in silent state
    class Silent {
      def alert(s:String): Unit = {
        println("Silent mode set for : "+s)
      }
    }

    class MobileContext(ctx:String) {
      var context= ctx
    }
  }

  new StateCompartment {
    var mobileAlertState=new MobileAlertState
    var vibration=new Vibration
    var silent=new Silent
    var mobileContext1=new MobileContext("Context for vibration")
    var mobileContext2=new MobileContext("Context for silent")

    mobileAlertState.displayState
    mobileAlertState play vibration
    +mobileAlertState alert mobileContext1.context

    println("----------------------------")
    mobileAlertState play silent
    +mobileAlertState alert mobileContext2.context
  }
}