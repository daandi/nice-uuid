package biz.neumann

import java.util.UUID

import org.scalatest.{Matchers, FlatSpec, WordSpec}

import scala.util.Success

/**
 * Andreas Neumann
 * Email: andreas@neumann.biz
 * Date: 05.07.15
 * Time: 11:44
 */


import NiceUUID._

class NiceUUIDSpec extends FlatSpec with Matchers {

  val exampleUUIDString = "16da0319-4762-4af1-93c1-5dcef6145d03"
  val exampleUUID : UUID =  UUID fromString  exampleUUIDString

  "Nice UUIDs" should "have an implicit conversion form String to UUID" in {
    "16da0319-4762-4af1-93c1-5dcef6145d03".uuid should be( Success(exampleUUID) )
  }

  it should "provide a string interpolator 'uuid' for UUIDs" in {
    // if the uuid string is invalid the test won't compile
    uuid"16da0319-4762-4af1-93c1-5dcef6145d03" should be(exampleUUIDString)
  }

  it should "provide a string interpolator 'u' for UUIDs" in {
    u"16da0319-4762-4af1-93c1-5dcef6145d03" should be(exampleUUIDString)
  }

  /*it should "fail at compile time when provided with an iprovide a string Interpolator for UUIDs" in {
 uuid"invalid16da0319-4762-4af1-93c1-5dcef6145d03" should be(exampleUUID)

 Error:(34, 5) You provided a malformed UUID: invalid16da0319-4762-4af1-93c1-5dcef6145d03
 uuid"invalid16da0319-4762-4af1-93c1-5dcef6145d03" should be(exampleUUID)
 ^
}*/

  it should "provide an implicit conversion from UUID to String" in {
    implicitly[String](exampleUUID) should be(exampleUUIDString)
  }

  "Nice UUID Macros" should "allow strings in source code that encode an UUID" in {
    // if this doesnt work the test would not compile
    stringEncodingUUID("16da0319-4762-4af1-93c1-5dcef6145d03") should be(exampleUUIDString)
  }

  /*
  If you uncomment this the tests will fail telling you that:
  Error:(39, 23) You provided a malformed UUID: abc
    stringEncodingUUID("abc")
                      ^

  it should "not compile" in {
    stringEncodingUUID("abc")
  }
  */



}
