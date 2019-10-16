package com.mino.contactss.domain

import com.mino.contactss.data.remote.entity.ContactEntity
import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

abstract class BaseUseCase {


    fun execute(
        completable: Completable,
        observer: CompletableObserver
    ) {
        completable
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(observer)
    }

    fun execute(
        single: Single<ContactEntity>,
        observer: SingleObserver<ContactEntity>
    ) {
        single
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(observer)
    }

    abstract fun dispose()
}