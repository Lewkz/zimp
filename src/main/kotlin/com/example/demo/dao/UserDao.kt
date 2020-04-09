package com.example.demo.dao

import com.example.demo.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserDao : JpaRepository<User, Long> {
    fun getOneByEmail(email: String?): User?
}