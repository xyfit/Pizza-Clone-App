package com.one.choparpizzaclone.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BaseViewModel: ViewModel() {
    val matn = MutableLiveData<String>()
}