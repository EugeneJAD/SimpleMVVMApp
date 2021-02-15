package com.example.simplemvvmapp.di

import com.example.simplemvvmapp.BuildConfig
import com.example.simplemvvmapp.utils.AppConstants
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideOkHttpClientBuilder(): OkHttpClient.Builder {
        return OkHttpClient().newBuilder()
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .addInterceptor(
                HttpLoggingInterceptor { message -> Timber.tag("API").d(message) }.apply {
                level = if (BuildConfig.DEBUG) {
                    HttpLoggingInterceptor.Level.BODY
                } else {
                    HttpLoggingInterceptor.Level.NONE
                }
            })
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(builder: OkHttpClient.Builder): OkHttpClient = builder.build()

    @Singleton
    @Provides
    fun provideHttpClient(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder().baseUrl(AppConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()
    }
//
//    @Provides
//    fun provideCatalogService(retrofit: Retrofit): TasksService {
//        return retrofit.create<TasksService>(TasksService::class.java)
//    }

}