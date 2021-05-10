package challenge.model

import java.time.Instant

case class Product(name: String,
                   category: String,
                   price: BigDecimal,
                   weight: Float,
                   createdAt: Instant)
