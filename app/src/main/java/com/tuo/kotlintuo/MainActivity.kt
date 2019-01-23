package com.tuo.kotlintuo

import android.os.Bundle
import android.util.Log
import com.tuo.mvp.impl.MVPActivity

class MainActivity : MVPActivity<MainPresenter>() {

    override val layoutId = R.layout.activity_main

    override val presenter by lazy {
        MainPresenter(this)
    }

    override fun initActivity(savedInstanceState: Bundle?) {
        presenter.test()
    }

    fun mainTest() {
        Log.i("mainTest", "成功")
    }

}
