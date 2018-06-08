package vn.tiki.domain.repository

import io.reactivex.Observable
import vn.tiki.domain.model.DealModel

interface DealRepository {

    val getDeals: Observable<MutableList<DealModel>>
}