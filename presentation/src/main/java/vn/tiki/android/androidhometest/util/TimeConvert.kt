package vn.tiki.android.androidhometest.util

import java.util.*

object TimeConvert {

    fun millisToTime(time: Long): String {
        val minute = (time / (1000 * 60)) % 60
        val second = (time / 1000) % 60
        val hour = (time / (1000 * 60 * 60) % 24)
        return String.format(Locale.US, "%02d:%02d:%02d",hour, minute, second)
    }
}