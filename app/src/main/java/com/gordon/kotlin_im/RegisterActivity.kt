package com.gordon.kotlin_im

import com.gordon.kotlin_im.contract.RegisterContract
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.toast

/**
 *    author : gordon
 *    e-mail : gordon_sun07@163.com
 *    date   : 2020/4/6 14:08
 *    version: 1.0
 *    desc   :
 *
 */
class RegisterActivity : BaseActivity(), RegisterContract.View {
    override fun getLayoutResId(): Int {
        return R.layout.activity_register
    }

    override fun onUserNameError() {
        userName.error = getString(R.string.user_name_error)
    }

    override fun onPasswordError() {
        password.error = getString(R.string.password_error)
    }

    override fun onConfirmPasswordError() {
        confirmPassword.error = getString(R.string.confirm_password_error)
    }

    override fun onStartRegister() {
        showProgress(getString(R.string.registering))
    }

    override fun onRegisterSuccess() {
        dismissProgress()
        finish()
    }

    override fun onRegisterFailed() {
        dismissProgress()
        toast(getString(R.string.register_failed))
    }
}