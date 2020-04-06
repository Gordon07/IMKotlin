package com.gordon.kotlin_im.presenter

import com.gordon.kotlin_im.contract.RegisterContract
import com.gordon.kotlin_im.extentions.isValidPassword
import com.gordon.kotlin_im.extentions.isValidUserName

/**
 *    author : gordon
 *    e-mail : gordon_sun07@163.com
 *    date   : 2020/4/6 14:33
 *    version: 1.0
 *    desc   :
 *
 */

class RegisterPresenter(val view: RegisterContract.View) : RegisterContract.Presenter {

    override fun register(userName: String, password: String, confirmPassword: String) {
        if (userName.isValidUserName()) {
            //检查密码
            if (password.isValidPassword()) {
                if (password.equals(confirmPassword)) {
                    //开始注册
                    view.onStartRegister()
                } else view.onConfirmPasswordError()
            } else view.onPasswordError()
        } else view.onUserNameError()
    }

}