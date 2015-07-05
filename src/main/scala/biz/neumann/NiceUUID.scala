package biz.neumann

import scala.language.experimental.macros
import scala.reflect.macros.Context


import java.util.UUID


/**
 * Andreas Neumann
 * Email: andreas@neumann.biz
 * Date: 05.07.15
 * Time: 11:39
 */
object NiceUUID {

  implicit class StringEncodingUUID (val s: String) extends AnyRef {
    def uuid: UUID = UUID fromString s
  }

  implicit def uuidToString(uuid: UUID) : String = uuid.toString

  implicit class UUIDContext (val sc : StringContext) {
    def uuid: UUID = UUID.fromString(sc.parts.mkString)
  }

  case class RichUUID(uuid: StringEncodingUUID)

  def stringUUID(uuidString: String) : UUID = macro uuidStringImpl

  def uuidStringImpl(c: Context, uuidString: c.Expr[String]) : c.Expr[UUID] = ???


}
