package com.tuo.kotlintuo

import dagger.Subcomponent
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

/**
 * <pre>
 *     author : Tuo
 *     e-mail : 839539179@qq.com
 *     time   : 2019/1/18 11:42
 *     desc   :
 *     version: 1.0
 * </pre>
 */
@Subcomponent(modules = [AndroidInjectionModule::class])
interface BaseActivityComponent : AndroidInjector<MVPActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MVPActivity>()

}