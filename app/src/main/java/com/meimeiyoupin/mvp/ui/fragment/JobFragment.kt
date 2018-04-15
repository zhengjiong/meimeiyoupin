package com.meimeiyoupin.mvp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jess.arms.di.component.AppComponent
import com.jess.arms.mvp.IPresenter
import com.meimeiyoupin.R
import com.meimeiyoupin.mvp.ui.base.BaseSupportFragment

/**
 * Created by zhengjiong
 * date: 2018/4/15 11:30
 */

class JobFragment : BaseSupportFragment<IPresenter>() {

    companion object {
        @JvmStatic
        fun newInstance(): JobFragment {
            return JobFragment()
        }
    }

    override fun setupFragmentComponent(appComponent: AppComponent?) {

    }

    override fun initData(savedInstanceState: Bundle?) {

    }

    override fun initView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater!!.inflate(R.layout.module_fragment_job, container, false)
    }

    override fun setData(data: Any?) {

    }

}