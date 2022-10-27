package com.torn.visusi.tornhelper

import com.torn.visusi.tornhelper.database.module.DaoProviders
import com.torn.visusi.tornhelper.di.network.NetworkModule
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(
  includes = [  NetworkModule::class, DaoProviders::class]
) @InstallIn(SingletonComponent::class) object AppComponent {

}