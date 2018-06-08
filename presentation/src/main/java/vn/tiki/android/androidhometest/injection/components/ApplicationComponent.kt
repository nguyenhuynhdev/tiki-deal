package vn.tiki.android.androidhometest.injection.components

import dagger.Component
import javax.inject.Singleton
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

import vn.tiki.android.androidhometest.AndroidApplication
import vn.tiki.android.androidhometest.injection.modules.ApplicationModule
import vn.tiki.android.androidhometest.injection.modules.ContributeModule

@Singleton
@Component(modules =
[ContributeModule::class, ApplicationModule::class, AndroidSupportInjectionModule::class])
interface ApplicationComponent : AndroidInjector<AndroidApplication> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<AndroidApplication>()
}