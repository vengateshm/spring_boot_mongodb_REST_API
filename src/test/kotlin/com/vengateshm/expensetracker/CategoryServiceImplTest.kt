package com.vengateshm.expensetracker

import com.vengateshm.expensetracker.dto.CategoryDto
import com.vengateshm.expensetracker.model.Category
import com.vengateshm.expensetracker.repository.CategoryRepository
import com.vengateshm.expensetracker.service.CategoryServiceImpl
import io.mockk.*
import org.amshove.kluent.`should be equal to`
import org.junit.jupiter.api.Test

class CategoryServiceImplTest {

    private lateinit var service: CategoryServiceImpl
    private lateinit var repository: CategoryRepository

    @Test
    fun `test create category`() {
        repository = mockk()
        service = CategoryServiceImpl(repository)

        val category = Category(
            categoryId = "1",
            categoryName = "Groceries"
        )

        every { repository.save(any()) } returns category

        val createdCategory = service.create(CategoryDto(id = null, name = "Groceries"))

        "1" `should be equal to` createdCategory.id
        "Groceries" `should be equal to` createdCategory.name
    }

    @Test
    fun `test get all categories`() {
        repository = mockk()
        service = CategoryServiceImpl(repository)

        val categoryList = listOf(
            Category(
                categoryId = "1",
                categoryName = "Groceries"
            ),
            Category(
                categoryId = "2",
                categoryName = "Public Transport"
            ),
            Category(
                categoryId = "3",
                categoryName = "Medicine"
            )
        )
        every { repository.findAll() } returns categoryList

        3 `should be equal to` service.getAll().size
    }

    @Test
    fun `test delete all`() {
        repository = mockk()
        service = CategoryServiceImpl(repository)

        every { repository.deleteAll() } returns Unit
//        every { repository.deleteAll() } just runs
//        every { repository.deleteAll() } answers { }
//        justRun { repository.deleteAll() }

        service.deleteAll()
        verify(exactly = 1) { repository.deleteAll() }
    }
}