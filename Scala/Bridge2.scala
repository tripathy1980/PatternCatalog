import scroll.internal.support.DispatchQuery
import DispatchQuery._
import scroll.internal.Compartment
import scroll.internal.util.Many._

object Bridge2 extends App {


  case class BridgeCompartment() extends Compartment {
    import Relationship._
    var produce=new Produce
    var assemble=new Assemble
    class Vehicle{
      def display(s:String): Unit ={
        println(s+" needs to be manufatured...")
      }

    }

    class Car
    {
      def manufacture(workshop: Workshop): Unit ={
        println("Car manufacturing...")
        var s= "Car"
        workshop.display(s)
        workshop play produce
        +workshop work s
        workshop play assemble
        +workshop work s

      }
    }
    class Bike
    {
      def manufacture(workshop: Workshop): Unit ={
        println("Bike manufacturing...")
        var s= "Bike"
        workshop.display(s)
        workshop play produce
        +workshop work s
        workshop play assemble
        +workshop work s
      }
    }
    class Workshop
    {
      def display(s:String): Unit ={
        println(s+" is in workshop...")
      }
    }
  class Produce
    {
      def work(s:String): Unit ={
        println("Production of "+ s+" is complete...")
      }
    }
    class Assemble{
      def work(s:String): Unit ={
        println("Assembly of "+s+" is complete...")
      }
    }
  }
new BridgeCompartment{
  var vehicle1=new Vehicle
  var vehicle2 = new Vehicle
  var car = new Car
  var bike = new Bike
  var workshop1=new Workshop
  var workshop2=new Workshop
 var s="Car"

  vehicle1 play car
  vehicle1.display(s)
  +vehicle1 manufacture workshop1

 s="Bike"
  vehicle2 play bike
  vehicle2.display(s)
  +vehicle2 manufacture workshop2

}
}