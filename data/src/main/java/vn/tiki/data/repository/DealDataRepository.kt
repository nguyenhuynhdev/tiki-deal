package vn.tiki.data.repository

import javax.inject.Inject
import io.reactivex.Observable
import vn.tiki.data.api.RestApiIml
import vn.tiki.domain.model.DealModel
import vn.tiki.domain.repository.DealRepository
import vn.tiki.data.entity.mapper.DealEntityDataMapper

class DealDataRepository @Inject
constructor(private val restApiIml: RestApiIml,
            private val dealEntityDataMapper: DealEntityDataMapper) : DealRepository {
    override val getDeals: Observable<MutableList<DealModel>>
        get() = restApiIml.getDeals.map { dealEntityDataMapper.transformTo(it) }

}