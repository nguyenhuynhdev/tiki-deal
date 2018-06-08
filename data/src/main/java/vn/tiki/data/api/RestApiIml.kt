package vn.tiki.data.api

import android.os.NetworkOnMainThreadException

import javax.inject.Inject
import io.reactivex.Observable

import vn.tiki.data.entity.DealEntity

class RestApiIml @Inject constructor(private val apiServices: ApiServices) : RestApi {

    override val getDeals: Observable<MutableList<DealEntity>>
        get() = Observable.create { e ->
            try {
                val deals = apiServices.getDeals()
                e.onNext(deals)
            } catch (ex: NetworkOnMainThreadException) {
                e.tryOnError(ex)
            }
        }
}