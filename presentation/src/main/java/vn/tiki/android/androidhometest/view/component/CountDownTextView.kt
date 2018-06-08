package vn.tiki.android.androidhometest.view.component

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import vn.tiki.android.androidhometest.R
import vn.tiki.android.androidhometest.util.TimeConvert
import vn.tiki.domain.model.DealModel

class CountDownTextView : TextView, Runnable {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) :
            super(context, attrs, defStyle)

    var onTimeEndedListener: OnTimeEndedListener? = null
    var deal: DealModel? = null
        set(value) {
            field = value
            removeCallbacks(this)
            post(this)
        }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        post(this)
    }

    @SuppressLint("SetTextI18n")
    override fun run() {
        deal?.let {
            val milis = (it.endDate.time) - System.currentTimeMillis()
            if (milis <= 0) {
                onTimeEndedListener?.onExpiration(it)
                removeCallbacks(this)
            } else {
                text = "${resources.getString(R.string.time_left)} ${TimeConvert.millisToTime(milis)}"
                postDelayed(this, 1000)
            }
        }
    }

    override fun onDetachedFromWindow() {
        removeCallbacks(this)
        super.onDetachedFromWindow()
    }

    interface OnTimeEndedListener {

        fun onExpiration(deal: DealModel)
    }
}