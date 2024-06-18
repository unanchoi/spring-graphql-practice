package com.gql.demo

import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsMutation
import com.netflix.graphql.dgs.DgsQuery

@DgsComponent
class ProductDataFetcher(
    private val dataBase: Database
) {

    @DgsQuery(field = "products")
    fun getProducts(): List<Database.ProductResponse> {
        return dataBase.findAll()
    }

    @DgsMutation
    fun addProduct(title: String, location: String, imageUrl: String, price: Int, content: String?): Database.ProductResponse {
        val product = Product(title, location, imageUrl, price, content)
        return dataBase.save(product)
    }
}