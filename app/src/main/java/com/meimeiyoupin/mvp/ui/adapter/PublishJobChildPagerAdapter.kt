package com.meimeiyoupin.mvp.ui.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.meimeiyoupin.mvp.ui.fragment.PublishJobChildFragment
import java.lang.IllegalArgumentException

/**
 *
 * Copyright:Copyright(c) 2018
 * CreateTime:18/4/28$  15:17$
 * @author 郑炯
 * @version 1.0
 */


class PublishJobChildPagerAdapter(private val titles: Array<String>, fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                PublishJobChildFragment.newInstance()
            }
            1 -> {
                PublishJobChildFragment.newInstance()
            }
            else -> {
                throw IllegalArgumentException()
            }
        }
    }

    override fun getCount(): Int {
        return titles.size
    }


    override fun getPageTitle(position: Int): CharSequence? {
        return titles[position]
    }
}