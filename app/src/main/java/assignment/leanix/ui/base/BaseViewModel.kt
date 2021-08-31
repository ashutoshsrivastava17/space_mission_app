package assignment.leanix.ui.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import assignment.leanix.R


/**
 * Created by Ashutosh Srivastava on 30-Aug-2021 9:01 PM.
 * Project : LeanIX Sample
 * Copyright (c) 2021  All rights reserved.
 */
open class BaseViewModel<NAV : BaseNavigator?>(application: Application) :
    AndroidViewModel(application) {

    var navigator: NAV? = null

    private val loaderLiveData: MutableLiveData<Boolean> =
        MutableLiveData<Boolean>().apply { value = false }
    var loaderMessage: String? = null
        private set

    fun showLoader() {
        showLoader(getApplication<Application>().getString(R.string.please_wait))
    }

    fun showLoader(message: String) {
        this.loaderMessage = message
        this.loaderLiveData.value = true
    }

    fun observerLoader(): LiveData<Boolean> {
        return loaderLiveData
    }

    fun hideLoader() {
        this.loaderLiveData.value = false
    }

}