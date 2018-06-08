package vn.tiki.data.api

import io.reactivex.Observable
import vn.tiki.data.entity.DealEntity

interface RestApi {

    val getDeals: Observable<MutableList<DealEntity>>
}