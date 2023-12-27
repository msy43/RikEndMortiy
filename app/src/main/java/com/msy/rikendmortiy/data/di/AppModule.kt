package com.msy.rikendmortiy.data.di

import com.msy.rikendmortiy.data.remote.RMApi
import com.msy.rikendmortiy.data.repository.RMRepositoryImpl
import com.msy.rikendmortiy.domain.repository.RMRepository
import com.msy.rikendmortiy.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRMApi(): RMApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RMApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRMRepository(api: RMApi): RMRepository {
        return RMRepositoryImpl(api = api)
    }
}