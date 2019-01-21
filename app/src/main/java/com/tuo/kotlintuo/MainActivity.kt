package com.tuo.kotlintuo

import android.os.Bundle
import com.orhanobut.logger.Logger
import com.tuo.dagger2forandroid.Chef
import javax.inject.Inject

class MainActivity : MVPActivity() {


    @Inject
    lateinit var chef: Chef

    @Inject
    lateinit var menu: Menu

    override fun getLayoutId() = R.layout.activity_main

    override fun initActivity(savedInstanceState: Bundle?) {

        Logger.d( menu.toString() + chef.cook())

    }


}
