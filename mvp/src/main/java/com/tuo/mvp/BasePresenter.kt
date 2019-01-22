package com.tuo.mvp

import android.content.res.Configuration
import android.os.Bundle

/**
 * <pre>
 *     author : Tuo
 *     e-mail : 839539179@qq.com
 *     time   : 2018/7/5
 *     desc   : BasePresenter
 *     version: 1.0
 * </pre>
 */
abstract class BasePresenter<out V : IMvpView<BasePresenter<V>>> : IPresenter<V> {

    override lateinit var view: @UnsafeVariance V

    override fun onCreate(savedInstanceSate: Bundle?) = Unit

    override fun onSaveInstanceState(outState: Bundle) = Unit

    override fun onViewStateRestored(savedInstanceSate: Bundle?) = Unit

    override fun onConfigurationChanged(newConfig: Configuration) = Unit

    override fun onStart() = Unit

    override fun onResume() = Unit

    override fun onPause() = Unit

    override fun onStop() = Unit

    override fun onDestroy() = Unit
}