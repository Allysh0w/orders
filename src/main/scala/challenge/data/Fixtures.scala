package challenge.data

import challenge.model.{Item, Order, Product}

import java.time.Instant
import java.util.UUID

object Fixtures {
  val product1: Product = Product("product-1", "category-A", BigDecimal(2.43), 5.3f,
    Instant.parse("2020-01-01T00:00:00.00Z"))
  val product2: Product = Product("product-2", "category-A", BigDecimal(3.65), 2.4f,
    Instant.parse("2020-03-19T00:00:00.00Z"))
  val product3: Product = Product("product-3", "category-B",  BigDecimal(54.76), 1.5f,
    Instant.parse("2020-02-22T00:00:00.00Z"))
  val product4: Product = Product("product-4", "category-F",  BigDecimal(76.33), 1.8f,
    Instant.parse("2020-04-11T00:00:00.00Z"))
  val product5: Product = Product("product-5", "category-B",  BigDecimal(12.23), 0.5f,
    Instant.parse("2020-05-20T00:00:00.00Z"))
  val product6: Product = Product("product-6", "category-C",  BigDecimal(4.76), 0.9f,
    Instant.parse("2020-06-02T00:00:00.00Z"))
  val product7: Product = Product("product-7", "category-D",  BigDecimal(23.87), 1.0f,
    Instant.parse("2020-07-30T00:00:00.00Z"))
  val product8: Product = Product("product-8", "category-E",  BigDecimal(92.34), 4.3f,
    Instant.parse("2020-08-27T00:00:00.00Z"))
  val product9: Product = Product("product-9", "category-B",  BigDecimal(6.65), 6.4f,
    Instant.parse("2020-09-23T00:00:00.00Z"))
  val product10: Product = Product("product-10", "category-C",  BigDecimal(100.12), 5.3f,
    Instant.parse("2020-10-24T00:00:00.00Z"))
  val product11: Product = Product("product-11", "category-E", BigDecimal(65.57),  0.2f,
    Instant.parse("2020-11-19T00:00:00.00Z"))
  val product12: Product = Product("product-12", "category-A",  BigDecimal(5.14), 2.2f,
    Instant.parse("2020-12-13T00:00:00.00Z"))

  val item1: Item = Item( product1.price * 1.43, BigDecimal(0.23), product1.price * 0.22, product1)
  val item2: Item = Item( product2.price * 1.4, BigDecimal(0.43), product2.price * 0.12, product2)
  val item3: Item = Item( product3.price * 1.23, BigDecimal(0.54), product3.price * 0.44, product3)
  val item4: Item = Item( product4.price * 1.11, BigDecimal(0.65), product4.price * 0.32, product4)
  val item5: Item = Item( product5.price * 1.23, BigDecimal(0.21), product5.price * 0.56, product5)
  val item6: Item = Item( product6.price * 1.12, BigDecimal(0.53), product6.price * 0.43, product6)
  val item7: Item = Item( product7.price * 1.34, BigDecimal(0.76), product7.price * 0.11, product7)
  val item8: Item = Item( product8.price * 1.05, BigDecimal(0.32), product8.price * 0.43, product8)
  val item9: Item = Item( product9.price * 1.09, BigDecimal(0.12), product9.price * 0.02, product9)
  val item10: Item = Item(product10.price * 1.8, BigDecimal(0.76), product10.price * 0.1, product10)
  val item11: Item = Item(product11.price * 1.21, BigDecimal(0.43), product11.price * 0.15, product11)
  val item12: Item = Item(product12.price * 1.15, BigDecimal(0.22), product12.price * 0.2, product12)

  val orders = List(
    Order(UUID.randomUUID(), "1233-1456", "customerA", "A Address", BigDecimal(276.23), Instant.parse("2020-04-22T00:00:00.00Z"), List(item2, item3, item1)),
    Order(UUID.randomUUID(), "4532-5432", "customerB", "B Address", BigDecimal(132.64), Instant.parse("2020-04-03T00:00:00.00Z"), List(item4)),
    Order(UUID.randomUUID(), "5432-7654", "customerC", "C Address", BigDecimal(453.65), Instant.parse("2020-02-13T00:00:00.00Z"), List(item5, item4, item6)),
    Order(UUID.randomUUID(), "1423-5432", "customerD", "D Address", BigDecimal(653.23), Instant.parse("2020-07-23T00:00:00.00Z"), List(item9, item9, item6, item8)),
    Order(UUID.randomUUID(), "5432-6543", "customerE", "E Address", BigDecimal(123.54), Instant.parse("2020-08-06T00:00:00.00Z"), List(item12, item4, item10)),
    Order(UUID.randomUUID(), "6543-8765", "customerF", "F Address", BigDecimal(453.76), Instant.parse("2020-11-25T00:00:00.00Z"), List(item1, item7, item11)),
  )

}