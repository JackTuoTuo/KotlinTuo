package com.tuo.mvp

/**
 * <pre>
 *     author : Tuo
 *     e-mail : 839539179@qq.com
 *     time   : 2018/7/4
 *     desc   : mvp
 *     version: 1.0
 * </pre>
 */


interface IPresenter<out View: IMvpView<IPresenter<View>>>: ILifecycle {

    val view:View
}

interface IMvpView<out Presenter: IPresenter<IMvpView<Presenter>>>: ILifecycle {

    val presenter:Presenter

}