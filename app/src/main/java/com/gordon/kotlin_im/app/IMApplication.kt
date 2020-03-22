package com.gordon.kotlin_im.app

import android.app.Application
import com.hyphenate.chat.EMClient
import com.hyphenate.chat.EMOptions

/**
 *    author : gordon
 *    e-mail : gordon_sun07@163.com
 *    date   : 2020/3/22 19:58
 *    version: 1.0
 *    desc   :
 *
 */
class IMApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        initHuanXinSDK()
    }

    private fun initHuanXinSDK() {
        var options = EMOptions()
        // 默认添加好友时，是不需要验证的，改成需要验证
        options.setAcceptInvitationAlways(false)
        // 是否自动将消息附件上传到环信服务器，默认为True是使用环信服务器上传下载，如果设为 false，需要开发者自己处理附件消息的上传和下载
        options.setAutoTransferMessageAttachments(true)
        // 是否自动下载附件类消息的缩略图等，默认为 true 这里和上边这个参数相关联
        options.setAutoDownloadThumbnail(true)
        //初始化
        EMClient.getInstance().init(applicationContext, options)
        //在做打包混淆时，关闭debug模式，避免消耗不必要的资源
        EMClient.getInstance().setDebugMode(true)

        //方法2：
        //初始化
        /*EMClient.getInstance().init(applicationContext, EMOptions())
        //在做打包混淆时，关闭debug模式，避免消耗不必要的资源
        EMClient.getInstance().setDebugMode(true)*/
    }
}