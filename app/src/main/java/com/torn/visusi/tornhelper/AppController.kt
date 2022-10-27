package com.torn.visusi.tornhelper

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp open class AppController : Application() {

  companion object {
    lateinit var instance : AppController
  }

  override fun onCreate() {
    super.onCreate()
    instance = this
  }
}