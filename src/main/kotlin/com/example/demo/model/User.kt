package com.example.demo.model

import java.time.Instant
import javax.persistence.*

const val userFields = "id, first_name, last_name, email, created_at, updated_at"

@Entity
@Table(name = "users")
class User(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long,
        val firstName: String,
        val lastName: String,
        val email: String,
        var createdAt: Instant,
        var updatedAt: Instant
)
