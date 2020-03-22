package com.gordon.kotlin_im

import android.os.Handler
import com.gordon.kotlin_im.contract.SplashContract
import com.gordon.kotlin_im.contract.SplashPresenter
import org.jetbrains.anko.startActivity

/**
 *    author : gordon
 *    e-mail : gordon_sun07@163.com
 *    date   : 2020/3/22 17:30
 *    version: 1.0
 *    desc   : 闪屏页
 *
 */
class SplashActivity : BaseActivity(), SplashContract.View {

    val presenter = SplashPresenter(this)

    //定义常量
    companion object {
        val DELAY = 2000L
    }

    //定义handler
    val handler by lazy {
        Handler()
    }

    override fun init() {
        super.init()
        presenter.checkLoginStatus()
    }

    override fun getLayoutResId(): Int {
        return R.layout.activity_splash
    }

    override fun onNoLoggedIn() {
        //跳转登录界面
        //方法1：匿名对象用object
        handler.postDelayed(object : Runnable {
            override fun run() {
                //依赖anko库实现跳转函数
                startActivity<LoginActivity>()
                finish()
            }
        }, DELAY)

        //方法2：匿名函数的lamada表达式
        /*handler.postDelayed({
            //依赖anko库实现跳转函数
            startActivity<LoginActivity>()
            finish()
        }, DELAY)*/
    }

    override fun onLoggedIn() {
        //跳转主界面
        startActivity<MainActivity>()
        finish()
    }
}