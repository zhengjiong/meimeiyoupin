package com.meimeiyoupin.mvp.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.meimeiyoupin.R
import com.meimeiyoupin.app.ARouterPath

/**
 * Copyright:Copyright(c) 2018
 * CreateTime:18/3/4$  15:44$
 * @author 郑炯
 * @version 1.0
 */
@Route(path = ARouterPath.MAIN_PAGE)
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.module_activity_main)
    }
}
