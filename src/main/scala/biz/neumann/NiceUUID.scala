package biz.neumann

import scala.language.experimental.macros
import java.util.UUID
import scala.util.Try

object NiceUUID {

  implicit def uuidToString(uuid: UUID) : String = uuid.toString

  implicit class StringEncodingUUID(val possibleUUID: String) extends AnyVal {
    def uuid : Try[UUID] = UUIDMacrosImpl.safeStringToUUID(possibleUUID)
  }

  def stringEncodingUUID(uuidString: String) : String = macro UUIDMacrosImpl.uuidStringImpl

  implicit class UUIDContext(val maybeUUID: StringContext) {
    def uuid(): String = macro UUIDMacrosImpl.uuidStringContextImpl
    def u(): String = macro UUIDMacrosImpl.uuidStringContextImpl
  }

}
