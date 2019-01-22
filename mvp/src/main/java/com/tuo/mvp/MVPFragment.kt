package com.tuo.mvp


import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment

import kotlin.reflect.KClass
import kotlin.reflect.full.isSubclassOf
import kotlin.reflect.full.primaryConstructor
import kotlin.reflect.jvm.jvmErasure

/**
 * <pre>
 *     author : Tuo
 *     e-mail : 839539179@qq.com
 *     time   : 2018/7/5
 *     desc   :
 *     version: 1.0
 * </pre>
 */
abstract class MVPFragment<out P : BasePresenter<MVPFragment<P>>> : Fragment(), IMvpView<P> {

    abstract override val presenter: P

    init {
        this.presenter.view = this
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        presenter.onSaveInstanceState(outState)
    }


    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        presenter.onViewStateRestored(savedInstanceState)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        presenter.onStart()
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }


    override fun onPause() {
        super.onPause()
        presenter.onPause()
    }


    override fun onStop() {
        super.onStop()
        presenter.onStop()
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()

    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        presenter.onConfigurationChanged(newConfig)
    }

    private fun createPresenter(): P {

        sequence {
            var thisClass: KClass<*> = this@MVPFragment::class
            while (true) {
                yield(thisClass.supertypes)
                thisClass = thisClass.supertypes
                        .firstOrNull()?.jvmErasure ?: break
            }
        }.flatMap {
            it.flatMap { it.arguments }.asSequence()
        }.first {
            it.type?.jvmErasure?.isSubclassOf(IPresenter::class) ?: false
        }.let {
            return it.type!!.jvmErasure.primaryConstructor!!.call() as P
        }
    }


}
