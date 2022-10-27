package com.torn.visusi.tornhelper.feature.home.repository

import android.util.Log
import javax.inject.Inject


class LoginRepository @Inject constructor() {
  fun login(username: String, password: String) {
    Log.e("username", username)
    Log.e("password", password)
  }


}