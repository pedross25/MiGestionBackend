package com.example.service.user

import com.example.data.models.User
import com.example.routes.auth.CreateUserParams

interface UserService {
    suspend fun reisterUser(params: CreateUserParams): User?
    suspend fun loginUser(email: String, password: String): User?
    suspend fun findUserByEmail(email:String): User?
}