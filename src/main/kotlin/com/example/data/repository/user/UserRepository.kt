package com.example.data.repository.user

import com.example.routes.auth.CreateUserParams
import com.example.routes.auth.UserLoginParams
import com.example.utils.BaseResponse

interface UserRepository {
    suspend fun registerUser(params: CreateUserParams): BaseResponse<Any>
    suspend fun loginUser(params: UserLoginParams): BaseResponse<Any>
}