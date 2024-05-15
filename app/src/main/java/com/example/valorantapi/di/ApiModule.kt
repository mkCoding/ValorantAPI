package com.example.valorantapi.di

import com.example.valorantapi.data.api.ApiDetails
import com.example.valorantapi.data.api.ApiEndpoints
import com.example.valorantapi.data.repository.ApiRepository
import com.example.valorantapi.data.repository.ApiRepositoryImpl
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Provides
    fun provideRetrofit(): Retrofit {
        val gson = Gson()
        val gsonConverterFactory = GsonConverterFactory.create(gson)

        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()

        return Retrofit.Builder()
            .baseUrl(ApiDetails.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Provides
    fun provideApiEndpoints(retrofit: Retrofit): ApiEndpoints {
        return retrofit.create(ApiEndpoints::class.java)
    }

    @Provides
    fun provideRepository(apiEndpoints: ApiEndpoints): ApiRepository {
        return ApiRepositoryImpl(apiEndpoints)
    }
}
