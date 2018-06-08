package vn.tiki.android.androidhometest.view

import vn.tiki.domain.model.DealModel

interface MainView {

    fun showToast(message: Any)

    fun initializeView()

    fun updateDeals(deals: MutableList<DealModel>)
}