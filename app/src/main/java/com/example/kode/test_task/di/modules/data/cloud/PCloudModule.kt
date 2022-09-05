package com.example.kode.test_task.di.modules.data.cloud

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.example.kode.data.datasource.workers.cloud.api.WorkersApi
import com.example.kode.test_task.BuildConfig
import com.example.kode.test_task.di.annotations.ApplicationContext
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
    fun provideChuckerInterceptor(@ApplicationContext context: Context): ChuckerInterceptor =
        ChuckerInterceptor.Builder(context)
            .build()

    @Provides
    fun provideOkHttpClient(
        interceptor: Interceptor,
        chuckerInterceptor: ChuckerInterceptor
    ): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(
            interceptor
        ).addInterceptor(
            chuckerInterceptor
        ).build()

    @Provides
    fun provideRetrofit(
        client: OkHttpClient,
        converterFactory: GsonConverterFactory,
    ): Retrofit = Retrofit.Builder()
            //.baseUrl(com.example.kode.data.BuildConfig.)
            // чуть позже уберу этот хардкод
        .baseUrl("https://stoplight.io/mocks/kode-education/trainee-test/25143926/")
        .addConverterFactory(converterFactory)
        .client(client)
        .build()

    @Provides
    fun provideGson(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    fun provideApi(retrofit: Retrofit): WorkersApi = retrofit.create(WorkersApi::class.java)
}