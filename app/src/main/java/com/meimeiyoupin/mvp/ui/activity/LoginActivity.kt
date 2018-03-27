package com.meimeiyoupin.mvp.ui.activity

import android.os.Bundle
import android.widget.TextView
import butterknife.BindView
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.jakewharton.rxbinding2.view.RxView
import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.mvp.IPresenter
import com.meimeiyoupin.R
import com.meimeiyoupin.app.ARouterPath
import java.util.concurrent.TimeUnit

/**
 *
 * Copyright:Copyright(c) 2018
 * CreateTime:18/3/4$  15:44$
 * @author 郑炯
 * @version 1.0
 */
@Route(path = "/app/login")
class LoginActivity : BaseActivity<IPresenter>() {
    @BindView(R.id.tv_login)
    lateinit var tvLogin: TextView


    override fun initData(savedInstanceState: Bundle?) {
        RxView.clicks(tvLogin).throttleFirst(1000, TimeUnit.MILLISECONDS).subscribe({
            ARouter.getInstance().build(ARouterPath.UPLOAD_PICTURE).navigation()
            finish()
        }, {

        })
    }

    override fun setupActivityComponent(appComponent: AppComponent?) {

    }

    override fun initView(savedInstanceState: Bundle?) = R.layout.module_activity_login

}