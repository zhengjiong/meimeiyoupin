package com.meimeiyoupin.mvp.ui.activity

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.mvp.IPresenter
import com.jess.arms.utils.RxLifecycleUtils
import com.meimeiyoupin.R
import com.meimeiyoupin.app.ARouterPath
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

/**
 *
 * Copyright:Copyright(c) 2018
 * CreateTime:18/3/4$  15:39$
 * @author 郑炯
 * @version 1.0
 */
@Route(path = ARouterPath.LAUNCHER)
class LauncherActivity : BaseActivity<IPresenter>() {
    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.module_activity_launcher
    }

    override fun initData(savedInstanceState: Bundle?) {
        Observable.timer(1000, TimeUnit.MILLISECONDS)
                .compose(RxLifecycleUtils.bindToLifecycle(this))
                .subscribe {
                    //ARouter.getInstance().build("/app/login").navigation(this)
                    ARouter.getInstance().build(ARouterPath.MAIN_PAGE).navigation(this)
                    finish()
                }
    }

    override fun setupActivityComponent(appComponent: AppComponent) {

    }

}