package challenge.aggregator

import challenge.cli.{CliOptions, Interval, IntervalClosed, IntervalOpen}
import challenge.model.{Order, Product}
import com.typesafe.scalalogging.LazyLogging

import java.time.{Duration, Instant}

object Aggregator
  extends LazyLogging {

  def aggregator(cliOptions: CliOptions,
                 orders: List[Order]):  Map[Option[Interval], Int] =
    orders
      .filter(order => order.placedAt.isAfter(cliOptions.start) && order.placedAt.isBefore(cliOptions.end))
      .flatMap(x => {
        x.items.map(y => (x.id, findInterval(extractAge(y.product), cliOptions.intervals)))
      })
      .groupBy(x => x._2)
      .map(x => x._1 -> x._2.distinct.size)


  def extractAge(product: Product): Long =
    Duration.between(product.createdAt, Instant.now()).toDays / 30

  def findInterval(v: Long, intervals: Seq[Interval]): Option[Interval] = {
    intervals.find(i => i.checkValue(v))
  }

  def processResult(res: Map[Option[Interval], Int]): Unit = {
        res
          .toList
          .filter(_._1.isDefined)
          .sortBy(_._1.get.start)
          .foreach(group => {
          group._1 match {
            case Some(IntervalClosed(start, end)) =>
              logger.info(s"$start - $end months: ${group._2} orders")
            case Some(IntervalOpen(start)) =>
              logger.info(s">$start months: ${group._2} orders")
            case _ =>
              logger.info(s"Empty result for: ${group._2} orders")
          }
        })

  }

}
