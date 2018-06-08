package vn.tiki.data.entity

import java.util.Date
import com.google.gson.annotations.SerializedName

data class DealEntity(
        @SerializedName("name")
        val productName: String,
        @SerializedName("thumbnail")
        val productThumbnail: String,
        @SerializedName("price")
        val productPrice: Double,
        val startedDate: Date,
        val endDate: Date
)