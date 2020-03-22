package com.gordon.kotlin_im.contract

import com.gordon.kotlin_im.presenter.BasePresenter

/**
 *    author : gordon
 *    e-mail : gordon_sun07@163.com
 *    date   : 2020/3/22 20:27
 *    version: 1.0
 *    desc   : 登录界面协议
 *
 */
interface LoginContract {

    interface Presenter : BasePresenter {
        fun login(userName: String, passWd: String)
    }

    interface View {
        fun onUserNameError()
        fun onPasswordError()
        fun onStartLogin()
        fun onLoggedInSuccess()
        fun onLoggedInFailed()
    }
}