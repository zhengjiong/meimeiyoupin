package com.meimeiyoupin.mvp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.BindView
import com.flyco.tablayout.CommonTabLayout
import com.flyco.tablayout.listener.OnTabSelectListener
import com.jess.arms.di.component.AppComponent
import com.jess.arms.mvp.IPresenter
import com.meimeiyoupin.R
import com.meimeiyoupin.mvp.model.entity.TabEntity
import com.meimeiyoupin.mvp.ui.base.BaseSupportFragment
import me.yokeyword.fragmentation.ISupportFragment

/**
 *
 * Copyright:Copyright(c) 2018
 * CreateTime:18/4/27$  10:25$
 * @author 郑炯
 * @version 1.0
 */


class MainFragment : BaseSupportFragment<IPresenter>() {

    @BindView(R.id.tab_layout)
    lateinit var tabLayout: CommonTabLayout
    private val mFragments by lazy {
        arrayOfNulls<ISupportFragment>(3)
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()

    }

    override fun setupFragmentComponent(appComponent: AppComponent) {

    }

    override fun setData(data: Any?) {

    }

    override fun initView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.module_fragment_main, container, false)
    }

    override fun initData(savedInstanceState: Bundle?) {
        val firstFragment = findChildFragment(JobFragment::class.java)
        if (firstFragment == null) {
            mFragments[0] = JobFragment.newInstance()
            mFragments[1] = ResumeFragment.newInstance()
            mFragments[2] = UserCenterFragment.newInstance()
            loadMultipleRootFragment(R.id.fl_container, 0, mFragments[0], mFragments[1], mFragments[2])
        } else {
            mFragments[0] = firstFragment
            mFragments[1] = findChildFragment(ResumeFragment::class.java)
            mFragments[2] = findChildFragment(ResumeFragment::class.java)
        }

        tabLayout.run {
            setTabData(arrayListOf(
                    TabEntity("工作", R.mipmap.ic_home_selected, R.mipmap.ic_home_unselected),
                    TabEntity("简历", R.mipmap.ic_home_selected, R.mipmap.ic_home_unselected),
                    TabEntity("个人中心", R.mipmap.ic_home_selected, R.mipmap.ic_home_unselected)
            ))
            var prePosition = 0
            setOnTabSelectListener(object : OnTabSelectListener {
                override fun onTabSelect(position: Int) {
                    when (position) {
                        0 -> {
                            showHideFragment(mFragments[position], mFragments[prePosition])
                            prePosition = position
                        }
                        1 -> {
                            start(UploadPictureFragment.newInstance(), ISupportFragment.SINGLETOP)
                            tabLayout.currentTab = prePosition
                        }
                        2 -> {
                            showHideFragment(mFragments[position], mFragments[prePosition])
                            prePosition = position
                        }
                    }
                }

                override fun onTabReselect(position: Int) {
                    println("onTabReselect $position")
                }
            })
        }
    }

    fun startBrotherFragment(fragment: BaseSupportFragment<IPresenter>) {
        start(fragment)
    }
}