package vn.tiki.android.androidhometest.injection.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector

import vn.tiki.android.androidhometest.injection.modules.sub.ActivityModule
import vn.tiki.android.androidhometest.injection.modules.sub.FragmentModule
import vn.tiki.android.androidhometest.view.activity.MainActivity
import vn.tiki.android.androidhometest.injection.scope.FragmentScope
import vn.tiki.android.androidhometest.injection.scope.ActivityScope
import vn.tiki.android.androidhometest.view.fragment.MainFragment

/**
 * Define all injector for [dagger.android.support.DaggerAppCompatActivity],
 * [dagger.android.support.DaggerFragment], [dagger.android.DaggerService]
 */
@Module
abstract class ContributeModule{

    //Activity
    @ActivityScope
    @ContributesAndroidInjector(modules = [ActivityModule::class])
    abstract fun contributeMainActivity(): MainActivity

    //Fragment
    @FragmentScope
    @ContributesAndroidInjector(modules = [FragmentModule::class])
    abstract fun contributeMainFragment(): MainFragment
}