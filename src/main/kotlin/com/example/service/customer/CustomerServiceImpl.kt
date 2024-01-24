package com.example.service.customer

import com.example.data.db.extensions.toCustomer
import com.example.data.db.schemas.CustomerTable
import com.example.data.models.Customer
import com.example.data.models.User
import com.example.routes.customer.CreateCustomerParams
import com.example.service.product.ProductService
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.statements.InsertStatement
import org.jetbrains.exposed.sql.transactions.transaction

class CustomerServiceImpl: CustomerService {

    override suspend fun createCustomer(params: CreateCustomerParams): Customer? {
        var statement: InsertStatement<Number>? = null
        transaction {
            statement = CustomerTable.insert {
                it[businessName] = params.businessName
                it[cif] = params.cif
                it[email] = params.email
                it[phoneNumber] = params.phoneNumber
                it[city] = params.city
                it[streetAddress] = params.streetAddress
                it[postalCode] = params.postalCode
                it[state] = params.state
            }
        }
        return statement?.resultedValues?.get(0)?.toCustomer()
    }

    override suspend fun getAllCustomers(): List<Customer?> {
        return transaction {    
            val customers = CustomerTable.selectAll().map { it.toCustomer() }
            if (customers.isEmpty()) {
                emptyList<Customer>()
            }
            customers
        }
    }

}



