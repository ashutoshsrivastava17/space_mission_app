package assignment.leanix.utils

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import assignment.leanix.App

/**
 * Factory for all ViewModels.
 */
@Suppress("UNCHECKED_CAST")

fun Fragment.getViewModelFactory(): ViewModelFactory {
    return ViewModelFactory(App.getApp(), this)
}

fun AppCompatActivity.getViewModelFactory(): ViewModelFactory {
    return ViewModelFactory(App.getApp(), this)
}