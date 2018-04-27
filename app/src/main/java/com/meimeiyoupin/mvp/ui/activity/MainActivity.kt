package com.meimeiyoupin.mvp.ui.activity

import android.os.Bundle
import butterknife.BindView
import com.alibaba.android.arouter.facade.annotation.Route
import com.flyco.tablayout.CommonTabLayout
import com.flyco.tablayout.listener.OnTabSelectListener
import com.jess.arms.di.component.AppComponent
import com.jess.arms.mvp.IPresenter
import com.meimeiyoupin.mvp.ui.fragment.JobFragment
import com.meimeiyoupin.R
import com.meimeiyoupin.app.ARouterPath
import com.meimeiyoupin.mvp.model.entity.TabEntity
import com.meimeiyoupin.mvp.ui.base.BaseSupportActivity
import com.meimeiyoupin.mvp.ui.fragment.MainFragment
import com.meimeiyoupin.mvp.ui.fragment.ResumeFragment
import com.meimeiyoupin.mvp.ui.fragment.UserCenterFragment
import me.yokeyword.fragmentation.ISupportFragment

/**
 * Copyright:Copyright(c) 2018
 * CreateTime:18/3/4$  15:44$
 * @author 郑炯
 * @version 1.0
 */
@Route(path = ARouterPath.MAIN_PAGE)
class MainActivity : BaseSupportActivity<IPresenter>() {

    override fun setupActivityComponent(appComponent: AppComponent) {
    }

    override fun initData(savedInstanceState: Bundle?) {
        if (findFragment(MainFragment::class.java) == null) {
            loadRootFragment(R.id.fl_container, MainFragment.newInstance())
        }
    }


    override fun initView(savedInstanceState: Bundle?) = R.layout.module_activity_main


}
