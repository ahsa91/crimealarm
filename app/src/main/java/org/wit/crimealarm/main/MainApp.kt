package org.wit.crimealarm.main

import android.app.Application
import org.wit.crimealarm.models.PlacemarkJSONStore
import org.wit.crimealarm.models.PlacemarkStore
import timber.log.Timber
import timber.log.Timber.i

class MainApp : Application() {

    lateinit var placemarks: PlacemarkStore

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        placemarks = PlacemarkJSONStore(applicationContext)

        i("Placemark started")

    }
}