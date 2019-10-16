package com.mino.contactss.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.mino.contactss.domain.ContactsUseCase
import javax.inject.Inject

class ContactsViewModel @Inject constructor(private val contactsUseCase: ContactsUseCase) :
    ViewModel() {

    fun getContacts(): LiveData<List<ContactModel>> =
        LiveDataReactiveStreams.fromPublisher(contactsUseCase.getContacts())

    fun getContactById() {
//        contactsUseCase.getContactById()
    }

}