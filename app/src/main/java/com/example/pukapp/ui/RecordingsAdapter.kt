package com.example.pukapp.ui

import android.net.ParseException
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pukapp.R
import com.example.pukapp.model.Recording
import com.example.pukapp.utils.getAbbreviatedFromDateTime
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class RecordingsAdapter: RecyclerView.Adapter<RecordingsAdapter.ViewHolder>() {

//    val list = mutableListOf<Recording>(
//        Recording(1,
//            "123",
//            "2022-02-10T12:26:48.104926Z",
//            "2022-02-10T12:26:48.104926Z"),
//        Recording(2,
//            "123",
//            "2022-02-10T12:26:48.104926Z",
//            "2022-02-10T12:26:48.104926Z"),
//        Recording(3,
//            "123",
//            "2022-02-10T12:26:48.104926Z",
//            "2022-02-10T12:26:48.104926Z")
//    )

    var list = mutableListOf<Recording>()

    fun setData(data: MutableList<Recording>){
        this.list = data
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val imageView: ImageView = view.findViewById(R.id.control_btn)
        val title: TextView = view.findViewById(R.id.title)
        val time: TextView = view.findViewById(R.id.time)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = "Recording ${position + 1}"
        holder.time.text = getAbbreviatedFromDateTime(
            list[position].createdAt,
            "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",
            "MM d, h:mm a")
    }

    override fun getItemCount(): Int {
        return list.size
    }
}