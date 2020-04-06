package com.gordon.kotlin_im.factory

import androidx.fragment.app.Fragment
import com.gordon.kotlin_im.R
import com.gordon.kotlin_im.ui.fragment.ContactFragment
import com.gordon.kotlin_im.ui.fragment.ConversationFragment
import com.gordon.kotlin_im.ui.fragment.DynamicFragment

/**
 *    author : gordon
 *    e-mail : gordon_sun07@163.com
 *    date   : 2020/4/6 19:35
 *    version: 1.0
 *    desc   : 单例模式
 *
 */
class FragmentFactory private constructor() {

    val conversation by lazy {
        ConversationFragment()
    }

    val contact by lazy {
        ContactFragment()
    }

    val dynamic by lazy {
        DynamicFragment()
    }

    companion object {
        val instance = FragmentFactory()
    }

    fun getFragment(tabId: Int): Fragment? {
        when (tabId) {
            R.id.tab_conversation -> return conversation
            R.id.tab_contacts -> return contact
            R.id.tab_dynamic -> return dynamic
        }
        return null
    }
}