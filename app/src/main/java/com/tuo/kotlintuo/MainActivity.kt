package com.tuo.kotlintuo

import android.os.Bundle
import android.util.Log
import com.tuo.mvp.impl.MVPActivity
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware

class MainActivity : MVPActivity<MainPresenter>(),KodeinAware {


    override val kodein: Kodein= Kodein.lazy {

    }

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
