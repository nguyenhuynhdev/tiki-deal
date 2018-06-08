package vn.tiki.android.androidhometest.view.adapter

import android.annotation.SuppressLint
import android.databinding.BindingAdapter
import android.support.v7.widget.AppCompatImageView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView

import com.squareup.picasso.Picasso

import vn.tiki.android.androidhometest.databinding.ItemDealBinding
import vn.tiki.android.androidhometest.view.component.CountDownTextView
import vn.tiki.domain.model.DealModel


class DealsAdapter : RecyclerView.Adapter<DealsAdapter.DealViewHolder>() {

    companion object {

        @SuppressLint("SetTextI18n")
        @BindingAdapter("android:src")
        @JvmStatic
        fun setImageAssets(appCompatImageView: AppCompatImageView, resource: String) {
            Picasso.get().load(resource).into(appCompatImageView)
        }

        @SuppressLint("SetTextI18n")
        @BindingAdapter("android:text")
        @JvmStatic
        fun setPrice(textView: TextView, resource: Double) {
            textView.text = "$resource $"
        }

        @SuppressLint("SetTextI18n")
        @BindingAdapter("android:text")
        @JvmStatic
        fun setCountDown(textView: CountDownTextView, deal: DealModel) {
            textView.deal = deal
        }
    }

    var deals: MutableList<DealModel> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    var onDealItemClickListener: OnDealItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DealViewHolder {
        val itemBinding = ItemDealBinding.inflate(
                LayoutInflater.from(parent.context), parent, false)
        return DealViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: DealViewHolder, position: Int) {
        val deal = deals[position]
        holder.bind(deal)
    }

    override fun getItemCount(): Int = deals.size

    inner class DealViewHolder
    constructor(private val itemDealBinding: ItemDealBinding) :
            RecyclerView.ViewHolder(itemDealBinding.root) {

        fun bind(deal: DealModel) {
            itemDealBinding.deal = deal
            itemDealBinding.dealCardViewContainer.setOnClickListener {
                onDealItemClickListener?.onDealItemClick(deal.productName)
            }
            itemDealBinding.btnBuy.setOnClickListener {
                onDealItemClickListener?.onBuy(deal.productPrice)
            }
            itemDealBinding.txtCountdown.onTimeEndedListener =
                    object : CountDownTextView.OnTimeEndedListener {
                        override fun onExpiration(deal: DealModel) {
                            val index = deals.indexOf(deal)
                            deals.remove(deal)
                            notifyItemRemoved(index)
                            onDealItemClickListener?.onDealRemove()
                        }
                    }
            itemDealBinding.executePendingBindings()
        }
    }

    interface OnDealItemClickListener {

        fun onDealItemClick(name: String)

        fun onBuy(price: Double)

        fun onDealRemove()
    }
}