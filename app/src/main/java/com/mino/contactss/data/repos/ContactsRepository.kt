package com.mino.contactss.data.repos

import com.mino.contactss.data.remote.ContactsApi
import com.mino.contactss.data.remote.entity.ContactEntity
import com.mino.contactss.di.app.PerApplication
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Single
import org.intellij.lang.annotations.Flow
import javax.inject.Inject

@PerApplication
class ContactsRepository @Inject constructor(private val contactsApi: ContactsApi) {

    fun getContacts(): Flowable<List<ContactEntity>> = contactsApi.getContacts()

    fun getContactById(id: String): Single<ContactEntity> = contactsApi.getContactById(id)

    fun createNewContact(contactEntity: ContactEntity) = contactsApi.createNewContact(contactEntity)
}