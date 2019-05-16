import scroll.internal.support.DispatchQuery
import DispatchQuery._
import scroll.internal.Compartment
import scroll.internal.util.Many._

object State2 extends App {

  case class StateCompartment() extends Compartment {

    import Relationship._
    class MobileAlertState {
      def displayState: Unit ={
        println("Setting mobile state:")
      }
    }

    class Vibration {
      def alert(s:String): Unit ={
        println("Vibration mode set for : "+s)
      }
    }

    class Silent {
      def alert(s:String): Unit = {
        println("Silent mode set for : "+s)
      }
    }

    class MobileContext(c:String)
    {
      var context= c

    }


  }


  new StateCompartment {
    var mobileAlertState=new MobileAlertState
    var vibration=new Vibration
    var silent=new Silent
    var mobileContext1=new MobileContext("Context1")


    mobileAlertState.displayState
    mobileAlertState play vibration
    +mobileAlertState alert mobileContext1.context

    mobileAlertState play silent
    +mobileAlertState alert mobileContext1.context

  }
}