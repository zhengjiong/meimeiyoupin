package com.zj.bilibili.app

import android.content.Context
import android.support.multidex.MultiDex
import com.bilibili.boxing.BoxingMediaLoader
import com.bilibili.boxing.loader.IBoxingMediaLoader
import com.blankj.utilcode.util.Utils
import com.jess.arms.base.BaseApplication
import com.meimeiyoupin.app.BoxingGlideLoader

/**
 *
 * Copyright:Copyright(c) 2018
 * CreateTime:18/1/30$  16:14$
 * @author 郑炯
 * @version 1.0
 */
class App : BaseApplication() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(base)
        Utils.init(this);
        BoxingMediaLoader.getInstance().init(BoxingGlideLoader());
    }
}