package com.tuo.kotlintuo

import android.os.Bundle
import android.util.Log
import com.tuo.mvp.impl.MVPActivity
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton


class MainActivity : MVPActivity<MainPresenter>(), MainContract.View {

    override val kodein: Kodein = Kodein.lazy {
        bind<MainContract.View>() with singleton { this@MainActivity }
    }

    override val layoutId = R.layout.activity_main

    override val presenter by instance<MainPresenter>()

    override fun initActivity(savedInstanceState: Bundle?) {
        presenter.test()
    }

    override fun mainTest() {
        Log.i("mainTest", "成功")
    }

}
