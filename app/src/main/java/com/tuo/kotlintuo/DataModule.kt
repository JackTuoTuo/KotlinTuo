package com.tuo.kotlintuo


import dagger.Module
import dagger.Provides

/**
 * <pre>
 *     author : Tuo
 *     e-mail : 839539179@qq.com
 *     time   : 2019/1/18 11:51
 *     desc   :
 *     version: 1.0
 * </pre>
 */
@Module
class DataModule {

    @Provides
    fun provideChef() = Chef()

    @Provides
    fun provideMenu() = Menu()
}