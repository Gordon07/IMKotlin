package com.gordon.kotlin_im.extentions

/**
 *    author : gordon
 *    e-mail : gordon_sun07@163.com
 *    date   : 2020/3/22 21:02
 *    version: 1.0
 *    desc   :
 *
 */

fun String.isValidUserName(): Boolean = this.matches(Regex("^[a-zA-Z]\\w{2,19}$"))
fun String.isValidPassword(): Boolean = this.matches(Regex("^[0-9]{3,20}$"))

