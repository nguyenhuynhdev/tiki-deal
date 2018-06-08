package vn.tiki.android.androidhometest.view.fragment

import android.widget.Toast
import dagger.android.support.DaggerFragment

/**
 * Base [android.app.Fragment] class for every fragment in this application.
 */
abstract class BaseFragment : DaggerFragment() {
    /**
     * Shows a [android.widget.Toast] message.

     * @param message An string representing a message to be shown.
     */
    protected fun showToastMessage(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }

}