package com.example.demo.model

import java.time.Instant
import javax.persistence.*

@Entity
@Table(name = "users")
data class User(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long,

        @Column(nullable = false)
        val firstName: String,

        @Column(nullable = false)
        val lastName: String,

        @Column(nullable = false)
        val email: String

        //val createdAt: Instant = Instant.now()
)