package com.gordon.kotlin_im.presenter

import android.os.Handler
import android.os.Looper


/**
 *    author : gordon
 *    e-mail : gordon_sun07@163.com
 *    date   : 2020/3/22 17:35
 *    version: 1.0
 *    desc   : 整个项目的BasePresenter
 *
 */
interface BasePresenter {

    companion object {
        val handler by lazy {
            Handler(Looper.getMainLooper())
        }
    }

    //线程切换
    fun uiThread(f: () -> Unit) {
        handler.post(object : Runnable {
            override fun run() {
                f()
            }
        })
    }
}