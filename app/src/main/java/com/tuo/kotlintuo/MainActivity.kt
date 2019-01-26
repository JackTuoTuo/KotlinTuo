package com.tuo.kotlintuo

import android.os.Bundle
import android.util.Log
import com.tuo.mvp.impl.MVPActivity
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton


class MainActivity : MVPActivity<MainPresenter>(), MainContract.View {

    override val presenter = MainPresenter(this)

    override val layoutId = R.layout.activity_main

    override fun initActivity(savedInstanceState: Bundle?) {
        presenter.test()
    }

    override fun mainTest() {
        Log.i("mainTest", "成功")
    }

}
