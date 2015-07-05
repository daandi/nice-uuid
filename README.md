# nice-uuid
This project aims to provide Tools and Helpers to make working with UUIDs more fun and generally be nice to the user.

https://codeship.com/projects/YOUR_PROJECT_UUID/status?branch=master

# Features

## UUID String interpolator `uuid`
```scala
import biz.neumann.NiceUUID._


//valid UUID
scala> uuid"9ecce884-47fe-4ba4-a1bb-1a3d71ed6530"
res1: java.util.UUID = 9ecce884-47fe-4ba4-a1bb-1a3d71ed6530


// Invalid UUID
scala> "abc".uuid
res0: scala.util.Try[java.util.UUID] = Falure(java.lang.IllegalArgumentException: Invalid UUID string: abc
```

##  pimp string with `uuid` method

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

```scala
import biz.neumann.NiceUUID._

scala> def countChars(s: String): Int = s.size
countChars: (s: String)Int

scala> countChars( java.util.UUID.randomUUID )
res3: Int = 36
```

## Compile time checked method , code only compiles if UUID provided is valid

```scala
//valid
scala> stringEncodingUUID("9ecce884-47fe-4ba4-a1bb-1a3d71ed6530")
res0: String = 9ecce884-47fe-4ba4-a1bb-1a3d71ed6530

invalid
scala> stringEncodingUUID("hello world!")
<console>:14: error: You provided a malformed UUID: hello world!
       stringEncodingUUID("hello world!")

```
