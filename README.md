# nice-uuid
This project aims to provide Tools and Helpers to make working with UUIDs more fun and generally be nice to the user.

# Features

## Automatically convert String to an UUID

## Automatically convert an UUID to a String


## UUID String interpolator `uuid`

```scala
import biz.neumann.NiceUUID._

scala> uuid"9ecce884-47fe-4ba4-a1bb-1a3d71ed6530"
res1: java.util.UUID = 9ecce884-47fe-4ba4-a1bb-1a3d71ed6530

```

# Known limitations
Throws an exception om invalid UUID input.
