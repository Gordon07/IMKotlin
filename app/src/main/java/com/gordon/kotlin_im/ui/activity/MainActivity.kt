package com.gordon.kotlin_im.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gordon.kotlin_im.R
import com.gordon.kotlin_im.factory.FragmentFactory
import com.gordon.kotlin_im.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun getLayoutResId(): Int {
        return R.layout.activity_main
    }

    override fun init() {
        super.init()
        bottomBar.setOnTabReselectListener { tabId ->
            val beginTransaction = supportFragmentManager.beginTransaction()
            beginTransaction.replace(
                R.id.fragment_frame,
                FragmentFactory.instance.getFragment(tabId)!!
            )
            beginTransaction.commit()
        }
    }
}
