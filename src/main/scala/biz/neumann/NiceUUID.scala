package biz.neumann

import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context


import java.util.UUID

import scala.util.Try


/**
 * Andreas Neumann
 * Email: andreas@neumann.biz
 * Date: 05.07.15
 * Time: 11:39
 */
object NiceUUID {

  def safeStringToUUID(s: String): Try[UUID] = Try(UUID fromString s)

  implicit def uuidToString(uuid: UUID) : String = uuid.toString

  implicit class UUIDContext (val sc : StringContext) {
    def uuid() : UUID = safeStringToUUID(sc.parts.mkString).get
  }

  implicit class StringEncodingUUID(val possibleUUID: String) extends AnyVal {
    def uuid : Try[UUID] = safeStringToUUID(possibleUUID)
  }

  def stringEncodingUUID(uuidString: String) : String = macro uuidStringImpl

  def uuidStringImpl(c: Context)(uuidString: c.Expr[String]) : c.Expr[String] = {
    import c.universe
    import universe._

   uuidString match {
     case Expr(Literal(Constant(uuid : String))) if safeStringToUUID(uuid).isSuccess =>
       c.Expr[String] (Literal (Constant( uuid )))
     case Expr(Literal(Constant(uuid : String))) =>
       c.error (c.enclosingPosition, s"You provided a malformed UUID: $uuid")
       c.Expr[String] (Literal (Constant ("")))
     case _ =>
       c.error (c.enclosingPosition, s"Unexpected macro input for UUID check: ${universe.showRaw(uuidString)}")
       c.Expr[String] (Literal (Constant ("")))
   }

  }


}
