package com.example.demo.controller

import com.example.demo.dao.UserDao
import com.example.demo.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class UserController @Autowired constructor(private val userDao: UserDao) {

    @PostMapping("/user")
    fun greeting(@RequestBody user: User): User {
        return userDao.save(user)
    }

    @GetMapping("/user")
    fun getAll(): MutableList<User> {
        return userDao.findAll()
    }
}