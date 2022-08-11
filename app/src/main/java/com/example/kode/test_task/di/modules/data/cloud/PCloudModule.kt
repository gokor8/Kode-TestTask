package com.example.kode.test_task.di.modules.data.cloud

import com.example.kode.data.datasource.workers.cloud.api.WorkersApi
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

@Module
class PCloudModule {

    @Provides
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder().build()

    @Provides
    fun provideRetrofit(
        client: OkHttpClient,
        converterFactory: GsonConverterFactory
        ): Retrofit = Retrofit.Builder()
        .baseUrl("https://stoplight.io/mocks/kode-education/trainee-test/25143926")
        .addConverterFactory(converterFactory)
        .client(client)
        .build()

    @Provides
    fun provideGson(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    fun provideApi(retrofit: Retrofit): WorkersApi = retrofit.create(WorkersApi::class.java)
}