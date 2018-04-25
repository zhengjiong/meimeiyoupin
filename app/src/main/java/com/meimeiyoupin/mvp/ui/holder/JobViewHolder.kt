package com.meimeiyoupin.mvp.ui.holder

import android.view.View
import android.widget.TextView
import com.chad.library.adapter.base.BaseViewHolder
import com.meimeiyoupin.R

/**
 *
 * Copyright:Copyright(c) 2018
 * CreateTime:18/4/24$  17:46$
 * @author 郑炯
 * @version 1.0
 */

class JobViewHolder(val view: View) : BaseViewHolder(view) {
    val tvTitle = view.findViewById<TextView>(R.id.tv_title)
    val tvPrice = view.findViewById<TextView>(R.id.tv_price)
    val tvDescription = view.findViewById<TextView>(R.id.tv_description)
    val tvCompanyName = view.findViewById<TextView>(R.id.tv_company)
}
 