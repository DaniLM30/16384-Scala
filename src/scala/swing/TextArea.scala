/*                     __                                               *\
**     ________ ___   / /  ___     Scala API                            **
**    / __/ __// _ | / /  / _ |    (c) 2007-2013, LAMP/EPFL             **
**  __\ \/ /__/ __ |/ /__/ __ |    http://scala-lang.org/               **
** /____/\___/_/ |_/____/_/ | |                                         **
**                          |/                                          **
\*                                                                      */

package scala.swing

import javax.swing.JTextArea

/**
 * A text component that allows multi-line text input and display.
 *
 * @see javax.swing.JTextArea
 */
class TextArea(text0: String, rows0: Int, columns0: Int) extends TextComponent
    with TextComponent.HasColumns with TextComponent.HasRows {
  override lazy val peer: JTextArea = new JTextArea(text0, rows0, columns0) with SuperMixin
  def this(text: String) = this(text, 0, 0)
  def this(rows: Int, columns: Int) = this("", rows, columns)
  def this() = this("", 0, 0)

  // TODO: we could make contents StringBuilder-like
  def append(t: String): Unit = peer.append(t)

  def rows: Int = peer.getRows
  def rows_=(n: Int): Unit = peer.setRows(n)
  def columns: Int = peer.getColumns
  def columns_=(n: Int): Unit = peer.setColumns(n)

  def tabSize: Int = peer.getTabSize
  def tabSize_=(n: Int): Unit = peer.setTabSize(n)
  def lineCount: Int = peer.getLineCount

  def lineWrap: Boolean = peer.getLineWrap
  def lineWrap_=(w: Boolean): Unit = peer.setLineWrap(w)
  def wordWrap: Boolean = peer.getWrapStyleWord
  def wordWrap_=(w: Boolean): Unit = peer.setWrapStyleWord(w)
  def charWrap: Boolean = !peer.getWrapStyleWord
  def charWrap_=(w: Boolean): Unit = peer.setWrapStyleWord(!w)
}
