package com.gordon.kotlin_im

import com.gordon.kotlin_im.contract.LoginContract
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

/**
 *    author : gordon
 *    e-mail : gordon_sun07@163.com
 *    date   : 2020/3/22 17:45
 *    version: 1.0
 *    desc   : 创建登录界面
 *
 */
class LoginActivity:BaseActivity(), LoginContract.View {

    override fun getLayoutResId(): Int {
        return R.layout.activity_login
    }

    override fun init() {
        super.init()

    }

    override fun onUserNameError() {
        //userName.setError(getString(R.string.user_name_error))
        userName.error = getString(R.string.user_name_error)
    }

    override fun onPasswordError() {
        password.error = getString(R.string.password_error)
    }

    override fun onStartLogin() {
        showProgress(getString(R.string.logging))
    }

    override fun onLoggedInSuccess() {
        dismissProgress()
        //进入主界面,退出登录界面
        startActivity<MainActivity>()
        finish()
    }

    override fun onLoggedInFailed() {
        dismissProgress()
        toast(getString(R.string.login_failed))
    }
}