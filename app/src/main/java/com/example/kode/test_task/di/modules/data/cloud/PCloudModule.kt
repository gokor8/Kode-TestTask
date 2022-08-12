package com.example.kode.test_task.di.modules.data.cloud

import com.example.kode.data.datasource.workers.cloud.api.WorkersApi
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class PCloudModule {

    @Provides
    fun provideHttpLoggingInterceptor(): Interceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS)

    @Provides
    fun provideOkHttpClient(
        interceptor: Interceptor
    ): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(
            interceptor
        ).build()

    @Provides
    fun provideRetrofit(
        client: OkHttpClient,
        converterFactory: GsonConverterFactory
    ): Retrofit = Retrofit.Builder()
        .baseUrl("https://stoplight.io/mocks/kode-education/trainee-test/25143926/")
        .addConverterFactory(converterFactory)
        .client(client)
        .build()

    @Provides
    fun provideGson(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    fun provideApi(retrofit: Retrofit): WorkersApi = retrofit.create(WorkersApi::class.java)
}