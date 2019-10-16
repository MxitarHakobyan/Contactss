package com.mino.contactss.domain

import android.util.Log
import com.mino.contactss.data.remote.entity.ContactEntity
import com.mino.contactss.data.repos.ContactsRepository
import com.mino.contactss.di.app.PerApplication
import com.mino.contactss.utils.convert2ContactModel
import io.reactivex.CompletableObserver
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@PerApplication
class ContactsUseCase @Inject constructor(
    private val compositeDisposable: CompositeDisposable,
    private val contactsRepository: ContactsRepository
) :
    BaseUseCase() {

    fun getContacts() = contactsRepository.getContacts()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .map { list -> convert2ContactModel(list) }

    fun getContactById(id: String) {
        execute(
            single = contactsRepository.getContactById(id),
            observer = object : SingleObserver<ContactEntity> {
                override fun onSuccess(contact: ContactEntity) {

                }

                override fun onSubscribe(d: Disposable) {
                    compositeDisposable.add(d)
                }

                override fun onError(e: Throwable) {
                    Log.d("+++++++", "onError  error = ${e.message}")
                }

            }
        )
    }

    fun createNewContact(contactEntity: ContactEntity) {
        execute(
            completable = contactsRepository.createNewContact(contactEntity),
            observer = object : CompletableObserver {

                override fun onComplete() {
                    Log.d("+++++++", "onSuccess")
                }

                override fun onSubscribe(d: Disposable) {
                    compositeDisposable.add(d)
                }

                override fun onError(e: Throwable) {
                    Log.d("+++++++", "onError  error = ${e.message}")
                }

            }
        )
    }

    override fun dispose() {
        compositeDisposable.dispose()
    }
}