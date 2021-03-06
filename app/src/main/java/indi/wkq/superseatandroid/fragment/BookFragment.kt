package indi.wkq.superseatandroid.fragment

import android.widget.FrameLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.kunminx.linkage.bean.DefaultGroupedItem
import com.xuexiang.xpage.annotation.Page
import com.xuexiang.xpage.base.XPageFragment
import com.xuexiang.xpage.enums.CoreAnim
import com.xuexiang.xpage.utils.TitleBar
import com.xuexiang.xui.utils.ResUtils
import indi.wkq.superseatandroid.R
import indi.wkq.superseatandroid.adapter.LibraryRecyclerViewAdapter
import indi.wkq.superseatandroid.constant.LibraryConst
import java.util.*
import kotlin.collections.ArrayList

/**
 * @author  calesq
 * @date    2021/4/25
 */
@Page(name = "座位预约", anim = CoreAnim.none)
class BookFragment : XPageFragment() {
    override fun initListeners() {
    }

    private val mPagerWrap : FrameLayout by lazy {
        findViewById<FrameLayout>(R.id.libraryWrap)
    }

    override fun initViews() {
        var mPagerLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        mRecycleView?.layoutManager = mPagerLayoutManager
        mRecycleView?.adapter = LibraryRecyclerViewAdapter(this, ResUtils.getStringArray(R.array.pages).asList(), initData(LibraryConst.LIBRARIES))
        mPagerWrap.addView(mRecycleView)
        PagerSnapHelper().apply {
            attachToRecyclerView((mRecycleView))
        }
    }

    private fun initData(headers : Map<String, MutableMap<String, String>>) : List<DefaultGroupedItem> {
        val items: MutableList<DefaultGroupedItem> = ArrayList()
        val k = headers.keys.toList()
        for (i in k) {
            items.add(DefaultGroupedItem(true, i))
            val itemsLibrary = headers[i]!!
            val roomsName = itemsLibrary.keys.toList()
            val roomsCode = itemsLibrary.values.toList()

            for (j in roomsName) {
                items.add(DefaultGroupedItem(DefaultGroupedItem.ItemInfo(j, i)))
            }
        }

        return items
    }

    private val mRecycleView by lazy {
        context?.let { RecyclerView(it) }
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_book
    }

    override fun initTitleBar(): TitleBar {
        var titleBar = super.initTitleBar()
        titleBar.setLeftImageDrawable(null)
        return titleBar
    }

}