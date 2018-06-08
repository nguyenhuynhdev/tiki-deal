package vn.tiki.domain.interactor

import io.reactivex.CompletableObserver
import io.reactivex.disposables.Disposable

/**
 * Default [CompletableObserver] base class to define
 */
open class BaseCompletableObserver : CompletableObserver {

    override fun onComplete() {}

    override fun onSubscribe(d: Disposable) {}

    override fun onError(e: Throwable) {}

}