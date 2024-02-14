package com.example.branchinterviewtest.di

import android.content.Context
import com.example.branchinterviewtest.data.api.BranchApi
import com.example.branchinterviewtest.data.datastore.BranchPreference
import com.example.branchinterviewtest.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

  @Provides
  @Singleton
  fun providesBranchApi(okHttpClient: OkHttpClient): BranchApi {
    return Retrofit.Builder()
      .baseUrl(BASE_URL)
      .client(okHttpClient)
      .addConverterFactory(GsonConverterFactory.create())
      .build()
      .create(BranchApi::class.java)
  }

  @Provides
  @Singleton
  fun providesHttpLoggingInterceptor(): HttpLoggingInterceptor {
      val level = HttpLoggingInterceptor.Level.BODY
    return HttpLoggingInterceptor().also {
      it.level = level
    }
  }

  @Provides
  @Singleton
  fun provideOkhttpInterceptor(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
    val client = OkHttpClient.Builder()
      .callTimeout(100, TimeUnit.SECONDS)
      .readTimeout(100, TimeUnit.SECONDS)
      .connectTimeout(100, TimeUnit.SECONDS)
      .addInterceptor(httpLoggingInterceptor)
    return client.build()
  }

  @Provides
  @Singleton
  fun providesBranchPreference(@ApplicationContext context: Context): BranchPreference {
    return BranchPreference(context)
  }
}