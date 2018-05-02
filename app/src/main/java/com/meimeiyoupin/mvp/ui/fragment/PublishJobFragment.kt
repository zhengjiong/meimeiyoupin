package com.meimeiyoupin.mvp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jess.arms.di.component.AppComponent
import com.jess.arms.mvp.IPresenter
import com.meimeiyoupin.R
import com.meimeiyoupin.mvp.ui.adapter.PublishJobChildPagerAdapter
import com.meimeiyoupin.mvp.ui.base.BaseSupportFragment
import kotlinx.android.synthetic.main.module_fragment_publish_job.*

/**
 *
 * Copyright:Copyright(c) 2018
 * CreateTime:18/4/28$  14:03$zu
 * @author 郑炯
 * @version 1.0
 */

class PublishJobFragment : BaseSupportFragment<IPresenter>() {

    companion object {
        @JvmStatic
        fun newInstance() = PublishJobFragment()
    }

    override fun setupFragmentComponent(appComponent: AppComponent) {

    }

    override fun setData(data: Any?) {

    }

    override fun initView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.module_fragment_publish_job, container, false)
    }

    override fun initData(savedInstanceState: Bundle?) {
        toolbar.title = "招聘岗位"
        toolbar.setNavigationOnClickListener {
            pop()
        }

        viewPager.adapter = PublishJobChildPagerAdapter(
                arrayOf("KTV招聘", "足浴招聘"),
                childFragmentManager
        )
        tabLayout.setViewPager(viewPager)
    }

}