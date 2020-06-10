package dev.skymansandy.gocorona

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dev.skymansandy.base.BaseApplication
import dev.skymansandy.gocorona.dagger.component.DaggerAppComponent
import timber.log.Timber

class GoCoronaApp : BaseApplication() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder()
            .application(this)
            .build()
    }
}