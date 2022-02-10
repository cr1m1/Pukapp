package com.example.pukapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recordingsAdapter = RecordingsAdapter()
        val recyclerView: RecyclerView = findViewById(R.id.main_recyclerview)
        recyclerView.adapter = recordingsAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}