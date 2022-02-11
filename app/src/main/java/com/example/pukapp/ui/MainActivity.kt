package com.example.pukapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pukapp.R
import com.example.pukapp.api.RetrofitClient
import com.example.pukapp.repo.MainActivityRepository

class MainActivity : AppCompatActivity() {
    private val serviceApi = RetrofitClient.serviceApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProvider(
            this,
            ViewModelProviderFactory(MainActivityRepository(serviceApi))
        ).get(MainViewModel::class.java)

        val recordingsAdapter = RecordingsAdapter()
        val recyclerView: RecyclerView = findViewById(R.id.main_recyclerview)
        recyclerView.adapter = recordingsAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.list.observe(this, Observer {
            recordingsAdapter.setData(it)
        })
    }
}