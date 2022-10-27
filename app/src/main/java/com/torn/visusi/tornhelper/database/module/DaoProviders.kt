package com.torn.visusi.tornhelper.database.module

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module class DaoProviders {

  @Provides @Singleton fun provideAppDatabase(
    @ApplicationContext context: Context
  ): TornExpressDatabase {
    return Room.databaseBuilder(
      context, TornExpressDatabase::class.java, "torn.db"
    ).build()
  }
}