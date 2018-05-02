package com.meimeiyoupin.mvp.ui.holder

import android.view.View
import android.widget.TextView
import com.chad.library.adapter.base.BaseViewHolder
import com.meimeiyoupin.R

/**
 *
 * Copyright:Copyright(c) 2018
 * CreateTime:18/4/28$  18:08$
 * @author 郑炯
 * @version 1.0
 */

class PublishJobFlexItemViewHolder(view: View) : BaseViewHolder(view) {
    val tvTitle:TextView = view.findViewById(R.id.tv_title)
}