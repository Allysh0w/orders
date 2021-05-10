package challenge.cli
import scopt.{OParser, OParserBuilder}

trait CliService extends Utils {

    def transformArgs(args: Array[String],
                 parser: OParser[Unit, CliOptions]): CliOptions =
      OParser.parse(parser, args, CliOptions.default) match {
        case Some(prs) =>
          prs
        case _ =>
          throw new IllegalArgumentException("Error while trying to parse arguments, please try again!")
      }

  def parserBuilder: OParserBuilder[CliOptions] =
    OParser.builder[CliOptions]


  def createParser: OParser[Unit, CliOptions] = {
      val builder =  parserBuilder

      val startArgument = builder.opt[String]('s', "start")
        .action((x, c) => c.copy(start = getInstant(x) ))
        .text("start datetime | pattern: yyyy-MM-dd HH:mm:ss")

      val endArgument = builder.opt[String]('e', "end")
        .action((x, c) => c.copy(end = getInstant(x) ))
        .text("end datetime | pattern: yyyy-MM-dd HH:mm:ss")

      val intervalArgument = builder.opt[Seq[String]]('i', "intervals")
        .action((x, c) => c.copy(intervals = x.map(getInterval)))
        .text("array intervals | example: 1-3,4-6,7-12,>12")

        OParser.sequence(
          builder.programName("challenge"),
          builder.head("Challenge", "0.1"),
          startArgument,
          endArgument,
          intervalArgument
        )
  }
}
