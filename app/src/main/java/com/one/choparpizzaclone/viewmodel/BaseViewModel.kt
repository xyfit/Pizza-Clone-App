package com.one.choparpizzaclone.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.one.choparpizzaclone.model.MenuModel

class BaseViewModel: ViewModel() {
    val matn = MutableLiveData<String>()
    val responseList = MutableLiveData<List<MenuModel>>()
}