package com.meimeiyoupin.mvp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alibaba.android.arouter.facade.annotation.Route
import com.jakewharton.rxbinding2.view.RxView
import com.jess.arms.di.component.AppComponent
import com.jess.arms.mvp.IPresenter
import com.meimeiyoupin.R
import com.meimeiyoupin.app.ARouterPath
import com.meimeiyoupin.mvp.ui.base.BaseSupportFragment
import io.reactivex.functions.Consumer
import kotlinx.android.synthetic.main.module_fragment_infomation_write_layout.*
import me.yokeyword.fragmentation.ISupportFragment
import java.util.concurrent.TimeUnit

/**
 *
 * Copyright:Copyright(c) 2018
 * CreateTime:18/4/27$  18:21$
 * @author 郑炯
 * @version 1.0
 */

@Route(path = ARouterPath.INFORMATION_WRITE)
class InformationWriteFragment : BaseSupportFragment<IPresenter>() {

    companion object {
        @JvmStatic
        fun newInstance() = InformationWriteFragment()
    }

    override fun setupFragmentComponent(appComponent: AppComponent) {

    }

    override fun setData(data: Any?) {

    }

    override fun initView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.module_fragment_infomation_write_layout, container, false)
    }

    override fun initData(savedInstanceState: Bundle?) {
        toolbar.title = "资料填写"
        toolbar.setNavigationOnClickListener {
            pop()
        }

        RxView.clicks(btn_next)
                .throttleFirst(300, TimeUnit.MILLISECONDS)
                .subscribe(
                        {
                            start(UploadLicenseFragment.newInstance(), ISupportFragment.SINGLETOP)
                        },
                        {
                        }
                )
        btn_next

    }

}