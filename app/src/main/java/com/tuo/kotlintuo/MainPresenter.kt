package com.tuo.kotlintuo

import com.tuo.mvp.impl.BasePresenter

/**
 * <pre>
 *     author : Tuo
 *     e-mail : 839539179@qq.com
 *     time   : 2019/1/22 17:34
 *     desc   :
 *     version: 1.0
 * </pre>
 */


class MainPresenter (override val view:MainActivity):BasePresenter<MainActivity>(){
    fun test() {
        view.mainTest()
    }
}
