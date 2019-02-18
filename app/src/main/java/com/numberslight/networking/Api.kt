package com.numberslight.networking

import com.numberslight.model.DetailItemModel
import com.numberslight.model.ItemModel
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Silviu Pal on 18/02/2019.
 */
interface Api {
    @GET("json.php")
    fun getData(): Observable<List<ItemModel>>

    @GET("json.php")
    fun getDetailData(@Query("name") name: String): Observable<DetailItemModel>

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