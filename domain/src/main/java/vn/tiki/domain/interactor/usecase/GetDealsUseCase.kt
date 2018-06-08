package vn.tiki.domain.interactor.usecase

import javax.inject.Inject
import io.reactivex.Observable

import vn.tiki.domain.executor.PostExecutionThread
import vn.tiki.domain.executor.ThreadExecutor
import vn.tiki.domain.interactor.ObservableUseCase
import vn.tiki.domain.model.DealModel
import vn.tiki.domain.repository.DealRepository

class GetDealsUseCase @Inject constructor(
        private val dealRepository: DealRepository,
        threadExecutor: ThreadExecutor,
        postExecutionThread: PostExecutionThread
) : ObservableUseCase<MutableList<DealModel>, Void>(threadExecutor, postExecutionThread) {
    override fun buildUseCaseObservable(params: Void?): Observable<MutableList<DealModel>> =
            dealRepository.getDeals
}