package com.mino.contactss.data.remote

import com.mino.contactss.data.remote.entity.ContactEntity
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ContactsApi {

    @GET("contacts")
    fun getContacts(): Flowable<List<ContactEntity>>

    @GET("contacts/{_id}")
    fun getContactById(
        @Path("_id") id: String
    ): Single<ContactEntity>

    @POST("contacts")
    fun createNewContact(@Body contactEntity: ContactEntity): Completable

}