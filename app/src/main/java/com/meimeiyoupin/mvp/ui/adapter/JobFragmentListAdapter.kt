package com.meimeiyoupin.mvp.ui.adapter

import android.support.annotation.LayoutRes
import com.chad.library.adapter.base.BaseQuickAdapter
import com.meimeiyoupin.R
import com.meimeiyoupin.mvp.model.entity.Job
import com.meimeiyoupin.mvp.ui.holder.JobViewHolder

/**
 *
 * Copyright:Copyright(c) 2018
 * CreateTime:18/4/24$  17:41$
 * @author 郑炯
 * @version 1.0
 */
class JobFragmentListAdapter(@LayoutRes resId: Int = R.layout.module_fragment_job_item) : BaseQuickAdapter<Job, JobViewHolder>(resId) {

    override fun convert(helper: JobViewHolder?, item: Job?) {
        println("convert " + helper!!.adapterPosition)
    }
}