package com.tuo.kotlintuo

import android.os.Bundle
import com.tuo.mvp.MVPActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : MVPActivity<MainPresenter>() {


    override val layoutId = R.layout.activity_main

    override val presenter: MainPresenter = MainPresenter(this)


    override fun initActivity(savedInstanceState: Bundle?) {

        textView.setOnClickListener{
          presenter.test()
        }
    }


}
