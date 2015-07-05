package biz.neumann

import java.util.UUID

import org.scalatest.{Matchers, FlatSpec, WordSpec}

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
    "16da0319-4762-4af1-93c1-5dcef6145d03".uuid should be(exampleUUID)
  }

  it should "provide a string Interpolator for UUIDs" in {
    uuid"16da0319-4762-4af1-93c1-5dcef6145d03" should be(exampleUUID)
  }
  
  it should "provide an implicit conversion from UUID to String" in {
    implicitly[String](exampleUUID) should be(exampleUUIDString)
    
    
  }

}
