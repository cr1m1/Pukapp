package com.example.pukapp.utils

import android.net.ParseException
import java.text.SimpleDateFormat

fun getAbbreviatedFromDateTime(dateTime: String, dateFormat: String, field: String): String? {
    val input = SimpleDateFormat(dateFormat)
    val output = SimpleDateFormat(field)
    try {
        val getAbbreviate = input.parse(dateTime)
        return output.format(getAbbreviate)
    } catch (e: ParseException) {
        e.printStackTrace()
    }
    return null
}