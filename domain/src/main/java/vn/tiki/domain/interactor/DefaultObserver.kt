package vn.tiki.domain.interactor

import io.reactivex.observers.DisposableObserver

/**
 * Default [DisposableObserver] base class to be used whenever you want default error handling.
 */
abstract class DefaultObserver<T> : DisposableObserver<T>() {

    override fun onNext(responseData: T) {}

    override fun onComplete() {}

    override fun onError(exception: Throwable) {}
}