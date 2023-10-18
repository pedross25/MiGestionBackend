package com.example.di

import com.example.data.repository.product.ProductRepository
import com.example.data.repository.product.ProductRepositoryImpl
import com.example.data.repository.user.UserRepository
import com.example.data.repository.user.UserRepositoryImpl
import com.example.service.product.ProductServiceImpl
import com.example.service.user.UserServiceImpl

object RepositoryProvider {
    fun provideUserRepository(): UserRepository = UserRepositoryImpl(UserServiceImpl())
    fun provideProductRepository(): ProductRepository = ProductRepositoryImpl(ProductServiceImpl())
}