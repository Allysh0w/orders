package challenge.cli

import java.time.{Instant, LocalDateTime, ZoneId}
import java.time.format.DateTimeFormatter
import scala.util.matching.Regex

trait Utils {

  def getInstant(str: String): Instant =
    LocalDateTime.parse(
      str,
      DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    ).atZone(ZoneId.systemDefault()).toInstant


  def getInterval(str: String): Interval  = {
    val closedIntervalPattern: Regex = raw"(\d+)-(\d+)".r
    val openIntervalPattern: Regex =  raw">(\d+)".r

    str match {
      case closedIntervalPattern(start, end, _*) => IntervalClosed(start.toInt, end.toInt)
      case openIntervalPattern(start, _*) =>  IntervalOpen(start.toInt)
      case _ => throw new Exception("Error while trying to parse intervals")
    }
  }

}
