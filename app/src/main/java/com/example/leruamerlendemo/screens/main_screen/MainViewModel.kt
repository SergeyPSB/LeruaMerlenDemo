package com.example.leruamerlendemo.screens.main_screen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.leruamerlendemo.data.Category
import com.example.leruamerlendemo.utils.Util

class MainViewModel(application: Application) : AndroidViewModel(application) {
    // TODO: Implement the ViewModel

    var categories = MutableLiveData<List<Category>>()

    init {
        val data = Util.getObjFromJson<List<Category>>(context = application.baseContext, "category.json")
        categories.value = data ?: listOf()
    }
}