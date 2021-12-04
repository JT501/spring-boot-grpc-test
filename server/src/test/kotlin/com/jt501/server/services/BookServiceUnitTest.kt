package com.jt501.server.services

import com.jt501.server.models.Book
import com.jt501.server.repositories.BookRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean

@SpringBootTest
class BookServiceUnitTest {
    @MockBean
    lateinit var bookRepository: BookRepository

    @Autowired
    lateinit var bookService: BookService

    @Test
    fun whenApplicationStarts_thenHibernateCreatesInitialRecords() {
        val books: List<Book> = bookService.list()

        assertEquals(books.size, 3)
    }
}