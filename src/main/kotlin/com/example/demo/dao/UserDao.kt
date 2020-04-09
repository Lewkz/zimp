package com.example.demo.dao

import com.example.demo.model.User
import com.example.demo.model.userFields
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface UserDao : JpaRepository<User, Long> {
    fun getOneByEmail(email: String?): User?

    @Query("SELECT $userFields FROM users WHERE users.id = :paramId", nativeQuery = true)
    fun getById(@Param("paramId") id: Long): User?
}