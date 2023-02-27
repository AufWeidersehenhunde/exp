package com.example.experimentation
import androidx.room.Room
import com.example.experimentation.HomeFragment.HomeViewModel
import com.example.experimentation.MainActivity.MainActivityViewModel
import com.github.terrakok.cicerone.Cicerone
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module



val appModule = module {
    val cicerone = Cicerone.create()
    single { cicerone.router }
    single { cicerone.getNavigatorHolder() }

    viewModel { MainActivityViewModel(get()) }
    viewModel { HomeViewModel() }

}