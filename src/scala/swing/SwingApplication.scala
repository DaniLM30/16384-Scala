/*                     __                                               *\
**     ________ ___   / /  ___     Scala API                            **
**    / __/ __// _ | / /  / _ |    (c) 2007-2013, LAMP/EPFL             **
**  __\ \/ /__/ __ |/ /__/ __ |    http://scala-lang.org/               **
** /____/\___/_/ |_/____/_/ | |                                         **
**                          |/                                          **
\*                                                                      */

package scala.swing

/** Convenience class with utility methods for GUI applications. */
abstract class SwingApplication extends Reactor {

  /** Initializes the application and runs the given program. */
  def main(args: Array[String]): Unit = Swing.onEDT { startup(args) }

  /** Called before the GUI is created. Override to customize. */
  def startup(args: Array[String]): Unit

  /** Finalizes the application by calling `shutdown` and exits.*/
  def quit(): Unit = { shutdown(); sys.exit(0) }

  /** Called before the application is exited. Override to customize. */
  def shutdown(): Unit = ()
}
