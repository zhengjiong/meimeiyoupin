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
import com.jakewharton.rxbinding2.view.RxView
import com.jess.arms.di.component.AppComponent
import com.jess.arms.mvp.IPresenter
import com.meimeiyoupin.R
import com.meimeiyoupin.mvp.model.entity.Job
import com.meimeiyoupin.mvp.ui.adapter.JobFragmentListAdapter
import com.meimeiyoupin.mvp.ui.base.BaseSupportFragment
import com.meimeiyoupin.mvp.ui.holder.BannerImageHolder
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration
import io.reactivex.functions.Consumer
import java.util.concurrent.TimeUnit

/**
 * Created by zhengjiong
 * date: 2018/4/15 11:30
 */

class JobFragment : BaseSupportFragment<IPresenter>() {
    @BindView(R.id.banner)
    lateinit var banner: ConvenientBanner<String>

    @BindView(R.id.recyclerView)
    lateinit var recyclerView: RecyclerView

    @BindView(R.id.city_container)
    lateinit var cityContainer: View

    @BindView(R.id.type_container)
    lateinit var typeContainer: View

    @BindView(R.id.profession_container)
    lateinit var professionContainer: View

    @BindView(R.id.icon_city)
    lateinit var iconCity: View

    @BindView(R.id.icon_type)
    lateinit var iconType: View

    @BindView(R.id.icon_profession)
    lateinit var iconProfession: View

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

        initListener()

        testData()
    }

    private fun initListener() {
        RxView.clicks(cityContainer).throttleFirst(500, TimeUnit.MILLISECONDS)
                .subscribe(object : Consumer<Any> {
                    override fun accept(t: Any?) {
                        rotateArrow(iconCity)
                    }

                }, Consumer<Throwable> { })
        RxView.clicks(typeContainer).throttleFirst(500, TimeUnit.MILLISECONDS)
                .subscribe(Consumer<Any> { rotateArrow(iconType) }, Consumer<Throwable> { })

        RxView.clicks(professionContainer).throttleFirst(500, TimeUnit.MILLISECONDS)
                .subscribe({ t ->
                    rotateArrow(iconProfession)
                }) { }
    }

    private fun rotateArrow(view: View) {
        if (view.rotation == 0F) {
            view.animate().rotation(180F).setDuration(300).start()
        } else {
            view.animate().rotation(0F).setDuration(300).start()
        }
        when (view) {
            iconCity -> {
                iconType.animate().rotation(0F).setDuration(300).start()
                iconProfession.animate().rotation(0F).setDuration(300).start()
            }
            iconType -> {
                iconCity.animate().rotation(0F).setDuration(300).start()
                iconProfession.animate().rotation(0F).setDuration(300).start()
            }
            iconProfession -> {
                iconCity.animate().rotation(0F).setDuration(300).start()
                iconType.animate().rotation(0F).setDuration(300).start()
            }
        }

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
        banner.startTurning(3000)
    }

    override fun initView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.module_fragment_job, container, false)
    }

    override fun setData(data: Any?) {

    }
}
