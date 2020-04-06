package com.gordon.kotlin_im.contract

import com.gordon.kotlin_im.presenter.BasePresenter

/**
 *    author : gordon
 *    e-mail : gordon_sun07@163.com
 *    date   : 2020/4/6 14:16
 *    version: 1.0
 *    desc   :
 *
 */

interface RegisterContract {

    interface Presenter : BasePresenter {
        fun register(userName: String, password: String, confirmPassword: String)
    }

    interface View {
        fun onUserNameError()
        fun onPasswordError()
        fun onConfirmPasswordError()
        fun onStartRegister()
        fun onRegisterSuccess()
        fun onRegisterFailed()
    }
}