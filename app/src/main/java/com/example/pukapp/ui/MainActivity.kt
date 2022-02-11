package com.example.pukapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pukapp.R
import com.example.pukapp.api.ServiceApi
import com.example.pukapp.repo.MainActivityRepository

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel
    lateinit var recordingsAdapter: RecordingsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = MainActivityRepository()
        viewModel = ViewModelProvider(
            this,
            ViewModelProviderFactory(repository)
        ).get(MainViewModel::class.java)

        initRecycler()

        viewModel.recList.observe(this, Observer {
            it.data.puks.let { puks ->
                recordingsAdapter.setData(puks)
            }
        })
    }

    fun initRecycler() {
        val recyclerView: RecyclerView = findViewById(R.id.main_recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recordingsAdapter = RecordingsAdapter()
        recyclerView.adapter = recordingsAdapter
    }
}