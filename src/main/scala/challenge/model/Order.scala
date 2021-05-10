package challenge.model

import java.time.Instant
import java.util.UUID

case class Order(id: UUID,
                 contact: String,
                 customerName: String,
                 addressShipping: String,
                 total: BigDecimal,
                 placedAt: Instant,
                 items: List[Item])
