package com.gordon.kotlin_im.contract

/**
 *    author : gordon
 *    e-mail : gordon_sun07@163.com
 *    date   : 2020/3/22 17:37
 *    version: 1.0
 *    desc   : 闪屏页的协议类， presenter view类
 *
 */
class SplashContract {

    interface Presenter:BasePresenter {
        fun checkLoginStatus() //检查登录状态
    }

    interface View {
        fun onNoLoggedIn() //没有登录ui的处理
        fun onLoggedIn()
    }
}