package indi.wkq.superseatandroid

import android.app.Application
import androidx.multidex.MultiDex
import com.xuexiang.xui.XUI
import indi.wkq.superseatandroid.utils.sdkInit.BaseLibInit

/**
 * @author  calesq
 * @date    2021/4/24
 */
class SSApp : Application() {
    override fun onCreate() {
        super.onCreate()
        BaseLibInit.init(this)
        XUI.init(this)
        XUI.debug(true)
        // 初始化MultiDex
        MultiDex.install(this);
    }
}