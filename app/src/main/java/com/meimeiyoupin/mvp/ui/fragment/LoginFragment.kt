package com.meimeiyoupin.mvp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.jakewharton.rxbinding2.view.RxView
import com.jess.arms.di.component.AppComponent
import com.jess.arms.mvp.IPresenter
import com.meimeiyoupin.R
import com.meimeiyoupin.app.ARouterPath
import com.meimeiyoupin.mvp.ui.base.BaseSupportFragment
import kotlinx.android.synthetic.main.module_fragment_login.*
import java.util.concurrent.TimeUnit

/**
 *
 * Copyright:Copyright(c) 2018
 * CreateTime:18/4/28$  09:46$
 * @author 郑炯
 * @version 1.0
 */

@Route(path = ARouterPath.LOGIN)
class LoginFragment : BaseSupportFragment<IPresenter>() {

    companion object {
        @JvmStatic
        fun newInstance() = LoginFragment()
    }

    override fun setupFragmentComponent(appComponent: AppComponent) {

    }

    override fun setData(data: Any?) {

    }

    override fun initView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.module_fragment_login, container, false)
    }

    override fun initData(savedInstanceState: Bundle?) {
        RxView.clicks(tvLogin).throttleFirst(300, TimeUnit.MILLISECONDS).subscribe({
            ARouter.getInstance().build(ARouterPath.UPLOAD_PICTURE).navigation()
            pop()
        }, {

        })

        toolbar.setNavigationOnClickListener {
            pop()
        }
    }

}