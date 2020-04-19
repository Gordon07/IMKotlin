package com.gordon.kotlin_im.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.gordon.kotlin_im.R
import com.gordon.kotlin_im.data.ContactListItem
import kotlinx.android.synthetic.main.view_contact_item.view.*

/**
 *    author : gordon
 *    e-mail : gordon_sun07@163.com
 *    date   : 2020/4/19 16:43
 *    version: 1.0
 *    desc   : 自定义控件
 *
 */

class ContactListItemView(context: Context?, attrs: AttributeSet? = null) :
    RelativeLayout(context, attrs) {

    fun bindView(contactListItem: ContactListItem) {
        firstLetter.text = contactListItem.firstLetter.toString()
        userName.text = contactListItem.userName
    }

    init {
        View.inflate(context, R.layout.view_contact_item, this)
    }
}