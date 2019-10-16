package com.mino.contactss.di.app

import com.mino.contactss.data.remote.ContactsApi
import com.mino.contactss.utils.API_KEY
import com.mino.contactss.utils.BASE_URL
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class AppModule {

    @Module
    companion object {

        @JvmStatic
        @PerApplication
        @Provides
        fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            return httpLoggingInterceptor
        }

        @JvmStatic
        @PerApplication
        @Provides
        fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
            OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .addInterceptor { chain ->
                    chain.connection()
                    val newRequest = chain.request().newBuilder()
                        .addHeader("x-apikey", API_KEY)
                        .build()
                    chain.proceed(newRequest)
                }.build()

        @JvmStatic
        @PerApplication
        @Provides
        fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

        @JvmStatic
        @PerApplication
        @Provides
        fun provideContactsApi(retrofit: Retrofit): ContactsApi =
            retrofit.create(ContactsApi::class.java)

        @JvmStatic
        @Provides
        fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()
    }
}