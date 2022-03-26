package com.beo.foody.di

import com.beo.foody.data.network.FoodRecipesApi
import com.beo.foody.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    // OkHttpClient will help control connection to server, catch error...
    @Singleton
    @Provides
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .build()
    }

    @Singleton
    @Provides
    fun provideConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }


    @Singleton
    @Provides
    fun provideRetrofitInstance(okHttpClient: OkHttpClient, gsonConverterFactory: GsonConverterFactory) : Retrofit {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL).client(okHttpClient).addConverterFactory(gsonConverterFactory).build()
    }

    @Singleton
    @Provides
    // Annotating this function with @Provides because we not directly create retrofit class API
    // So we will use it to DI this class in Application
    fun provideApiService(retrofit: Retrofit) : FoodRecipesApi {
        return retrofit.create(FoodRecipesApi::class.java)
    }
}