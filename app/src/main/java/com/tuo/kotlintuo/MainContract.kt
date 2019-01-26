package com.tuo.kotlintuo

import com.tuo.mvp.impl.BaseView

/**
 * <pre>
 *     author : Tuo
 *     e-mail : 839539179@qq.com
 *     time   : 2019/1/24 10:18
 *     desc   :
 *     version: 1.0
 * </pre>
 */
interface MainContract {

    interface View : BaseView {
        fun mainTest()
    }

    interface Presenter {
        fun test()
    }

}