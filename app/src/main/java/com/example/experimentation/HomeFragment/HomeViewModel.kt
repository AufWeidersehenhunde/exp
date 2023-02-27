package com.example.experimentation.HomeFragment

import androidx.lifecycle.ViewModel
import com.example.experimentation.Table
import kotlinx.coroutines.flow.MutableStateFlow

class HomeViewModel: ViewModel() {
    val konstantin = Table(
        "1",
        "ll",
        22
    )
    val innokentii = Table(
        "2",
        "kk",
        43
    )
    val oleg = Table(
        "3",
        "j",
        98
    )
    val nikola = Table(
        "4",
        "o",
        65
    )
    val people = MutableStateFlow (listOf(konstantin,innokentii,oleg,nikola))
}