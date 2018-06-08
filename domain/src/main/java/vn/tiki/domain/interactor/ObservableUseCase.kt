package vn.tiki.domain.interactor

import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

import vn.tiki.domain.executor.PostExecutionThread
import vn.tiki.domain.executor.ThreadExecutor

abstract class ObservableUseCase<T, in Params>
internal constructor(private val threadExecutor: ThreadExecutor,
                     private val postExecutionThread: PostExecutionThread) {
    private val disposables: CompositeDisposable = CompositeDisposable()

    abstract fun buildUseCaseObservable(params: Params?): Observable<T>

    fun execute(observer: DefaultObserver<T>, params: Params?) {
        val observable = this.buildUseCaseObservable(params)
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.getScheduler())
        addDisposable(observable.subscribeWith(observer))
    }

    fun clear() {
        if (!disposables.isDisposed) {
            disposables.clear()
        }
    }

    /**
     * Dispose from current [CompositeDisposable].
     */
    private fun addDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }
}