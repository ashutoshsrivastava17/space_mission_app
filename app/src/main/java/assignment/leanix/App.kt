package assignment.leanix

import android.app.Application

/**
 * Created by Ashutosh Srivastava on 30-Aug-2021 9:10 PM.
 * Project : LeanIX Sample
 * Copyright (c) 2021  All rights reserved.
 */
class App : Application() {

    companion object {
        private lateinit var application: App
        fun getApp(): App {
            return application
        }
    }

    override fun onCreate() {
        application = this
        super.onCreate()
    }
}