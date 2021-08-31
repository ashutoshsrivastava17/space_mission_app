package assignment.leanix

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.backbase.assignment.utils.ViewModelFactory

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