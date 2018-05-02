package com.meimeiyoupin.mvp.ui.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.meimeiyoupin.R
import com.meimeiyoupin.mvp.ui.holder.PublishJobFlexItemViewHolder

/**
 *
 * Copyright:Copyright(c) 2018
 * CreateTime:18/4/28$  18:06$
 * @author 郑炯
 * @version 1.0
 */

class PublishJobFlexItemAdapter : BaseQuickAdapter<String, PublishJobFlexItemViewHolder>(R.layout.module_adapter_job_flex) {

    override fun convert(helper: PublishJobFlexItemViewHolder?, item: String?) {
        helper?.tvTitle?.text = item
    }

}