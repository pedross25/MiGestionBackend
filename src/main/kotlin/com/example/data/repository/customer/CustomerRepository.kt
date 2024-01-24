package com.example.data.repository.customer

import com.example.data.models.Customer
import com.example.routes.customer.CreateCustomerParams
import com.example.utils.BaseResponse

interface CustomerRepository {
    suspend fun createCustomer(params: CreateCustomerParams): BaseResponse<Any>

    suspend fun getAllCustomers(): BaseResponse<Any>

}