package challenge.cli

import java.time.Instant

case class CliOptions(start: Instant,
                      end: Instant,
                      intervals: Seq[Interval])

object CliOptions {
  def default: CliOptions = CliOptions(
    Instant.now(),
    Instant.now(),
    Seq[Interval](IntervalClosed(1,3),IntervalClosed(4,6),IntervalClosed(7,12), IntervalOpen(12))
  )
}