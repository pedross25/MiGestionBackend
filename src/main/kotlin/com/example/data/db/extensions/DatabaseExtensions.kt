package com.example.data.db.extensions

import com.example.data.db.ProductTable
import com.example.data.db.UserTable
import com.example.data.models.Product
import com.example.data.models.User
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
        createdAt = this[ProductTable.createdAt].toString()
    )
}