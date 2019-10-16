package com.mino.contactss.ui.main.viewmodel

import androidx.databinding.ObservableField


class ContactModel(id: String, name: String, phoneNumber: String) {

    var name: ObservableField<String> = ObservableField(name)
    var phoneNumber: ObservableField<String> = ObservableField(phoneNumber)
    var id: ObservableField<String> = ObservableField(id)


    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ContactModel

        if (name.get() != other.name.get()) return false
        if (phoneNumber.get() != other.phoneNumber.get()) return false
        if (id.get() != other.id.get()) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + phoneNumber.hashCode()
        result = 31 * result + id.hashCode()
        return result
    }

}