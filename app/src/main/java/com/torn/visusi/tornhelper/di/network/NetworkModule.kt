package com.torn.visusi.tornhelper.di.network

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.torn.visusi.tornhelper.extension.getMetaData
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

const val NETWORK_CACHE_SIZE = 10 * 1024 * 1024L
const val DEFAULT_CONNECTION_TIMEOUT_IN_SECONDS = 60L
const val DEFAULT_READ_TIMEOUT_IN_SECONDS = 10L
const val DEFAULT_WRITE_TIMEOUT_IN_SECONDS = 10L
const val NETWORK = "network"
const val TIME_OUT = "timeout"
const val BASE = "base"
const val IDENTIFIER_FOR_CONNECTION_TIMEOUT = "$BASE.$NETWORK.$TIME_OUT.connection"
const val IDENTIFIER_FOR_READ_TIMEOUT = "$BASE.$NETWORK.$TIME_OUT.read"
const val IDENTIFIER_FOR_WRITE_TIMEOUT = "$BASE.$NETWORK.$TIME_OUT.write"

@Module @InstallIn(SingletonComponent::class) object NetworkModule {

  @Provides
  @Singleton
  fun provideGson(): Gson = GsonBuilder().create()

  @Provides fun provideOkHttpClientBuilder(
    @ApplicationContext context: Context
  ): OkHttpClient.Builder {
    return OkHttpClient.Builder().apply {
      connectTimeout(provideConnectionTimeout(context), TimeUnit.SECONDS)
      readTimeout(provideReadTimeout(context), TimeUnit.SECONDS)
      writeTimeout(provideWriteTimeout(context), TimeUnit.SECONDS)
    }
  }

  @Provides @Singleton fun providePreAccessTokenRetrofit(
    retrofitBuilder: Retrofit.Builder, okHttpClient: OkHttpClient.Builder, gson: Gson
  ): Retrofit {
    retrofitBuilder.apply {
      addConverterFactory(GsonConverterFactory.create(gson))
      baseUrl("TmsOauthClientConfig.getBaseUrl()")
      client(okHttpClient.build())
    }
    return retrofitBuilder.build()
  }

  private fun provideConnectionTimeout(context: Context): Long =
    context.getMetaData()?.getLong(IDENTIFIER_FOR_CONNECTION_TIMEOUT)
      ?: DEFAULT_CONNECTION_TIMEOUT_IN_SECONDS

  private fun provideReadTimeout(context: Context): Long =
    context.getMetaData()?.getLong(IDENTIFIER_FOR_READ_TIMEOUT) ?: DEFAULT_READ_TIMEOUT_IN_SECONDS

  private fun provideWriteTimeout(context: Context): Long =
    context.getMetaData()?.getLong(IDENTIFIER_FOR_WRITE_TIMEOUT) ?: DEFAULT_WRITE_TIMEOUT_IN_SECONDS
}