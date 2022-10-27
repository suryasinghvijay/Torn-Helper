package com.torn.visusi.tornhelper.feature.home.viewmodel

import androidx.lifecycle.ViewModel
import com.torn.visusi.tornhelper.feature.home.repository.LoginRepository

import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val loginRepository: LoginRepository) : ViewModel() {


}