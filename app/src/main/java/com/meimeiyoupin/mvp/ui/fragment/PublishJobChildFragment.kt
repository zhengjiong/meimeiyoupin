package com.meimeiyoupin.mvp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.flexbox.FlexboxLayoutManager
import com.jess.arms.di.component.AppComponent
import com.jess.arms.mvp.IPresenter
import com.meimeiyoupin.R
import com.meimeiyoupin.mvp.ui.adapter.PublishJobFlexItemAdapter
import com.meimeiyoupin.mvp.ui.base.BaseSupportFragment
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration
import kotlinx.android.synthetic.main.module_fragment_job_child.*

/**
 *
 * Copyright:Copyright(c) 2018
 * CreateTime:18/4/28$  15:15$
 * @author 郑炯
 * @version 1.0
 */


class PublishJobChildFragment : BaseSupportFragment<IPresenter>() {

    companion object {
        @JvmStatic
        fun newInstance() = PublishJobChildFragment()
    }

    override fun setupFragmentComponent(appComponent: AppComponent) {
    }

    override fun setData(data: Any?) {
    }

    override fun initView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.module_fragment_job_child, container, false)
    }

    override fun initData(savedInstanceState: Bundle?) {

        recyclerView.layoutManager = FlexboxLayoutManager(context)
        recyclerView.addItemDecoration(
                HorizontalDividerItemDecoration.Builder(context)
                        .size(resources.getDimensionPixelSize(R.dimen.margin_8))
                        .colorResId(android.R.color.transparent)
                        .build()
        )
        val adapter = PublishJobFlexItemAdapter()
        recyclerView.adapter = adapter
        adapter.setNewData(mutableListOf(
                "A",
                "AA",
                "AAA",
                "AAAA",
                "AAAAA",
                "AAAAAA",
                "AAAAAAA",
                "AAAAAAAA",
                "AAAAAAAAA",
                "AAAAAAAAAA",
                "AAAAAAAAAAA",
                "AAAAAAAAAAAA",
                "AAAAAAAAAAAAA",
                "AAAAAAAAAAAAAA",
                "AAAAAAAAAAAAAAA",
                "AAAAAAAAAAAAAAAA",
                "AAAAAAAAAAAAAAAAA",
                "AAAAAAAAAAAAAAAAAA",
                "AAAAAAAAAAAAAAAAAAA",
                "AAAAAAAAAAAAAAAAAAAA",
                "AAAAAAAAAAAAAAAAAAAAA",
                "AAAAAAAAAAAAAAAAAAAAAA",
                "AAAAAAAAAAAAAAAAAAAAAAA"
        ))
    }

}