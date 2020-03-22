package com.gordon.kotlin_im.adapter

import com.hyphenate.EMCallBack

/**
 *    author : gordon
 *    e-mail : gordon_sun07@163.com
 *    date   : 2020/3/22 21:57
 *    version: 1.0
 *    desc   :
 *
 */
open class EMCallBackAdapter: EMCallBack {

    override fun onSuccess() {}

    override fun onProgress(p0: Int, p1: String?) {}

    override fun onError(p0: Int, p1: String?) {}
}