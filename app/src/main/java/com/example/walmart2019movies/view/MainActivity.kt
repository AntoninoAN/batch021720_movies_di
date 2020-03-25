package com.example.walmart2019movies.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.walmart2019movies.R
import com.example.walmart2019movies.utils.MoviesApplication
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var contextMainActivity: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MoviesApplication.getComponent().injectMainActivity(this)

        contextMainActivity.getSharedPreferences("LoggingTracker",
            Context.MODE_PRIVATE)
    }
}
