import scroll.internal.support.DispatchQuery
import DispatchQuery._
import scroll.internal.Compartment
import scroll.internal.util.Many._

object ObjectAdapterExample extends App {

  case class ObjectAdapterCompartment() extends Compartment {
    import Relationship._
    class PaymentAdapter{
      def pay(str:String): Unit ={
        println("The payment amount = "+ str)
      }
    }

    class PaypalAdapter{
      def display: Unit ={
        println("Payment by Paypal...")
      }
    }

    class MoneyBookerAdapter{
      def display: Unit ={
        println("Payment by Money Booker...")
      }
    }
  }

  new ObjectAdapterCompartment{
    var paymentAdapter=new PaymentAdapter
    var paypalAdapter=new PaypalAdapter
    var moneyBookerAdapter=new MoneyBookerAdapter

    //Payment by Paypal
    paypalAdapter.display
    paypalAdapter play paymentAdapter
    +paypalAdapter pay "1234"

    println("-------------------------")

    //Payment by Money Brooker
    moneyBookerAdapter.display
    moneyBookerAdapter play paymentAdapter
    +moneyBookerAdapter pay "5678"

  }
}
