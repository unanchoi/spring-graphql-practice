package com.gql.demo

import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.util.concurrent.atomic.AtomicInteger

@Component
class Database {

    private val map = mutableMapOf<Int, Product>()
    private val atomicId = AtomicInteger(0)

    @PostConstruct
    fun init() {
        save(
            Product(
                "MacBook Pro",
                "관악구 은천동",
                "https://via.placeholder.com/150",
                2000,
                "The MacBook Pro is a line of Macintosh portable computers introduced in January 2006, by Apple Inc."
            )
        )
        save(
            Product(
                "iPhone 13",
                "관악구 봉천동",
                "https://via.placeholder.com/150",
                1000,
                "The iPhone 13 is a line of smartphones designed, developed, and marketed by Apple Inc."
            )
        )
        save(
            Product(
                "iPad Pro",
                "관악구 삼성동",
                "https://via.placeholder.com/150",
                800,
                "The iPad Pro is a line of iPad tablet computers designed, developed, and marketed by Apple Inc."
            )
        )

    }

    data class ProductResponse(
        val id: Int,
        val title: String,
        val location: String,
        val price: Int,
        val imageUrl: String,
        val uploadDate: LocalDateTime
    )

    fun save(product: Product): ProductResponse {
        val id = atomicId.incrementAndGet()
        map[id] = product
        return ProductResponse(
            id,
            product.title,
            product.location,
            product.price,
            product.imageUrl,
            product.uploadDate
        )
    }

    fun findAll(): List<ProductResponse> {
        return map.map {
            ProductResponse(
                it.key,
                it.value.title,
                it.value.location,
                it.value.price,
                it.value.imageUrl,
                it.value.uploadDate
            )
        }
    }

}