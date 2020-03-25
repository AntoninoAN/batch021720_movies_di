package com.example.walmart2019movies.model

import android.app.IntentService
import android.content.Intent
import android.util.Log
import com.example.walmart2019movies.R
import com.example.walmart2019movies.utils.Constants
import com.example.walmart2019movies.utils.IntentState
import com.example.walmart2019movies.utils.MoviesApplication
import javax.inject.Inject


class PreLoadIntentService() :
    IntentService("IntentService") {

    @Inject
    lateinit var repository: MoviesRemote

    override fun onCreate() {
        super.onCreate()
        MoviesApplication.getComponent().injectPreLoadIntentService(this)
    }


    override fun onHandleIntent(intent: Intent?) {
        Log.d(TAG, "onHandleIntent")
        val intentMovieFetch = Intent()

        repository.getMoviesApi()
            .getListMovies(
                resources
                    .getString(R.string.api_key)
            )
            .subscribe({
                intentMovieFetch.action =
                    IntentState.SUCCESS.name
                //todo option to save Room DB
                intentMovieFetch
                    .putExtra(Constants.PRE_LOAD_DATA, it)
                sendBroadcast(intentMovieFetch)
            }, {
                it.printStackTrace()
                intentMovieFetch.action =
                    IntentState.FAILURE.name
                sendBroadcast(intentMovieFetch)
            })

    }

    companion object {
        const val TAG = "PreLoadIntentService"
    }
}
