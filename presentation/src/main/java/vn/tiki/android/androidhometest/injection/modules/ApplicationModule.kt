package vn.tiki.android.androidhometest.injection.modules

import dagger.Binds
import dagger.Module
import com.google.gson.Gson
import javax.inject.Singleton
import android.content.Context

import vn.tiki.data.api.RestApi
import vn.tiki.data.api.RestApiIml
import vn.tiki.domain.repository.DealRepository
import vn.tiki.data.repository.DealDataRepository
import vn.tiki.android.androidhometest.AndroidApplication
import vn.tiki.android.androidhometest.UIThread
import vn.tiki.android.androidhometest.injection.scope.FragmentScope
import vn.tiki.data.executor.JobExecutor
import vn.tiki.domain.executor.PostExecutionThread
import vn.tiki.domain.executor.ThreadExecutor


@Module
abstract class ApplicationModule {

    @Binds
    @Singleton
    abstract fun bindGSon(gSon: Gson): Gson

    @Binds
    @Singleton
    abstract fun bindContext(androidApplication: AndroidApplication): Context

    @Binds
    @FragmentScope
    abstract fun bindThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor

    @Binds
    @FragmentScope
    abstract fun bindPostExecutionThread(uiThread: UIThread): PostExecutionThread

    @Binds
    @Singleton
    abstract fun bindRestApi(
            restApiIml: RestApiIml): RestApi

    @Binds
    @Singleton
    abstract fun bindDealRepository(
            dealDataRepository: DealDataRepository): DealRepository

}