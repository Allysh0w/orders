# Orders

Scala cli program to calculate if older product are still being sold.
Given a time range and an optional set of month interval it can outputs the number of orders that have products with the given age.

# Assembly application
To build the application use:
 ```
sbt assembly
```

The program will be generated at `./target/scala-2.13/challenge.jar`.

How to use:

```java -jar ./target/scala-2.13/challenge.jar -s "2019-01-01 00:00:00" -e "2021-01-01 00:00:00"```


# CLI Usage
```
Challenge 0.1
Usage: Challenge [options]

  -s, --start <value>      start datetime | pattern: yyyy-MM-dd HH:mm:ss
  -e, --end <value>        end datetime | pattern: yyyy-MM-dd HH:mm:ss
  -i, --intervals <value>  array intervals | example: 1-3,4-6,7-12,>12
```


# Example output:

```
java -jar target/scala-2.13/challenge.jar -s "2018-01-01 00:00:00" -e "2022-01-01 00:00:00"

[main] INFO  challenge.aggregator.Aggregator$ - 4 - 6 months: 2 orders
[main] INFO  challenge.aggregator.Aggregator$ - 7 - 12 months: 3 orders
[main] INFO  challenge.aggregator.Aggregator$ - >12 months: 5 orders
```

To test the application:
 ```
sbt test
```