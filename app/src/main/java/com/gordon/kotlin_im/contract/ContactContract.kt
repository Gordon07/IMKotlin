package com.gordon.kotlin_im.contract

import com.gordon.kotlin_im.presenter.BasePresenter

/**
 *    author : gordon
 *    e-mail : gordon_sun07@163.com
 *    date   : 2020/4/19 17:13
 *    version: 1.0
 *    desc   :
 *
 */
interface ContactContract {

    interface Presenter: BasePresenter {
        fun loadContacts()
    }

    interface View {
        fun onLoadContactSuccess()
        fun onLoadContactFailed()
    }
}