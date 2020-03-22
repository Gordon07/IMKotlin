package com.gordon.kotlin_im

import android.app.ProgressDialog
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

    val progressDialog by lazy {
        ProgressDialog(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResId())
        init()
    }

    open fun init() {}

    abstract fun getLayoutResId(): Int

    fun showProgress(msg: String) {
        progressDialog.setMessage(msg)
        progressDialog.show()
    }

    fun dismissProgress() {
        progressDialog.dismiss()
    }
}