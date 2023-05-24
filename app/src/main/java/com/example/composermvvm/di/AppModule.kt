package com.example.composermvvm.di

import com.example.composermvvm.common.Constance.BASE_URL
import com.example.composermvvm.data.remote.ApiCoin
import com.example.composermvvm.data.repository.CoinRepositoryImpl
import com.example.composermvvm.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesApiCoin(): ApiCoin{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiCoin::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(api: ApiCoin): CoinRepository {
        return CoinRepositoryImpl(api)
    }
}