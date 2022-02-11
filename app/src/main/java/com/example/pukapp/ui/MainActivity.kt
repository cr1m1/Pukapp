package com.example.pukapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pukapp.R
import com.example.pukapp.repo.MainActivityRepository

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel
    lateinit var recordingsAdapter: RecordingsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository: MainActivityRepository = MainActivityRepository()
        val viewModelProviderFactory = ViewModelProviderFactory(repository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory)
            .get(MainViewModel::class.java)

        recordingsAdapter = RecordingsAdapter()
        main_recyclerview
    }
}