package com.tuo.mvp

import android.os.Bundle
import com.tuo.common.base.BaseActivity
import kotlin.reflect.KClass
import kotlin.reflect.full.isSubclassOf
import kotlin.reflect.full.primaryConstructor
import kotlin.reflect.jvm.jvmErasure

/**
 * <pre>
 *     author : Tuo
 *     e-mail : 839539179@qq.com
 *     time   : 2018/7/6 14:20
 *     desc   : BaseActivity
 *     version: 1.0
 * </pre>
 */
abstract class MVPActivity<out P : BasePresenter<MVPActivity<P>>> : BaseActivity(), IMvpView<P> {

    abstract override val presenter: P

    init {
        presenter.view = this
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.onCreate(savedInstanceState)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {}

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

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        presenter.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        onViewStateRestored(savedInstanceState)
        presenter.onViewStateRestored(savedInstanceState)
    }


    private fun createPresenterKt(): P {
        sequence {
            var thisClass: KClass<*> = this@MVPActivity::class
            while (true) {
                yield(thisClass.supertypes)
                thisClass = thisClass.supertypes.firstOrNull()?.jvmErasure ?: break
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