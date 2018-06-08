package vn.tiki.android.androidhometest.presenter

import javax.inject.Inject

import vn.tiki.domain.model.DealModel
import vn.tiki.domain.interactor.DefaultObserver
import vn.tiki.android.androidhometest.view.MainView
import vn.tiki.domain.interactor.usecase.GetDealsUseCase
import vn.tiki.android.androidhometest.injection.scope.FragmentScope

@FragmentScope
class MainPresenter @Inject constructor(
        private val getDealsUseCase: GetDealsUseCase
) : BasePresenter {

    private var mainView: MainView? = null


    override fun resume() {

    }

    override fun pause() {

    }

    override fun destroy() {
        mainView = null
        getDealsUseCase.clear()
    }

    fun initView(mainView: MainView) {
        this.mainView = mainView
        mainView.initializeView()
        getDealsUseCase.execute(GetDealsObserver(), null)
    }

    private inner class GetDealsObserver : DefaultObserver<MutableList<DealModel>>() {

        override fun onNext(responseData: MutableList<DealModel>) {
            mainView?.updateDeals(responseData)
        }

        override fun onError(exception: Throwable) {
            mainView?.showToast(exception)
        }
    }
}