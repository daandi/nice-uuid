package biz.neumann


import java.util.UUID

import scala.reflect.macros.whitebox.Context
import scala.util.Try

/**
 * Created by anneumann on 24/07/15.
 */
object UUIDMacrosImpl {

  def safeStringToUUID(s: String): Try[UUID] = Try(UUID fromString s)

  def uuidStringContextImpl(c: Context)(): c.Expr[String] = {
    import c.universe
    import universe._

    val maybeUUID = c.prefix.tree

    maybeUUID match {
      case Apply(_, List(Apply(_, List(Literal(Constant(uuid: String)))))) if safeStringToUUID(uuid).isSuccess =>
        c.Expr[String] (Literal (Constant( uuid )))
      case Apply(_, List(Apply(_, List(Literal(Constant(noValidUUID: String)))))) =>
        c.error(c.enclosingPosition, s"You provided a malformed UUID: $noValidUUID")
        c.Expr[String] (Literal (Constant (s"Invalid UUID: $noValidUUID")))
      case _ =>
        c.error(c.enclosingPosition, s"Unexpected macro input for UUID check: ${universe.showRaw(maybeUUID)}")
        c.Expr[String] (Literal (Constant (s"Invalid Data: $maybeUUID")))
    }
  }

  def uuidStringImpl(c: Context)(uuidString: c.Expr[String]): c.Expr[String] = {
    import c.universe
    import universe._

    uuidString match {
      case Expr(Literal(Constant(uuid: String))) if safeStringToUUID(uuid).isSuccess =>
        c.Expr[String] (Literal (Constant( uuid )))
      case Expr(Literal(Constant(uuid: String))) =>
        c.error(c.enclosingPosition, s"You provided a malformed UUID: $uuid")
        c.Expr[String] (Literal (Constant ("")))
      case _ =>
        c.error(c.enclosingPosition, s"Unexpected macro input for UUID check: ${universe.showRaw(uuidString)}")
        c.Expr[String] (Literal (Constant ("")))
    }
  }

}
