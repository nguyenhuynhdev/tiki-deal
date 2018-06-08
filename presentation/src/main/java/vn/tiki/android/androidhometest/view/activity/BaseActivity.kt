package vn.tiki.android.androidhometest.view.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import dagger.android.support.DaggerAppCompatActivity
import vn.tiki.android.androidhometest.extensions.hiddenNavigation
import vn.tiki.android.androidhometest.extensions.setFullScreen

/**
 * Base [android.app.Activity] class for every Activity in this application.
 */
abstract class BaseActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFullScreen()
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            supportActionBar?.hide()
            window.hiddenNavigation()
        }
    }

    /**
     * Adds a [Fragment] to this activity's layout.

     * @param containerViewId The container view to where add the fragment.
     * *
     * @param fragment        The fragment to be added.
     */
    protected fun replaceFragment(containerViewId: Int, fragment: Fragment) {
        val fragmentTransaction = this.supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(containerViewId, fragment)
        fragmentTransaction.commit()
    }

}
