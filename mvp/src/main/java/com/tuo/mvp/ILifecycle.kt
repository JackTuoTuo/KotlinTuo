package com.tuo.mvp

import android.content.res.Configuration
import android.os.Bundle

/**
 * <pre>
 *     author : Tuo
 *     e-mail : 839539179@qq.com
 *     time   : 2018/7/4
 *     desc   : 生命周期
 *     version: 1.0
 * </pre>
 */
interface ILifecycle {

    fun onCreate(savedInstanceState: Bundle?)

    fun onStart()

    fun onSaveInstanceState(outState: Bundle)

    fun onViewStateRestored(savedInstanceState: Bundle?)

    fun onConfigurationChanged(newConfig: Configuration)

    fun onResume()

    fun onPause()

    fun onStop()

    fun onDestroy()
}