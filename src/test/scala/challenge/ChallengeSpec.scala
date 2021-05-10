package challenge

import challenge.aggregator.Aggregator
import challenge.cli.{CliOptions, Interval, IntervalClosed, IntervalOpen}
import challenge.data.Fixtures

import java.time.Instant
import org.scalatest.matchers.must.Matchers.convertToAnyMustWrapper
import org.scalatest.wordspec.AnyWordSpec

class ChallengeSpec extends AnyWordSpec {
  val mockCliValues: CliOptions = CliOptions(
    Instant.parse("2019-06-01T00:00:00Z"),
    Instant.parse("2022-01-01T00:00:00Z"),
    intervals = Seq[Interval](IntervalClosed(1,3),IntervalClosed(4,6),IntervalClosed(7,12), IntervalOpen(12))
  )

  "aggregator" should {
    " build a map with the counts of number of order with products in an interval" in {
      val agg = Aggregator.aggregator(mockCliValues, Fixtures.orders)
      val expectedResult =
        Map(
          Some(IntervalClosed(4, 6)) -> 2,
          Some(IntervalClosed(7, 12)) -> 3,
          Some(IntervalOpen(12)) -> 5
        )
      agg mustBe expectedResult
    }
  }

  "ExtractAge" should {
    "extract the age of product in months" in {
       Aggregator.extractAge(Fixtures.product1) mustBe 16L
    }
  }


}

