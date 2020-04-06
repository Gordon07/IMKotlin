package com.gordon.kotlin_im.presenter

import cn.bmob.v3.BmobUser
import cn.bmob.v3.exception.BmobException
import cn.bmob.v3.listener.SaveListener
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
                    registerBmob(userName, password)
                } else view.onConfirmPasswordError()
            } else view.onPasswordError()
        } else view.onUserNameError()
    }

    fun registerBmob(userName: String, password: String) {
        val bu = BmobUser()
        bu.username = userName
        bu.setPassword(password)
        bu.email = "sendi@163.com"
        //注意：不能用save方法进行注册
        @Suppress("MISSING_DEPENDENCY_CLASS")
        bu.signUp<BmobUser>(object : SaveListener<BmobUser>() {
            override fun done(p0: BmobUser?, p1: BmobException?) {
                if (p1 == null) {
                    //注册到Bmob
                    //注册到环信
                    //crash
                } else {
                    view.onRegisterFailed()
                }
            }
        })
    }
}