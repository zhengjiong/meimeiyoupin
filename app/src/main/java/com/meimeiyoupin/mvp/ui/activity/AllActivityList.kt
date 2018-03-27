package com.meimeiyoupin.mvp.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.meimeiyoupin.R
import com.meimeiyoupin.app.ARouterPath
import com.meimeiyoupin.mvp.model.entity.ActivityName
import kotlinx.android.synthetic.main.module_activity_all.*

/**
 *
 * Copyright:Copyright(c) 2018
 * Company: 上加下信息技术成都有限公司
 * CreateTime:18/3/26$  22:26$
 * @author 郑炯
 * @version 1.0
 */
@Route(path = "/app/all")
class AllActivityList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.module_activity_all)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = Adapter(listOf(
                ActivityName("启动页", ARouterPath.LAUNCHER),
                ActivityName("登录页", ARouterPath.LOGIN),
                ActivityName("上传照片", ARouterPath.UPLOAD_PICTURE),
                ActivityName("资料填写", ARouterPath.INFORMATION_WRITE)
        ))

    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle: TextView = itemView.findViewById(R.id.tv_title)
    }

    class Adapter(val data: List<ActivityName>) : RecyclerView.Adapter<ListViewHolder>() {
        override fun onBindViewHolder(holder: ListViewHolder?, position: Int) {
            holder!!.tvTitle.text = data[position].name
            (holder.tvTitle.parent as View).setOnClickListener {
                ARouter.getInstance().build(data[position].path).navigation(holder.itemView.context)
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ListViewHolder {
            return ListViewHolder(LayoutInflater.from(parent!!.context).inflate(R.layout.module_all_item, parent, false))
        }

        override fun getItemCount(): Int {
            return data.size
        }

    }
}