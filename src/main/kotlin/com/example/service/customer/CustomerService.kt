package com.example.service.customer

import com.example.data.models.Customer
import com.example.routes.customer.CreateCustomerParams
import com.example.utils.BaseResponse

interface CustomerService {
    suspend fun createCustomer(params: CreateCustomerParams): Customer?

    suspend fun getAllCustomers(): List<Customer?>
}