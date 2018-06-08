package vn.tiki.android.androidhometest

import com.squareup.leakcanary.LeakCanary
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

import vn.tiki.android.androidhometest.injection.components.DaggerApplicationComponent

class AndroidApplication : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
        initializeLeakDetection()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent.builder().create(this)
    }

    private fun initializeLeakDetection() {
        if (BuildConfig.DEBUG) {
            LeakCanary.install(this)
        }
    }
}