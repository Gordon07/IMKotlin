package com.gordon.kotlin_im.presenter

import com.gordon.kotlin_im.adapter.EMCallBackAdapter
import com.gordon.kotlin_im.contract.LoginContract
import com.gordon.kotlin_im.extentions.isValidPassword
import com.gordon.kotlin_im.extentions.isValidUserName
import com.hyphenate.EMCallBack
import com.hyphenate.chat.EMClient

/**
 *    author : gordon
 *    e-mail : gordon_sun07@163.com
 *    date   : 2020/3/22 20:57
 *    version: 1.0
 *    desc   : 登录界面 Presenter
 *
 */
class LoginPresenter(val view:LoginContract.View) : LoginContract.Presenter {

    override fun login(userName: String, passWd: String) {
        if (userName.isValidUserName() && passWd.isValidPassword()) {
            view.onStartLogin()
            loginEaseMob(userName, passWd)
        } else {
            view.onUserNameError()
        }
    }

    //登录到环信
    private fun loginEaseMob(userName: String, passWd: String) {
        EMClient.getInstance().login(userName, passWd, object : EMCallBackAdapter() {
            //在子线程回调的
            override fun onSuccess() {
                super.onSuccess()
                //model层实现
                EMClient.getInstance().groupManager().loadAllGroups()
                EMClient.getInstance().chatManager().loadAllConversations()
                uiThread { view.onLoggedInSuccess() }
            }

            override fun onError(p0: Int, p1: String?) {
                super.onError(p0, p1)
                uiThread { view.onLoggedInFailed() }
            }
        })
    }
}