package com.gordon.kotlin_im.ui.fragment

import android.content.Context
import com.gordon.kotlin_im.R
import com.gordon.kotlin_im.adapter.EMCallBackAdapter
import com.gordon.kotlin_im.ui.BaseFragment
import com.gordon.kotlin_im.ui.activity.LoginActivity
import com.hyphenate.EMCallBack
import com.hyphenate.chat.EMClient
import kotlinx.android.synthetic.main.fragment_dynamic.*
import kotlinx.android.synthetic.main.header.*
import org.jetbrains.anko.runOnUiThread
import org.jetbrains.anko.toast

/**
 *    author : gordon
 *    e-mail : gordon_sun07@163.com
 *    date   : 2020/4/6 19:29
 *    version: 1.0
 *    desc   :
 *
 */
class DynamicFragment : BaseFragment() {
    override fun getLayoutResId(): Int {
        return R.layout.fragment_dynamic
    }

    override fun init() {
        super.init()
        headerTitle.text = getString(R.string.dynamic)

        val logoutString =
            String.format(getString(R.string.logout), EMClient.getInstance().currentUser)
        logout.text = logoutString

        logout.setOnClickListener { logout() }
    }

    fun logout() {
        EMClient.getInstance().logout(true, object : EMCallBackAdapter() {
            override fun onSuccess() {
                context?.runOnUiThread {
                    toast(R.string.logout_success)
                    //context.startActivity<LoginActivity>()
                    //activity.finish()
                }
            }

            override fun onError(p0: Int, p1: String?) {
                //切换到主线程
                context?.runOnUiThread { toast(R.string.login_failed) }
            }
        })
    }
}

