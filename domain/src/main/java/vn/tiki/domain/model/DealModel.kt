package vn.tiki.domain.model

import java.util.Date

data class DealModel(
        val productName: String,
        val productThumbnail: String,
        val productPrice: Double,
        val startedDate: Date,
        val endDate: Date
)