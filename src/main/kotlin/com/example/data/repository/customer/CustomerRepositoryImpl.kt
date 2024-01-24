package com.example.data.repository.customer

import com.example.data.models.Customer
import com.example.routes.customer.CreateCustomerParams
import com.example.service.customer.CustomerService
import com.example.utils.BaseResponse
import io.ktor.http.*

class CustomerRepositoryImpl(
    private val customerService: CustomerService
): CustomerRepository {
    override suspend fun createCustomer(params: CreateCustomerParams): BaseResponse<Any> {
        //TODO Comprobar si exsite un customer con el mismo cif
        val customer = customerService.createCustomer(params)
        return if (customer != null) {
            BaseResponse.SuccessResponse(data = customer)
        } else {
            BaseResponse.ErrorResponse()
        }
    }

    override suspend fun getAllCustomers(): BaseResponse<Any> {
        val customers = customerService.getAllCustomers()
        return BaseResponse.SuccessResponse(data = customers)
    }

}