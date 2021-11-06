package com.vengateshm.expensetracker.service

import com.vengateshm.expensetracker.dto.ExpenseDto

interface ExpenseService {
    fun create(expenseDto: ExpenseDto): ExpenseDto
    fun getAll(): List<ExpenseDto>
    fun deleteAll()
    fun deleteById(id: String)
    fun findByCategoryId(id: String): List<ExpenseDto>
}