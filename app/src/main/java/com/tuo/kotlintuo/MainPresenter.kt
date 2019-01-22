package com.tuo.kotlintuo

import android.util.Log
import com.tuo.mvp.BasePresenter
import com.tuo.mvp.MVPActivity

/**
 * <pre>
 *     author : Tuo
 *     e-mail : 839539179@qq.com
 *     time   : 2019/1/22 17:34
 *     desc   :
 *     version: 1.0
 * </pre>
 */

class MainPresenter(view: MainActivity) : BasePresenter<MVPActivity<MainPresenter>>() {


    fun test() {
        Log.i("test", "成功")
    }

}