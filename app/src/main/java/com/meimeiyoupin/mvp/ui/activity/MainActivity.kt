package com.meimeiyoupin.mvp.ui.activity

import android.os.Bundle
import butterknife.BindView
import com.alibaba.android.arouter.facade.annotation.Route
import com.flyco.tablayout.CommonTabLayout
import com.flyco.tablayout.listener.OnTabSelectListener
import com.jess.arms.di.component.AppComponent
import com.jess.arms.mvp.IPresenter
import com.meimeiyoupin.R
import com.meimeiyoupin.app.ARouterPath
import com.meimeiyoupin.mvp.model.entity.TabEntity
import com.meimeiyoupin.mvp.ui.base.BaseSupportActivity
import com.meimeiyoupin.mvp.ui.fragment.JobFragment
import com.meimeiyoupin.mvp.ui.fragment.ResumeFragment
import me.yokeyword.fragmentation.ISupportFragment

/**
 * Copyright:Copyright(c) 2018
 * CreateTime:18/3/4$  15:44$
 * @author 郑炯
 * @version 1.0
 */
@Route(path = ARouterPath.MAIN_PAGE)
class MainActivity : BaseSupportActivity<IPresenter>() {

    @BindView(R.id.tab_layout)
    lateinit var tabLayout: CommonTabLayout
    private val mFragments by lazy {
        arrayOfNulls<ISupportFragment>(3)
    }

    override fun setupActivityComponent(appComponent: AppComponent) {
    }

    override fun initData(savedInstanceState: Bundle?) {
        mFragments[0] = JobFragment.newInstance()
        mFragments[1] = ResumeFragment.newInstance()
        mFragments[2] = ResumeFragment.newInstance()

        loadRootFragment(R.id.fl_container, mFragments[0]!!)

        tabLayout.run {
            setTabData(arrayListOf(
                    TabEntity("工作", R.mipmap.ic_home_selected, R.mipmap.ic_home_unselected),
                    TabEntity("简历", R.mipmap.ic_home_selected, R.mipmap.ic_home_unselected),
                    TabEntity("个人中心", R.mipmap.ic_home_selected, R.mipmap.ic_home_unselected)
            ))
            setOnTabSelectListener(object : OnTabSelectListener {
                override fun onTabSelect(position: Int) {
                    showHideFragment(mFragments[position])
                }

                override fun onTabReselect(position: Int) {

                }

            })
        }

    }


    override fun initView(savedInstanceState: Bundle?) = R.layout.module_activity_main


}
