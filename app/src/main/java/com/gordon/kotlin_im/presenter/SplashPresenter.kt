package com.gordon.kotlin_im.presenter

import com.gordon.kotlin_im.contract.SplashContract

/**
 *    author : gordon
 *    e-mail : gordon_sun07@163.com
 *    date   : 2020/3/22 17:57
 *    version: 1.0
 *    desc   : 闪屏页 SplashPresenter
 *
 */
//在构造方法中传递view，在view中创建presenter
class SplashPresenter(val view: SplashContract.View) :
    SplashContract.Presenter {

    override fun checkLoginStatus() {
        if (isLoggedIn()) {
            view.onLoggedIn()
        } else {
            view.onNoLoggedIn()
        }
    }

    //是否登录，实现在环信sdk
    private fun isLoggedIn(): Boolean {
        return false
    }
}