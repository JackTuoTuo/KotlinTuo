package com.tuo.kotlintuo

import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * <pre>
 *     author : Tuo
 *     e-mail : 839539179@qq.com
 *     time   : 2019/1/18 11:40
 *     desc   :
 *     version: 1.0
 * </pre>
 */
@Module(subcomponents = [BaseActivityComponent::class])
abstract class AllActivityModule {

    @ContributesAndroidInjector(modules = [DataModule::class])
    abstract fun inject(): MainActivity
}