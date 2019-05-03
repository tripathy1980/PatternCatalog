package scroll.examples
package designpatterns

//import scroll.examples.currency.Currency
import scroll.internal.support.DispatchQuery.Bypassing
import scroll.internal.util.Log.info
import scroll.internal.Compartment
import scroll.internal.support.DispatchQuery



import java.util.ArrayList
import java.util.HashMap
import java.util.List
import java.util.Map
import java.nio.file.Files
import java.util

//import filesystem.File

//import CompositePattern._
import com.sun.java.util.jar.pack

import scala.beans.{BeanProperty, BooleanBeanProperty}
import scala.reflect.io.Directory

//remove if not needed
import scala.collection.JavaConversions._

import scala.reflect.io.Directory
import scala.reflect.io
import javafx.scene.Parent
import com.sun.java.util.jar.pack.Package

import scala.collection.mutable.ListBuffer
import scala.io.Source
import scala.reflect.io.File
import scala.collection.JavaConversions._
//import scala.collection.mutable.HashMap

//package filesystem

object Composite3 extends App {

  /**
    *
    * Compartment for the Observerpattern including three role types, i.e., FileParent, DirectoryChild, FileChild.
    *
    * @author Thomas Kühn
    *
    */
  class CompositePattern extends Compartment {

    //var root = new Parent
    private val parents: HashMap[Directory, Parent] = new HashMap
    private val dchildren: HashMap[Directory, DirectoryChild] = new HashMap
    private val fchildren: HashMap[File, FileChild] = new HashMap
    // ?? private val root = Parent
    var root:Parent = null



    def this(root: Directory) {
      this()
      this.root = asParent(root)
    }

    /*
  def getRoot: CompositePattern {
    Parent = root
  }
  */

    def asParent(player: Directory): Parent = {
      var result = parents.get(player)
      if (result == null) {
        result = new Parent(player)
        parents.put(player, result)
      }
      result
    }

    def isParent(player: Directory): Boolean = parents.containsKey(player)

    def asChild(player: Directory): CompositePattern#DirectoryChild = {
      var result = dchildren.get(player)
      if (result == null) {
        result = new DirectoryChild(player)
        dchildren.put(player, result)
      }
      result
    }

    def isChild(player: Directory): Boolean = dchildren.containsKey(player)

    def asChild(player: File): CompositePattern#FileChild = {
      var result = fchildren.get(player)
      if (result == null) {
        result = new FileChild(player)
        fchildren.put(player, result)
      }
      result
    }

    def isChild(player: File): Boolean = fchildren.containsKey(player)

    trait Child {
      def sum: Int
      def setParent(p: CompositePattern#Parent): Unit
      def list: String
    }


    class Parent(var p: Directory) extends DirectoryRole(p) {
      private val children = new util.ArrayList[CompositePattern#Child]

      /*def this(p: Directory) {
        this(p)
        //this()
        //this(p)
        //super.p
      }*/


      def add(c: CompositePattern#Child): Boolean = {
        val result = children.add(c)
        if (result) c.setParent(this)
        result
      }

      def sum: Int = {
        var size = 0
        for (c <- children) {
          size += c.sum
        }
        size
      }

      def list: String = {
        val ls = new util.ArrayList[String]
        ls.add(getPlayer.toString)

        for (c <- children) {
          ls.add(c.list)
        }
        String.join("\n", ls)
      }
    }

    class DirectoryChild extends Child {
      private var parent: CompositePattern#Parent = null

      def this(p: Directory) {
        this()
      }

      override def setParent(p: CompositePattern#Parent): Unit = {
        parent = p
      }

      def getParent: CompositePattern#Parent = parent

      override def sum: Int = {
        val p = parents.get(getParent.getPlayer)
        if (p != null) return p.sum
        getParent.getPlayer.getSize
      }

      override def list: String = {
        val p = parents.get(getParent.getPlayer)
        if (p != null) return p.list
        getParent.getPlayer.toString
      }
    }

    class FileChild(val p: File) extends Child {
      private var parent: CompositePattern#Parent = null

       override def setParent(p: CompositePattern#Parent): Unit = {
        parent = p
      }

      def getParent: CompositePattern#Parent = parent

      override def sum: Int = getParent.getPlayer.getSize

      override def list: String = getParent.getPlayer.toString
    }


  }



  class DirectoryRole(var player: Directory) extends Directory {
    this.state = player.state

    def getPlayer: Directory = player
  }

  class Directory {
     var state: Directory#State = null
    state = new State

    protected class State {
      var name = ""
      var size = 0
    }

    def this(name: String) {
      this()
      state = new State
      //Directory#State
      state.name = name
    }

    override def toString: String = "d " + state.name + " (" + state.size + " Byte)"

    def getName: String = state.name

    def getSize: Int = state.size

    def setSize(size: Int): Unit = {
      state.size = size
    }

    final def isSame(d: Directory): Boolean = {
      if (d == null) return false
      this.state eq d.state
    }
  }

  class File {
    state = new State(this)
        //File#State(this)

    protected class State(val id: File) {
      var name = ""
      var size = 0
    }

     var state: File#State = null

    def this(name: String) {
      this()
      state = new State(this)
      state.name = name
    }

    def this(name: String, size: Int) {
      this()
      state = new State(this)
      state.name = name
      state.size = size
    }

    override def toString: String = "- " + state.name + " (" + state.size + " Byte)"

    def getName: String = state.name

    def getSize: Int = state.size

    def append(c: Int): Unit = {
      state.size += 1
    }

    final def isSame(f: File): Boolean = {
      if (f == null) return false
      this.state eq f.state
    }
  }

  class FileRole(var player: File) extends File {
    this.state = player.state

    def getPlayer: File = player
  }

  val dir1 = new Directory("dir1")
  val dir2 = new Directory("dir2")
  val dir3 = new Directory("dir3")
  val fil1 = new Directory("file1")
  val fil2 = new Directory("file2")
  val fil3 = new Directory("file3")

  new CompositePattern(dir1) {

  dir1 play new Parent(dir1)
    dir2 play new DirectoryChild(dir1)
    dir3 play new DirectoryChild(dir1)
    +dir1 add dir2
    +dir1 add dir3

    +dir2 setParent dir1


    info("Directory1 is playing Parent:"+ (+dir1).isPlaying[Parent] )
    info("Directory2 is playing child:"+ (+dir2).isPlaying[DirectoryChild] )
    info("Directory3 is playing child:"+ (+dir3).isPlaying[DirectoryChild] )


    info("size of dir1: "+ +dir1.getSize  )
    info("show the total size"  +(+dir2 sum()))

  }
}

