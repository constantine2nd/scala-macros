import java.util.UUID.randomUUID
import com.CacheKeyFromArguments

object TestCacheKey extends App {

  def memoizeSyncWithProvider[A](cacheKey: (String, String, String))(f: => A)(implicit m: Manifest[A]): A = {
    println("Cache key: " + cacheKey)
    f
  }

  def someFunction(father: String, mother: String, son: Option[String], daughter: Option[String]): String = {
    var cacheKey = (randomUUID().toString, randomUUID().toString, randomUUID().toString)
    CacheKeyFromArguments.buildCacheKey {
      memoizeSyncWithProvider (cacheKey) {
        val y: String = father + " - " + mother
        y
      }
    }
  }

  val functionCall = someFunction("Marko", "Emilija", Some("Boris"), Some("Kalina"))
  println(functionCall)
}