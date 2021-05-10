package challenge

import challenge.aggregator.Aggregator
import challenge.cli.CliService
import challenge.data.Fixtures
import com.typesafe.scalalogging.LazyLogging

import scala.util.{Failure, Success, Try}

object Main
  extends App
    with CliService
    with LazyLogging {

  Try {
    val parser = createParser
    transformArgs(args, parser)
  } match {
    case Success(cliOptions) =>
      Aggregator.processResult(
        Aggregator.aggregator(cliOptions, Fixtures.orders)
      )
    case Failure(exception) =>
      logger.error(s"Failed with: ${exception.getMessage}")
  }
}