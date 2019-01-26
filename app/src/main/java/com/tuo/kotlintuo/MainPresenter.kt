package com.tuo.kotlintuo

import com.tuo.mvp.impl.BasePresenter
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

/**
 * <pre>
 *     author : Tuo
 *     e-mail : 839539179@qq.com
 *     time   : 2019/1/22 17:34
 *     desc   :
 *     version: 1.0
 * </pre>
 */

class MainPresenter()
    : BasePresenter<MainActivity>(), MainContract.Presenter, KodeinAware {

    private val view: MainActivity by instance()

    override val kodein: Kodein = Kodein.lazy {
        bind<BasePresenter<MainActivity>>() with singleton { this@MainPresenter }
    }


    override fun test() {
        view.mainTest()
    }
}
