package com.numberslight

import android.app.Application
import com.numberslight.dagger.ApiComponent
import com.numberslight.dagger.DaggerApiComponent

/**
 * Created by Silviu Pal on 18/02/2019.
 */
class App : Application() {
    lateinit var apiComponent: ApiComponent

    init {
        instance = this
    }

    override fun onCreate() {
        super.onCreate()
        setupDaggerComponents()
    }

    private fun setupDaggerComponents() {
        apiComponent = DaggerApiComponent.builder().build()
    }

    companion object {
        lateinit var instance: App
    }
}