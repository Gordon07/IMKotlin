package com.gordon.kotlin_im.extentions

import android.os.Process
import java.io.BufferedReader
import java.io.File
import java.io.FileReader

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

/**
 * 获取当前运行的进程名
 * @return
 */
fun getMyProcessName(): String? {
    return try {
        val file = File("/proc/" + Process.myPid() + "/" + "cmdline")
        val mBufferedReader = BufferedReader(FileReader(file))
        val processName: String = mBufferedReader.readLine().trim()
        mBufferedReader.close()
        processName
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}

