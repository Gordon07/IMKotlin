package com.gordon.kotlin_im.presenter

import com.gordon.kotlin_im.contract.ContactContract
import com.gordon.kotlin_im.data.ContactListItem
import com.hyphenate.chat.EMClient
import com.hyphenate.exceptions.HyphenateException
import org.jetbrains.anko.doAsync

/**
 *    author : gordon
 *    e-mail : gordon_sun07@163.com
 *    date   : 2020/4/19 18:29
 *    version: 1.0
 *    desc   :
 *
 */
class ContactPresenter(val view: ContactContract.View) : ContactContract.Presenter {

    val contactListItems = mutableListOf<ContactListItem>()

    override fun loadContacts() {
        //异步
        doAsync {
            try {
                val userNames = EMClient.getInstance().contactManager().allContactsFromServer
                //根据首字符排序
                userNames.sortBy { it[0] }
                userNames.forEach {
                    val contactListItem = ContactListItem(it, it[0].toUpperCase())
                    contactListItems.add(contactListItem)
                }
                uiThread {
                    view.onLoadContactSuccess()
                }
            } catch (e: HyphenateException) {
                view.onLoadContactFailed()
            }
        }
    }
}