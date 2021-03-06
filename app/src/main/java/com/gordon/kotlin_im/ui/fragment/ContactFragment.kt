package com.gordon.kotlin_im.ui.fragment

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.gordon.kotlin_im.R
import com.gordon.kotlin_im.adapter.ContactListAdapter
import com.gordon.kotlin_im.contract.ContactContract
import com.gordon.kotlin_im.presenter.ContactPresenter
import com.gordon.kotlin_im.ui.BaseFragment
import kotlinx.android.synthetic.main.fragment_contacts.*
import kotlinx.android.synthetic.main.header.*

/**
 *    author : gordon
 *    e-mail : gordon_sun07@163.com
 *    date   : 2020/4/6 19:29
 *    version: 1.0
 *    desc   : 联系人界面
 *
 */
class ContactFragment : BaseFragment(), ContactContract.View {

    val presenter = ContactPresenter(this)

    override fun getLayoutResId(): Int {
        return R.layout.fragment_contacts
    }

    override fun init() {
        super.init()
        headerTitle.text = getString(R.string.contact)
        add.visibility = View.VISIBLE
        //方法1
        /*swipeRefreshLayout.setBackgroundColor(resources.getColor(R.color.qq_blue))
        swipeRefreshLayout.isRefreshing = true;*/
        //方法2
        /*swipeRefreshLayout.apply {
            setColorSchemeResources(R.color.qq_blue)
            isRefreshing = true;
            setOnRefreshListener {presenter.loadContacts()}
        }*/

        //recyclerView 初始化
        recyclerView.apply {
            /*setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = ContactListAdapter(context, presenter.contactListItems)*/
        }

        //加载联系人数据
        presenter.loadContacts()
    }

    override fun onLoadContactSuccess() {
        /*swipeRefreshLayout.isRefreshing = false
        recyclerView.adapter.notifyDataSetChanged()*/
    }

    override fun onLoadContactFailed() {
        /*swipeRefreshLayout.isRefreshing = false*/
    }
}