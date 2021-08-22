package com.vengateshm.expensetracker.model

import org.springframework.data.annotation.Id
import org.springframework.data.annotation.TypeAlias
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document(collection = "Category")
@TypeAlias("category")
data class Category(
    @Id
    @Field(name = "id")
    val categoryId: String? = null,
    @Field(name = "name")
    val categoryName: String
)
