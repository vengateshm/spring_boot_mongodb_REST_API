package com.vengateshm.expensetracker.model

import com.vengateshm.expensetracker.dto.CategoryDto
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

fun Category.toCategoryDto() = CategoryDto(
    id = this.categoryId,
    name = this.categoryName
)
