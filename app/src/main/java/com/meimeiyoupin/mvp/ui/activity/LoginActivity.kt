package com.meimeiyoupin.mvp.ui.activity

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.mvp.IPresenter
import com.meimeiyoupin.R

/**
 *
 * Copyright:Copyright(c) 2018
 * CreateTime:18/3/4$  15:44$
 * @author 郑炯
 * @version 1.0
 */
@Route(path = "/app/login")
class LoginActivity : BaseActivity<IPresenter>() {

    override fun initData(savedInstanceState: Bundle?) {

    }

    override fun setupActivityComponent(appComponent: AppComponent?) {

    }

    override fun initView(savedInstanceState: Bundle?) = R.layout.module_activity_login

}