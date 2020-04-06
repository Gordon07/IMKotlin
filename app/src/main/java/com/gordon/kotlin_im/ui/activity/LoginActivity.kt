package com.gordon.kotlin_im.ui.activity

import android.Manifest
import android.content.pm.PackageManager
import android.view.KeyEvent
import android.widget.TextView
import androidx.core.app.ActivityCompat
import com.gordon.kotlin_im.ui.BaseActivity
import com.gordon.kotlin_im.R
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
        newUser.setOnClickListener {
            startActivity<RegisterActivity>()
        }
        login.setOnClickListener { login() }
        //方法1
        password.setOnEditorActionListener(object : TextView.OnEditorActionListener {
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
        //隐藏软键盘
        hideSoftKeyboard()
        if (hasWriteExternalStoragePermission()) {
            val userNameString = userName.text.trim().toString()
            val passwordString = password.text.trim().toString()
            presenter.login(userNameString, passwordString)
        } else {
            applyWriteExternalStoragePermission()
        }

    }

    private fun applyWriteExternalStoragePermission() {
        val permission = arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        ActivityCompat.requestPermissions(this, permission, 0)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            //同意
            login()
        } else {
            //toast 拒绝
            toast("用户拒绝")
        }
    }

    private fun hasWriteExternalStoragePermission(): Boolean {
        val result =
            ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
        return result == PackageManager.PERMISSION_GRANTED
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