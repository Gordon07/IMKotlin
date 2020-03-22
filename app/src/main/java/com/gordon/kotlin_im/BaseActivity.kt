package com.gordon.kotlin_im

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity

/**
 *    author : gordon
 *    e-mail : gordon_sun07@163.com
 *    date   : 2020/3/22 17:18
 *    version: 1.0
 *    desc   : 创建BaseActivity
 *
 */
abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResId())
        init()
    }

    open fun init() {}

    abstract fun getLayoutResId(): Int
}