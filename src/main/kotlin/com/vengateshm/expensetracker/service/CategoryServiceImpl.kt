package com.vengateshm.expensetracker.service

import com.vengateshm.expensetracker.dto.CategoryDto
import com.vengateshm.expensetracker.model.Category
import com.vengateshm.expensetracker.model.toCategoryDto
import com.vengateshm.expensetracker.repository.CategoryRepository
import org.springframework.stereotype.Service

@Service
class CategoryServiceImpl(private val categoryRepository: CategoryRepository) : CategoryService {
    override fun create(categoryDto: CategoryDto): CategoryDto {
        return categoryRepository.save(Category(categoryName = categoryDto.name)).toCategoryDto()
    }

    override fun getAll(): List<CategoryDto> {
        return categoryRepository.findAll().map { category -> CategoryDto(category.categoryId, category.categoryName) }
    }

    override fun deleteAll() {
        categoryRepository.deleteAll()
    }
}