package com.jt501.server.repositories

import com.jt501.server.models.Book
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface BookRepository: JpaRepository<Book, UUID> {
}