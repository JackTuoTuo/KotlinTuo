package com.tuo.kotlintuo

import android.os.Bundle
import android.util.Log
import com.tuo.mvp.impl.MVPActivity
import javax.inject.Inject


class MainActivity : MVPActivity<MainPresenter>(), MainContract.View {

    @Inject
    lateinit var chef: Chef

    @Inject
    lateinit var menu: Menu

    override val presenter = MainPresenter(this)

    override val layoutId = R.layout.activity_main

    override fun initActivity(savedInstanceState: Bundle?) {
        presenter.test()
    }

    override fun mainTest() {

        Log.i("mainTest", chef.cook()+" "+menu.toString())
    }

}
