package com.vengateshm.expensetracker.service

import com.vengateshm.expensetracker.dto.CategoryDto

interface CategoryService {
    fun create(categoryDto: CategoryDto): CategoryDto
    fun getAll(): List<CategoryDto>
    fun deleteAll()
}