package com.gordon.kotlin_im.presenter

import com.gordon.kotlin_im.contract.LoginContract
import com.gordon.kotlin_im.extentions.isValidPassword
import com.gordon.kotlin_im.extentions.isValidUserName

/**
 *    author : gordon
 *    e-mail : gordon_sun07@163.com
 *    date   : 2020/3/22 20:57
 *    version: 1.0
 *    desc   :
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

    }
}