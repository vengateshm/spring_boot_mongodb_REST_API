package com.vengateshm.expensetracker

import com.vengateshm.expensetracker.model.Expense
import com.vengateshm.expensetracker.model.toExpenseDto
import com.vengateshm.expensetracker.repository.ExpenseRepository
import com.vengateshm.expensetracker.service.ExpenseServiceImpl
import io.mockk.every
import io.mockk.justRun
import io.mockk.mockk
import io.mockk.verify
import org.amshove.kluent.`should be equal to`
import org.junit.jupiter.api.Test

class ExpenseServiceImplTest {
    private lateinit var service: ExpenseServiceImpl
    private lateinit var repository: ExpenseRepository

    @Test
    fun `test create expense`() {
        repository = mockk()
        service = ExpenseServiceImpl(repository)

        val expense = Expense(
            expenseId = "1",
            categoryId = "1",
            description = "Milk & Eggs",
            amount = 200.0,
            dateAdded = "06-11-2021"
        )

        every { repository.save(any()) } returns expense

        val createdExpense = service.create(expense.toExpenseDto())

        "1" `should be equal to` createdExpense.expenseId
        "1" `should be equal to` createdExpense.categoryId
        "Milk & Eggs" `should be equal to` createdExpense.description
        200.0 `should be equal to` createdExpense.amount
    }

    @Test
    fun `test get all expenses`() {
        repository = mockk()
        service = ExpenseServiceImpl(repository)

        val expenseList = listOf(
            Expense(
                expenseId = "1",
                categoryId = "1",
                description = "Milk & Eggs",
                amount = 200.0,
                dateAdded = "06-11-2021"
            ),
            Expense(
                expenseId = "2",
                categoryId = "2",
                description = "BP Tablets",
                amount = 600.0,
                dateAdded = "06-11-2021"
            )
        )
        every { repository.findAll() } returns expenseList

        2 `should be equal to` service.getAll().size
    }

    @Test
    fun `test delete all`() {
        repository = mockk()
        service = ExpenseServiceImpl(repository)

        every { repository.deleteAll() } returns Unit
//        every { repository.deleteAll() } just runs
//        every { repository.deleteAll() } answers { }
//        justRun { repository.deleteAll() }

        service.deleteAll()
        verify(exactly = 1) { repository.deleteAll() }
    }

    @Test
    fun `test delete by expense id`() {
        repository = mockk()
        service = ExpenseServiceImpl(repository)

//        every { repository.deleteById(any()) } returns Unit
//        every { repository.deleteById(any()) } just runs
//        every { repository.deleteById(any()) } answers { }
        justRun { repository.deleteById(any()) }

        service.deleteById("1")
        verify(exactly = 1) { repository.deleteById("1") }
    }

    @Test
    fun `test find expense by category id`() {
        repository = mockk()
        service = ExpenseServiceImpl(repository)

        val expenseList = listOf(
            Expense(
                expenseId = "1",
                categoryId = "1",
                description = "Milk & Eggs",
                amount = 200.0,
                dateAdded = "06-11-2021"
            ),
            Expense(
                expenseId = "2",
                categoryId = "1",
                description = "Meat & Fish",
                amount = 600.0,
                dateAdded = "06-11-2021"
            )
        )
        every { repository.findByCategoryId(any()) } returns expenseList

        2 `should be equal to` service.findByCategoryId("1").size

        verify(exactly = 1) { repository.findByCategoryId(any()) }
    }
}