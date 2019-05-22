import scroll.internal.support.DispatchQuery
import DispatchQuery._
import scroll.internal.Compartment
import scroll.internal.util.Many._

object ClassAdapterExample extends App {

  class ClassAdapterCompartment() extends Compartment {
    import Relationship._

    //GermanPlugConnector & GermanElectricalSocket are Compatible
    class GermanPlugConnector{
      def giveElectricity():Unit={
        println("Germany Electricity connection successful from UK plug connector")
      }
    }

    class GermanElectricalSocket{
      def plugIn(plug: GermanPlugConnector):Unit={
        plug.giveElectricity()
      }
    }

    //UKPlugConnector & UKElectricalSocket are compatible
    class UKPlugConnector{
      def provideElectricity():Unit={
        println("UK Electricity connection successful from German Plug Connector")
      }
    }

    class UKElectricalSocket{
      def plugIn(plug: UKPlugConnector):Unit={
        plug.provideElectricity()
      }
    }


    //Adapter For German plug in UK Connection
    class GermanToUKPlugConnectorAdapter(){
      var germanPlugConnector = new GermanPlugConnector

      def GermanToUKAdapter(plug: GermanPlugConnector):Unit={
        this.germanPlugConnector= plug
      }

      //override def provideElectricity
    }

    //Adapter for Uk plug in German connection
    class UkToGermanPlugConnectorAdapter(){
      var uKPlugConnector= new UKPlugConnector

      def UkToGermanAdapter(plug: UKPlugConnector): Unit={
        this.uKPlugConnector=plug
      }

      //override def giveElectricity
    }

  }

  new ClassAdapterCompartment{
    var germanToUKPlugConnectorAdapter=new GermanToUKPlugConnectorAdapter
    var germanPlugConnector=new GermanPlugConnector
    var uKElectricalSocket=new UKElectricalSocket
    var uKPlugConnector=new UKPlugConnector

    uKPlugConnector play germanToUKPlugConnectorAdapter
    germanToUKPlugConnectorAdapter.germanPlugConnector = germanPlugConnector
    uKElectricalSocket.plugIn(uKPlugConnector)

    //For test role playing
    //println("uKPlugConnector is playing as Adapter:" + (+uKPlugConnector).isPlaying[GermanToUKPlugConnectorAdapter])

    //Test 2: Germany Electricity connection successful from UK plug
    /*
    var ukToGermanPlugConnectorAdapter=new UkToGermanPlugConnectorAdapter
    var germanElectricalSocket=new GermanElectricalSocket

    println("")
    germanPlugConnector play ukToGermanPlugConnectorAdapter
    ukToGermanPlugConnectorAdapter.uKPlugConnector=uKPlugConnector
    germanElectricalSocket.plugIn(germanPlugConnector)
    */
  }

}