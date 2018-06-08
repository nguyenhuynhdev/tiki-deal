package vn.tiki.android.androidhometest.view.activity

import android.databinding.DataBindingUtil
import android.os.Bundle

import vn.tiki.android.androidhometest.R
import vn.tiki.android.androidhometest.databinding.ActivityMainBinding
import vn.tiki.android.androidhometest.view.fragment.MainFragment

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        replaceFragment(R.id.activity_container, MainFragment())
    }
}
