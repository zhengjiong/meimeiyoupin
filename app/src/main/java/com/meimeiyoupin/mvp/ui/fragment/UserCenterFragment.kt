package com.meimeiyoupin.mvp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alibaba.android.arouter.facade.annotation.Route
import com.jess.arms.di.component.AppComponent
import com.jess.arms.mvp.IPresenter
import com.meimeiyoupin.R
import com.meimeiyoupin.app.ARouterPath
import com.meimeiyoupin.mvp.ui.base.BaseSupportFragment

/**
 *
 * Copyright:Copyright(c) 2018
 * CreateTime:18/4/26$  17:58$
 * @author 郑炯
 * @version 1.0
 */

//@Route(path = ARouterPath.USER_CENTER)
class UserCenterFragment : BaseSupportFragment<IPresenter>() {
    override fun setupFragmentComponent(appComponent: AppComponent) {

    }

    override fun setData(data: Any?) {

    }

    override fun initView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.module_fragment_dialog_item, container, false)
    }

    override fun initData(savedInstanceState: Bundle?) {

    }

}