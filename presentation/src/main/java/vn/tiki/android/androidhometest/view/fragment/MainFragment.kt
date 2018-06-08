package vn.tiki.android.androidhometest.view.fragment

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import vn.tiki.android.androidhometest.R
import vn.tiki.android.androidhometest.databinding.FragmentMainBinding
import vn.tiki.android.androidhometest.presenter.MainPresenter
import vn.tiki.android.androidhometest.view.MainView
import vn.tiki.android.androidhometest.view.adapter.DealsAdapter
import vn.tiki.domain.model.DealModel
import javax.inject.Inject

class MainFragment : BaseFragment(), MainView {

    @Inject
    lateinit var mainPresenter: MainPresenter
    private val dealsAdapter = DealsAdapter()
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_main, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainPresenter.initView(this)
    }

    override fun onResume() {
        super.onResume()
        mainPresenter.resume()
    }

    override fun onPause() {
        super.onPause()
        mainPresenter.pause()
    }

    override fun onDestroyView() {
        mainPresenter.destroy()
        super.onDestroyView()
    }

    override fun showToast(message: Any) {
        showToastMessage(message.toString())
    }

    override fun initializeView() {
        binding.recycleViewDeals.layoutManager = GridLayoutManager(activity, 2)
        binding.recycleViewDeals.adapter = dealsAdapter
        dealsAdapter.onDealItemClickListener = onDealItemClickListener
    }

    override fun updateDeals(deals: MutableList<DealModel>) {
        dealsAdapter.deals = deals
    }

    private val onDealItemClickListener = object : DealsAdapter.OnDealItemClickListener {

        override fun onDealItemClick(name: String) {
            showToastMessage(name)
        }

        override fun onBuy(price: Double) {
            showToastMessage("$price $")
        }

    }
}