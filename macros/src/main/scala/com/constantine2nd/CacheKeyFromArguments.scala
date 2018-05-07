package com.constantine2nd

import scala.language.experimental.macros
import scala.language.higherKinds

package object CacheKeyFromArguments {

  def buildCacheKey[V](f: => V): V = macro CacheKeyFromArgumentsMacro.buildCacheKeyImpl[V]

}
