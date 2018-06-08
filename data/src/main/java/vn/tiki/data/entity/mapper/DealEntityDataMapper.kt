package vn.tiki.data.entity.mapper

import javax.inject.Inject

import vn.tiki.data.entity.DealEntity
import vn.tiki.domain.model.DealModel

class DealEntityDataMapper
@Inject constructor() : Mapper<DealEntity, DealModel> {

    override fun transformTo(obj: DealEntity): DealModel = DealModel(
            productName = obj.productName,
            productPrice = obj.productPrice,
            productThumbnail = obj.productThumbnail,
            startedDate = obj.startedDate,
            endDate = obj.endDate
    )

    override fun transformTo(listObj: MutableList<DealEntity>): MutableList<DealModel> =
            listObj.map { transformTo(it) }.toMutableList()

}