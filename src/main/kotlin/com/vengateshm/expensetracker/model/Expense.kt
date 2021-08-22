package com.vengateshm.expensetracker.model

import org.springframework.data.annotation.Id
import org.springframework.data.annotation.TypeAlias
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document(collection = "Expense")
@TypeAlias("expense")
data class Expense(
    @Id
    @Field("id")
    val expenseId: String? = null,
    val categoryId: String,
    val description: String,
    val amount: Double,
    val dateAdded: String
)
