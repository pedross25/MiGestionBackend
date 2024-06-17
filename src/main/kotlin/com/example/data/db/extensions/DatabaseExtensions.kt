package com.example.data.db.extensions

import com.example.data.db.schemas.*
import com.example.data.models.*
import org.jetbrains.exposed.sql.ResultRow

fun ResultRow?.toUser(): User? {
    return if (this == null) null
    else User(
        id = this[UserTable.id],
        fullName = this[UserTable.fullName],
        avatar = this[UserTable.avatar],
        email = this[UserTable.email],
        createdAt = this[UserTable.createdAt].toString(),
    )
}

fun ResultRow?.toProduct(): Product? {
    return if (this == null) null
    else Product(
        id = this[ProductTable.id],
        name = this[ProductTable.name],
        amount = this[ProductTable.amount],
        price = this[ProductTable.price],
        category = this[ProductTable.category],
        template = this[ProductTable.template],
        description = this[ProductTable.description],
        invoice = this[ProductTable.invoiceId],
        parentId = this[ProductTable.parentId],
        createdAt = this[ProductTable.createdAt].toString()
    )
}

fun ResultRow?.toCustomer(): Customer? {
    return if (this == null) null
    else Customer(
        id = this[CustomerTable.id],
        businessName = this[CustomerTable.businessName],
        cif = this[CustomerTable.cif],
        streetAddress = this[CustomerTable.streetAddress],
        email = this[CustomerTable.email],
        city = this[CustomerTable.city],
        state = this[CustomerTable.state],
        phoneNumber = this[CustomerTable.phoneNumber],
        postalcode = this[CustomerTable.postalCode],
        createdAt = this[CustomerTable.createdAt].toString()
    )
}

fun ResultRow?.toAlbaran(produts: List<Int>): Albaran? {
    return if (this == null) null
    else Albaran(
        id = this[AlbaranTable.id],
        customer = this[AlbaranTable.customer],
        createdAt = this[AlbaranTable.fecha].toString(),
        albarans = produts
    )
}

fun ResultRow?.toInvoice(): Invoice? {
    return if (this == null) null
    else Invoice(
        id = this[InvoiceTable.id],
        createdAt = this[InvoiceTable.date].toString(),
        customer = this[InvoiceTable.customer],
        paymentMethod = this[InvoiceTable.paymentmethod],
        paid = this[InvoiceTable.paid],
        totalPrice = this[InvoiceTable.totalPrice]
    )
}

fun ResultRow?.toExpense(): Expense? {
    return if (this == null) null
    else Expense(
        id = this[ExpenseTable.id],
        createdAt = this[ExpenseTable.date].toString(),
        concept = this[ExpenseTable.concept],
        amount = this[ExpenseTable.amount],
        type = this[ExpenseTable.type],
        invoice = this[ExpenseTable.invoiceId],
        notes = this[ExpenseTable.notes]
    )
}