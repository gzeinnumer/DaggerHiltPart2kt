package com.gzeinnumer.daggerhiltpart2kt.di

import com.gzeinnumer.daggerhiltpart2kt.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

//todo 4
@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule{

    @Provides
    @Singleton
    fun retrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    //todo 6
    @Singleton
    @Provides
    fun apiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
    //end todo 6
}