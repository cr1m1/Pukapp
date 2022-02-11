package com.example.pukapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pukapp.repo.MainActivityRepository
import java.lang.IllegalArgumentException

class ViewModelProviderFactory constructor(private val repository: MainActivityRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
      return if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
          MainViewModel(repository) as T
      } else {
          throw IllegalArgumentException("error")
      }
    }

}