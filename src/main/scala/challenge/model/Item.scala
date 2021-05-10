package challenge.model


case class Item(cost: BigDecimal,
                taxAmount: BigDecimal,
                shippingFee: BigDecimal,
                product: Product)