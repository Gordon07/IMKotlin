package com.gordon.kotlin_im.ui.fragment

import android.view.View
import com.gordon.kotlin_im.R
import com.gordon.kotlin_im.ui.BaseFragment
import kotlinx.android.synthetic.main.fragment_contacts.*
import kotlinx.android.synthetic.main.header.*

/**
 *    author : gordon
 *    e-mail : gordon_sun07@163.com
 *    date   : 2020/4/6 19:29
 *    version: 1.0
 *    desc   :
 *
 */
class ContactFragment : BaseFragment() {

    override fun getLayoutResId(): Int {
        return R.layout.fragment_contacts
    }

    override fun init() {
        super.init()
        headerTitle.text = getString(R.string.contact)
        add.visibility = View.VISIBLE
        swipeRefreshLayout.setBackgroundColor(resources.getColor(R.color.qq_blue))

    }
}