package vn.tiki.android.androidhometest

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import vn.tiki.domain.executor.PostExecutionThread
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UIThread @Inject
internal constructor() : PostExecutionThread {

    override fun getScheduler(): Scheduler {
        return AndroidSchedulers.mainThread()
    }
}