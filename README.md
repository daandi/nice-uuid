# NiceUUID
This project aims to provide Tools and Helpers to make working with UUIDs more fun and generally be nice to the user.


[![Scala CI](https://github.com/daandi/nice-uuid/actions/workflows/scala.yml/badge.svg)](https://github.com/daandi/nice-uuid/actions/workflows/scala.yml)

# Features

## UUID String interpolator `uuid` and `u` with compile time checking

The library provides the string interpolators `uuid` and the shorthand `u`.
Using the interpolator makes sure that all strings provided within the interpolator are valid UUIDs. This check happen at compile time.

```scala
import biz.neumann.NiceUUID._

// invalid UUID
scala> uuid"hello-i-am-no-uuid"
<console>:15: error: You provided a malformed UUID: hello-i-am-no-uuid
       uuid"hello-i-am-no-uuid"
       ^
// valid uuid
scala> uuid"9ecce884-47fe-4ba4-a1bb-1a3d71ed6530"
res2: String = 9ecce884-47fe-4ba4-a1bb-1a3d71ed6530
```

##  pimp string with `uuid` method
Adds method `.uuid` to `String`. It is a nice way of calling `Try( UUID.fromString )`.
```scala
import biz.neumann.NiceUUID._

//valid UUID
scala> "9ecce884-47fe-4ba4-a1bb-1a3d71ed6530".uuid
res1: scala.util.Try[java.util.UUID] = Success(9ecce884-47fe-4ba4-a1bb-1a3d71ed6530)


// Invalid UUID
scala> "abc".uuid
res2: scala.util.Try[java.util.UUID] = Failure(java.lang.IllegalArgumentException: Invalid UUID string: abc)

```

## Automatically convert an UUID to a String
This implcit conversion allows to use a `UUID` in place of a `String`
```scala
import biz.neumann.NiceUUID._

scala> def countChars(s: String): Int = s.size
countChars: (s: String)Int

scala> countChars( java.util.UUID.randomUUID )
res3: Int = 36
```

## Compile time checked method , code only compiles if UUID provided is valid
A method, that returns a String encoding a UUID. It is checked at compile time and doesn't compile if given String is a valid UUID.
```scala
//valid
scala> stringEncodingUUID("9ecce884-47fe-4ba4-a1bb-1a3d71ed6530")
res0: String = 9ecce884-47fe-4ba4-a1bb-1a3d71ed6530

invalid
scala> stringEncodingUUID("hello world!")
<console>:14: error: You provided a malformed UUID: hello world!
       stringEncodingUUID("hello world!")

```

# use NiceUUID in your projects

## sbt
add this to your `build.sbt`

```scala
libraryDependencies += "biz.neumann" %% "nice-uuid" % "1.5"
```

## maven

```xml
<dependency>
    <groupId>biz.neumann</groupId>
    <artifactId>nice-uuid_2.12</artifactId>
    <version>1.4</version>
</dependency>
```
