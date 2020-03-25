package com.example.walmart2019movies.view

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.walmart2019movies.R
import com.example.walmart2019movies.model.MoviesRemote
import com.example.walmart2019movies.model.MoviesResponse
import com.example.walmart2019movies.utils.Constants
import com.example.walmart2019movies.utils.IntentState
import com.example.walmart2019movies.utils.MoviesApplication
import com.example.walmart2019movies.viewmodel.MoviesViewModel
import com.example.walmart2019movies.viewmodel.MoviesViewModelFactory
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_splash_loading.*
import retrofit2.Retrofit
import javax.inject.Inject

class SplashLoadingActivity : AppCompatActivity() {

    lateinit var viewModel: MoviesViewModel
    @Inject
    lateinit var vmFactory: MoviesViewModelFactory
    @Inject
    lateinit var moviesApplication: Context
    @Inject
    lateinit var retrofit: Retrofit

    @Inject
    lateinit var remoteRepository: MoviesRemote


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_loading)

        MoviesApplication.getComponent().injectSplashActivity(this)

        viewModel = vmFactory.create(MoviesViewModel::class.java)

        val intentFilter = IntentFilter()
        intentFilter.addAction(IntentState.SUCCESS.name)
        intentFilter.addAction(IntentState.FAILURE.name)

        registerReceiver(
            recieverMovies,
            intentFilter
        )

        viewModel.initPreloadMovies()

    }

    val recieverMovies = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            if (intent == null) showSnackBar()
            else {
                if (intent.action == IntentState.SUCCESS.name) {
                    Log.d(TAG, "onReceive: Success")
                    val intentActivity = Intent(
                        moviesApplication,
                        MainActivity::class.java
                    )

                    intentActivity.putExtra(
                        Constants.PRE_LOAD_DATA,
                        intent.getParcelableExtra<MoviesResponse>(Constants.PRE_LOAD_DATA)
                    )

                    startActivity(intentActivity)
                } else {
                    showSnackBar()
                }
            }
        }
    }

    private fun showSnackBar() {
        Snackbar.make(
            cl_splash_root,
            "Something failed",
            Snackbar.LENGTH_INDEFINITE
        )
            .setAction("RETRY") {
                viewModel.initPreloadMovies()
            }
            .show()
    }


    //todo preload the list of movies
    //when the load is finished, move to the Home Screen
    //todo create the data set. Genre[{movies},{movies}]

    companion object {
        const val TAG = "SplashLoadingActivity"
    }
}
