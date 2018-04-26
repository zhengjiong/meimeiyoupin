package com.meimeiyoupin.mvp.ui.fragment

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.annotation.IdRes
import android.support.design.widget.AppBarLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.*
import android.widget.ListView
import android.widget.PopupWindow
import butterknife.BindView
import com.bigkoo.convenientbanner.ConvenientBanner
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator
import com.blankj.utilcode.util.BarUtils
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

    @BindView(R.id.appbar)
    lateinit var appbar: AppBarLayout

    @BindView(R.id.filter_container)
    lateinit var filterContainer: View

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

    var verticalOffset: Int = 0

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
        appbar.addOnOffsetChangedListener(object : AppBarLayout.OnOffsetChangedListener {
            override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {
                this@JobFragment.verticalOffset = verticalOffset
            }
        })
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
        showPopWindow(view.id)
        //loadRootFragment(R.id.rl_frame_holder, DialogItemListFragment.newInstance(arrayListOf("a","a","a","a","a","a","a","a","a")))
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

        banner.setPages(object : CBViewHolderCreator<BannerImageHolder> {
            override fun createHolder(): BannerImageHolder {
                return BannerImageHolder(ConvertUtils.dp2px(180F))
            }

        }, mutableListOf("", "", "", "", "", ""))
                .setPageIndicator(intArrayOf(R.drawable.ic_page_card_indicator, R.drawable.ic_page_card_indicator_selected))
                .setPointViewVisible(true).isCanLoop = true
        banner.startTurning(3000)
    }

    fun showPopWindow(@IdRes resId: Int) {
        when (resId) {
            R.id.icon_city -> {

            }
            R.id.icon_type -> {

            }
            R.id.icon_profession -> {

            }
        }
        val listView = ListView(context)
        val height = view!!.height - ConvertUtils.dp2px(48F) - (banner.height - Math.abs(verticalOffset))
        listView.layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        height
                ))
        listView.cacheColorHint = resources.getColor(android.R.color.transparent)
        listView.adapter = DialogItemListFragment.DialogItemListAdapter(arrayListOf("a", "a", "a"))
        listView.divider = resources.getDrawable(R.drawable.shape_divider_efefef_2px)
        listView.setBackgroundColor(resources.getColor(R.color.color_50000000))
        val popupWindow = PopupWindow(listView, recyclerView.width,
                height,
                true)
        popupWindow.animationStyle = 0
        popupWindow.isOutsideTouchable = true
        //popupWindow.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.color_50000000)))
        popupWindow.setOnDismissListener {
            iconCity.animate().rotation(0F).setDuration(300).start()
            iconType.animate().rotation(0F).setDuration(300).start()
            iconProfession.animate().rotation(0F).setDuration(300).start()
        }
        popupWindow.setTouchInterceptor(View.OnTouchListener { v, event ->
            if (MotionEvent.ACTION_UP == event!!.action) {
                if (event.y > listView.adapter.count * ConvertUtils.dp2px(48F)) {
                    popupWindow.dismiss()
                    return@OnTouchListener true
                }
            }

            false
        })

        listView.setOnItemClickListener { parent, view, position, id ->
            popupWindow.dismiss()
        }
        popupWindow.showAsDropDown(filterContainer, 0, 0, Gravity.TOP)
    }

    override fun initView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.module_fragment_job, container, false)
    }

    override fun setData(data: Any?) {

    }
}
