package com.vengateshm.expensetracker.repository

import com.vengateshm.expensetracker.model.Category
import org.springframework.data.mongodb.repository.MongoRepository

interface CategoryRepository : MongoRepository<Category, String> {
}