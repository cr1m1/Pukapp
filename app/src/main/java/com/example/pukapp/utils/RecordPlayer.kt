package com.example.pukapp.utils

import android.media.AudioManager
import android.media.MediaPlayer
import java.io.IOException

var mediaPlayer = MediaPlayer()

fun playAudio(url: String) {
    mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC)

    try {
        mediaPlayer.setDataSource(url)
        mediaPlayer.prepare()
        mediaPlayer.start()
    } catch (e: IOException) {
        e.printStackTrace()
    }
}

fun pauseAudio() {
    if (mediaPlayer.isPlaying) {
        mediaPlayer.pause()
    }
}

fun getAudioDuration() : Int {
    return mediaPlayer.duration
}