package vn.tiki.data.entity.mapper

import javax.inject.Inject
import com.google.gson.Gson
import vn.tiki.data.entity.DealEntity
import com.google.gson.reflect.TypeToken
import com.google.gson.JsonSyntaxException

class DealEntityJsonMapper @Inject constructor(private val gSon: Gson){

    fun transformDealEntity(jsonResponse: String): DealEntity {
        val entityType = object : TypeToken<DealEntity>() {

        }.type
        return gSon.fromJson<DealEntity>(jsonResponse, entityType)
    }

    @Throws(JsonSyntaxException::class)
    fun transformDealEntityCollection(jsonResponse: String): MutableCollection<DealEntity> {
        val listOfEntityType = object : TypeToken<MutableCollection<DealEntity>>() {

        }.type
        return gSon.fromJson<MutableCollection<DealEntity>>(jsonResponse, listOfEntityType)
    }
}