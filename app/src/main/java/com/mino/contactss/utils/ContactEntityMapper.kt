package com.mino.contactss.utils

import com.mino.contactss.data.remote.entity.ContactEntity
import com.mino.contactss.ui.main.viewmodel.ContactModel

fun convert2ContactModel(contactEntities: List<ContactEntity>): List<ContactModel> {

    val contactModels = arrayListOf<ContactModel>()
    for (urlEntity in contactEntities) {
        contactModels.add(
            ContactModel(
                urlEntity.id,
                (urlEntity.firstName + urlEntity.lastName),
                urlEntity.phone
            )
        )
    }
    return contactModels
}