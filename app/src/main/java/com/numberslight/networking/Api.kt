package com.numberslight.networking

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Silviu Pal on 18/02/2019.
 */
interface Api{
    companion object {
        private val BASE_URL = "http://dev.tapptic.com/test/"
        fun create(): Api {

            // client with BODY interceptor
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                })
                .build()

            // retrofit instance setup: Gson converter, RxJava calls adapter, BASE_URl
            return retrofit2.Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .build()
                .create(Api::class.java)
        }
    }
}