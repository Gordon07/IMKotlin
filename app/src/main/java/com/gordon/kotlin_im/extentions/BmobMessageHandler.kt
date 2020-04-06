package com.gordon.kotlin_im.extentions

import cn.bmob.newim.event.MessageEvent
import cn.bmob.newim.event.OfflineMessageEvent
import cn.bmob.newim.listener.BmobIMMessageHandler

/**
 *    author : gordon
 *    e-mail : gordon_sun07@163.com
 *    date   : 2020/4/6 17:10
 *    version: 1.0
 *    desc   : 处理服务器发来的消息和离线消息
 *
 */
class BmobMessageHandler : BmobIMMessageHandler() {

    //TODO 集成：1.6、自定义消息接收器处理在线消息和离线消息
    override fun onMessageReceive(p0: MessageEvent?) {
        super.onMessageReceive(p0)
        //在线消息
    }

    override fun onOfflineReceive(p0: OfflineMessageEvent?) {
        super.onOfflineReceive(p0)
        //离线消息，每次connect的时候会查询离线消息，如果有，此方法会被调用
    }
}