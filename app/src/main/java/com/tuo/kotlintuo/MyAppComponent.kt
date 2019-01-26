package com.tuo.kotlintuo

import dagger.Component
import dagger.android.AndroidInjectionModule

/**
 * <pre>
 *     author : Tuo
 *     e-mail : 839539179@qq.com
 *     time   : 2019/1/18 11:21
 *     desc   :
 *     version: 1.0
 * </pre>
 */

@Component(modules = [AndroidInjectionModule::class,AllActivityModule::class])
interface MyAppComponent {

    fun inject(myApplication: App)
}