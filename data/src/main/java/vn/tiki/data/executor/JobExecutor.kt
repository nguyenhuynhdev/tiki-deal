package vn.tiki.data.executor

import java.util.concurrent.TimeUnit
import java.util.concurrent.ThreadFactory
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.LinkedBlockingQueue

import javax.inject.Inject
import javax.inject.Singleton

import vn.tiki.domain.executor.ThreadExecutor

/**
 * Decorated [java.util.concurrent.ThreadPoolExecutor]
 */
@Singleton
class JobExecutor @Inject
internal constructor() : ThreadExecutor {
    private val threadPoolExecutor: ThreadPoolExecutor

    init {
        this.threadPoolExecutor = ThreadPoolExecutor(3, 5, 10, TimeUnit.SECONDS,
                LinkedBlockingQueue<Runnable>(), JobThreadFactory())
    }

    override fun execute(runnable: Runnable) {
        this.threadPoolExecutor.execute(runnable)
    }

    private class JobThreadFactory : ThreadFactory {
        private var counter = 0

        override fun newThread(runnable: Runnable): Thread {
            return Thread(runnable, "android_" + counter++)
        }
    }
}
