package com.example.demo.controller

import com.example.demo.dao.UserDao
import com.example.demo.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.time.Instant
import java.util.*


@RestController
class UserController @Autowired constructor(private val userDao: UserDao) {

    @PostMapping("/users/create")
    fun createUser(@RequestBody user: User): User {
        user.createdAt = Instant.now()
        user.updatedAt = Instant.now()
        return userDao.save(user)
    }

    @PutMapping("/users/update")
    fun updateUser(@RequestBody user: User): User {
        val toModify = userDao.getById(user.id) ?: throw Exception("User ${user.id} does not exist")
        user.createdAt = toModify.createdAt
        user.updatedAt = Instant.now()
        return userDao.save(user)
    }

    @DeleteMapping("/users/delete_all")
    fun deleteAllUsers() {
        return userDao.deleteAll()
    }

    @GetMapping("/users")
    fun getAllUsers(): MutableList<User> {
        return userDao.findAll()
    }

    @GetMapping("/users/{id}")
    fun getUserById(@PathVariable id: Long): User? {
        return userDao.getById(id)
    }

}