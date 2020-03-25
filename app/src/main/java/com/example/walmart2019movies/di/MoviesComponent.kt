package com.example.walmart2019movies.di


import com.example.walmart2019movies.model.PreLoadIntentService
import com.example.walmart2019movies.view.MainActivity
import com.example.walmart2019movies.view.SplashLoadingActivity
import dagger.Component

@Component(
    modules = [
        MoviesApplicationModule::class,
        MoviesRemoteModule::class,
        MoviesViewModelModule::class])
interface MoviesComponent {
    fun injectSplashActivity(activity: SplashLoadingActivity)
    fun injectMainActivity(activity: MainActivity)
    fun injectPreLoadIntentService(intentService: PreLoadIntentService)
}