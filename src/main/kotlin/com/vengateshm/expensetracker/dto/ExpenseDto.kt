package com.vengateshm.expensetracker.dto

data class ExpenseDto(
    val expenseId: String? = null,
    val categoryId: String, // Referenced relationships
    val description: String,
    val amount: Double,
    val dateAdded: String // Date format YYYY-mm-dd
)
