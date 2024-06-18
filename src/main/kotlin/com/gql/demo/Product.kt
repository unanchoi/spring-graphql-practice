package com.gql.demo

import java.time.LocalDateTime

class Product(
    val title: String,
    val location: String,
    val imageUrl: String,
    val price: Int,
    val content: String?,
    val uploadDate: LocalDateTime = LocalDateTime.now()
) {
}