package com.example.di

import com.example.data.repository.albaran.AlbaranRepository
import com.example.data.repository.albaran.AlbaranRepositoryImpl
import com.example.data.repository.customer.CustomerRepository
import com.example.data.repository.customer.CustomerRepositoryImpl
import com.example.data.repository.invoice.InvoiceRepository
import com.example.data.repository.invoice.InvoiceRepositoryImpl
import com.example.data.repository.product.ProductRepository
import com.example.data.repository.product.ProductRepositoryImpl
import com.example.data.repository.user.UserRepository
import com.example.data.repository.user.UserRepositoryImpl
import com.example.service.albaran.AlbaranServiceImpl
import com.example.service.customer.CustomerServiceImpl
import com.example.service.invoice.InvoiceServiceImpl
import com.example.service.product.ProductServiceImpl
import com.example.service.user.UserServiceImpl

object RepositoryProvider {
    fun provideUserRepository(): UserRepository = UserRepositoryImpl(UserServiceImpl())
    fun provideProductRepository(): ProductRepository = ProductRepositoryImpl(ProductServiceImpl())
    fun provideCustomerRespository(): CustomerRepository = CustomerRepositoryImpl(CustomerServiceImpl())
    fun provideAlbaranRespository(): AlbaranRepository = AlbaranRepositoryImpl(AlbaranServiceImpl())
    fun provideInvoiceRespository(): InvoiceRepository = InvoiceRepositoryImpl(InvoiceServiceImpl())
}