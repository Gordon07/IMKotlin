package com.gordon.kotlin_im.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gordon.kotlin_im.widget.ContactListItemView

/**
 *    author : gordon
 *    e-mail : gordon_sun07@163.com
 *    date   : 2020/4/19 16:56
 *    version: 1.0
 *    desc   : 联系人适配器
 *
 */
class ContactListAdapter(val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ContactListItemViewHolder(ContactListItemView(context))
    }

    override fun getItemCount(): Int {

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    class ContactListItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}