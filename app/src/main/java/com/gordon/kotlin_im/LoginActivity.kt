package com.gordon.kotlin_im

import android.view.KeyEvent
import android.widget.TextView
import com.gordon.kotlin_im.contract.LoginContract
import com.gordon.kotlin_im.presenter.LoginPresenter
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
class LoginActivity : BaseActivity(), LoginContract.View {

    val presenter = LoginPresenter(this)

    override fun getLayoutResId(): Int {
        return R.layout.activity_login
    }

    override fun init() {
        super.init()
        login.setOnClickListener { login() }
        //方法1
        password.setOnEditorActionListener(object : TextView.OnEditorActionListener{
            override fun onEditorAction(v: TextView?, actionId: Int, event: KeyEvent?): Boolean {
                login()
                return true
            }
        })
        //方法2
        /*password.setOnEditorActionListener { v, actionId, event ->
            login()
            true
        }*/
    }

    fun login() {
        val userNameString = userName.text.trim().toString()
        val passwordString = password.text.trim().toString()
        presenter.login(userNameString,passwordString)
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