package com.meimeiyoupin.mvp.ui.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.BindView
import com.bigkoo.convenientbanner.ConvenientBanner
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator
import com.blankj.utilcode.util.ConvertUtils
import com.jess.arms.di.component.AppComponent
import com.jess.arms.mvp.IPresenter
import com.meimeiyoupin.R
import com.meimeiyoupin.mvp.model.entity.Job
import com.meimeiyoupin.mvp.ui.adapter.JobFragmentListAdapter
import com.meimeiyoupin.mvp.ui.base.BaseSupportFragment
import com.meimeiyoupin.mvp.ui.holder.BannerImageHolder
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration

/**
 * Created by zhengjiong
 * date: 2018/4/15 11:30
 */

class JobFragment : BaseSupportFragment<IPresenter>() {
    @BindView(R.id.banner)
    lateinit var banner: ConvenientBanner<String>

    @BindView(R.id.recyclerView)
    lateinit var recyclerView: RecyclerView

    private val jobFragmentListAdapter: JobFragmentListAdapter by lazy {
        JobFragmentListAdapter()
    }

    companion object {
        @JvmStatic
        fun newInstance(): JobFragment {
            return JobFragment()
        }
    }

    override fun setupFragmentComponent(appComponent: AppComponent) {

    }

    override fun initData(savedInstanceState: Bundle?) {
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.addItemDecoration(
                HorizontalDividerItemDecoration.Builder(context)
                        .colorResId(R.color.color_f2f1ef)
                        .size(ConvertUtils.dp2px(8F))
                        .showLastDivider()
                        .build()
        )
        recyclerView.adapter = jobFragmentListAdapter

        testData()
    }

    private fun testData() {
        jobFragmentListAdapter.setNewData(listOf(
                Job("title", 12345, "年龄18岁以上龄18岁以上,年龄18岁以上龄18岁以上", "上海蓝鸽酒店管理公司"),
                Job("title", 12345, "年龄18岁以上龄18岁以上,年龄18岁以上龄18岁以上", "上海蓝鸽酒店管理公司"),
                Job("title", 12345, "年龄18岁以上龄18岁以上,年龄18岁以上龄18岁以上", "上海蓝鸽酒店管理公司"),
                Job("title", 12345, "年龄18岁以上龄18岁以上,年龄18岁以上龄18岁以上", "上海蓝鸽酒店管理公司"),
                Job("title", 12345, "年龄18岁以上龄18岁以上,年龄18岁以上龄18岁以上", "上海蓝鸽酒店管理公司"),
                Job("title", 12345, "年龄18岁以上龄18岁以上,年龄18岁以上龄18岁以上", "上海蓝鸽酒店管理公司"),
                Job("title", 12345, "年龄18岁以上龄18岁以上,年龄18岁以上龄18岁以上", "上海蓝鸽酒店管理公司"),
                Job("title", 12345, "年龄18岁以上龄18岁以上,年龄18岁以上龄18岁以上", "上海蓝鸽酒店管理公司"),
                Job("title", 12345, "年龄18岁以上龄18岁以上,年龄18岁以上龄18岁以上", "上海蓝鸽酒店管理公司"),
                Job("title", 12345, "年龄18岁以上龄18岁以上,年龄18岁以上龄18岁以上", "上海蓝鸽酒店管理公司"),
                Job("title", 12345, "年龄18岁以上龄18岁以上,年龄18岁以上龄18岁以上", "上海蓝鸽酒店管理公司"),
                Job("title", 12345, "年龄18岁以上龄18岁以上,年龄18岁以上龄18岁以上", "上海蓝鸽酒店管理公司"),
                Job("title", 12345, "年龄18岁以上龄18岁以上,年龄18岁以上龄18岁以上", "上海蓝鸽酒店管理公司"),
                Job("title", 12345, "年龄18岁以上龄18岁以上,年龄18岁以上龄18岁以上", "上海蓝鸽酒店管理公司"),
                Job("title", 12345, "年龄18岁以上龄18岁以上,年龄18岁以上龄18岁以上", "上海蓝鸽酒店管理公司")
        ))

        /**
         * mBannerView.setPages(
        () -> new ImageHolderView(mBannerView.getMeasuredHeight(), ScalingUtils.ScaleType.FIT_XY, getBaseActivity()), adList)
        .setPageIndicator(new int[]{R.drawable.ic_page_indicator_rect, R.drawable.ic_page_indicator_focus_rect})
        .setPointViewVisible(adList.size() > 1)
        .setCanLoop(adList.size() > 1);
        if (adList.size() > 1) {
        mBannerView.startTurning(3000);
        }
         */

        banner.setPages(object : CBViewHolderCreator<BannerImageHolder> {
            override fun createHolder(): BannerImageHolder {
                return BannerImageHolder(ConvertUtils.dp2px(180F))
            }

        }, mutableListOf("", "", "", "", "", ""))
                .setPageIndicator(intArrayOf(R.drawable.ic_page_card_indicator, R.drawable.ic_page_card_indicator_selected))
                .setPointViewVisible(true).isCanLoop = true
    }

    override fun initView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.module_fragment_job, container, false)
    }

    override fun setData(data: Any?) {

    }
}
