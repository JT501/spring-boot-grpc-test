package com.jt501.server.models

import java.util.*
import javax.persistence.*

@Entity(name = "Book")
@Table(name = "books")
class Book {
    @Id
    @Column(name = "id", nullable = false)
    val id: UUID? = null

    val name: String? = null

    @Column(name = "email")
    var email: String? = null
}