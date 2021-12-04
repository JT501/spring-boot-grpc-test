package com.jt501.server.services

import com.jt501.server.models.Book
import com.jt501.server.repositories.BookRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BookService {
    @Autowired
    lateinit var bookRepository: BookRepository

    fun list(): List<Book> = bookRepository.findAll()
}