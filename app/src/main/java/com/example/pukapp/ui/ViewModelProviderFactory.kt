package com.example.pukapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pukapp.repo.MainActivityRepository
import java.lang.IllegalArgumentException
import com.example.pukapp.ui.MainViewModel as PukappUiViewModel

class ViewModelProviderFactory constructor(private val repository: MainActivityRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
      return if (modelClass.isAssignableFrom(PukappUiViewModel::class.java)) {
          PukappUiViewModel(this.repository) as T
      }else{
          throw IllegalArgumentException("view model error")
      }
    }

}