package com.example.simplemvvmapp.di

import android.app.Application
import com.example.simplemvvmapp.BuildConfig
import com.example.simplemvvmapp.data.api.NetworkInterceptor
import com.example.simplemvvmapp.data.service.TasksRetrofitService
import com.example.simplemvvmapp.utils.AppConstants
import com.example.simplemvvmapp.utils.hasNetworkConnection
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.CacheControl
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

private const val CACHE_SIZE = 5 * 1024 * 1024L // 5 MB

@Module
class NetworkModule {

    @Provides
    fun provideHttpLoggingInterceptor() = HttpLoggingInterceptor { message ->
        Timber.tag("API").d(message)
    }.apply {
        level = if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor.Level.HEADERS
        } else {
            HttpLoggingInterceptor.Level.NONE
        }
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        cache: Cache,
        application: Application
    ): OkHttpClient {
        return OkHttpClient().newBuilder()
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .addInterceptor(httpLoggingInterceptor)
            .addNetworkInterceptor(NetworkInterceptor())
            .addInterceptor {
                var request: Request = it.request()
                if (!application.hasNetworkConnection()) {
                    request = request.newBuilder()
                        .cacheControl(CacheControl.FORCE_CACHE)
                        .build()
                }
                it.proceed(request)
            }
            .cache(cache)
            .build()
    }

    @Singleton
    @Provides
    fun provideHttpClient(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder().baseUrl(AppConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()
    }

    @Provides
    fun provideTasksService(retrofit: Retrofit): TasksRetrofitService {
        return retrofit.create(TasksRetrofitService::class.java)
    }

    @Singleton
    @Provides
    fun provideCache(application: Application): Cache {
        return Cache(application.cacheDir, CACHE_SIZE)
    }
}