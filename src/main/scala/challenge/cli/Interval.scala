package challenge.cli

trait Interval {
  val start: Int
  def checkValue(value: Long): Boolean
}
case class IntervalClosed(start: Int, end: Int) extends Interval {
  override def checkValue(value: Long): Boolean = value >= start && value <= end
}

case class IntervalOpen(start: Int) extends Interval {
  override def checkValue(value: Long): Boolean = value >= start
}
