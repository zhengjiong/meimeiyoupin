package com.meimeiyoupin.mvp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import butterknife.BindView
import com.jess.arms.di.component.AppComponent
import com.jess.arms.mvp.IPresenter
import com.meimeiyoupin.R
import com.meimeiyoupin.mvp.ui.base.BaseSupportFragment
import com.meimeiyoupin.utils.IntentKey

/**
 *
 * Copyright:Copyright(c) 2018
 * CreateTime:18/4/26$  09:28$
 * @author 郑炯
 * @version 1.0
 */

class DialogItemListFragment : BaseSupportFragment<IPresenter>() {

    @BindView(R.id.listview)
    lateinit var listView: ListView

    companion object {

        @JvmStatic
        fun newInstance(args: ArrayList<String>?): DialogItemListFragment {
            return DialogItemListFragment().apply {
                val bundle = Bundle()
                arguments = bundle
                if (args != null) {
                    bundle.putStringArrayList(IntentKey.KEY_ITEMS, args)
                }
            }
        }
    }

    override fun setupFragmentComponent(appComponent: AppComponent) {
    }

    override fun setData(data: Any?) {

    }

    override fun initView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.module_fragment_dialog_item_list, container, false)
    }

    override fun initData(savedInstanceState: Bundle?) {
        var strArr: ArrayList<String>? = null
        if (savedInstanceState == null) {
            strArr = arguments?.getStringArrayList(IntentKey.KEY_ITEMS)
        }
        listView.adapter = DialogItemListAdapter(strArr)
    }

    class DialogItemListAdapter(val items: ArrayList<String>?) : BaseAdapter() {
        override fun getItem(position: Int): Any {
            return items!!.get(position)
        }

        override fun getItemId(position: Int) = position.toLong()

        class Holder(view: View) {
            val title: TextView = view.findViewById(R.id.tv_title)
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var holder: Holder
            var view = convertView
            val title = items!![position]

            if (view == null) {
                view = LayoutInflater.from(parent!!.context).inflate(R.layout.module_fragment_dialog_item, parent, false)
                holder = Holder(view)
                view.tag = holder
            } else {
                holder = view.tag as Holder
            }
            holder.title.text = title
            return view!!
        }

        override fun getCount(): Int {
            return items?.size ?: 0
        }

    }
}