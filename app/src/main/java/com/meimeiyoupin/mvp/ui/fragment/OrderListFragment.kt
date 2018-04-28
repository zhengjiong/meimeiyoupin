package com.meimeiyoupin.mvp.ui.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alibaba.android.arouter.facade.annotation.Route
import com.jess.arms.di.component.AppComponent
import com.jess.arms.mvp.IPresenter
import com.meimeiyoupin.R
import com.meimeiyoupin.app.ARouterPath
import com.meimeiyoupin.mvp.ui.base.BaseSupportFragment
import kotlinx.android.synthetic.main.module_fragment_order_list.*

/**
 *
 * Copyright:Copyright(c) 2018
 * CreateTime:18/4/28$  13:21$
 * @author 郑炯
 * @version 1.0
 */
@Route(path = ARouterPath.ORDER_LIST)
class OrderListFragment : BaseSupportFragment<IPresenter>() {

    companion object {
        @JvmStatic
        fun newInstance() = OrderListFragment()
    }

    override fun setupFragmentComponent(appComponent: AppComponent) {

    }

    override fun setData(data: Any?) {

    }

    override fun initView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.module_fragment_order_list, container, false)
    }

    override fun initData(savedInstanceState: Bundle?) {
        toolbar.title = "消费记录"
        recyclerView.layoutManager = LinearLayoutManager(context)
        refreshLayout.setOnRefreshListener { refreshlayout ->
            refreshlayout?.finishRefresh()
        }
    }

}