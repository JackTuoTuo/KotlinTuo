package com.tuo.kotlintuo

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.squareup.leakcanary.LeakCanary
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * <pre>
 *     author : Tuo
 *     e-mail : 839539179@qq.com
 *     time   : 2019/1/15 17:50
 *     desc   :
 *     version: 1.0
 * </pre>
 */


class App : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> = dispatchingAndroidInjector

    override fun onCreate() {

        DaggerMyAppComponent.create().inject(this)

        super.onCreate()

        registerActivityLifecycleCallbacks(mActivityLifecycleCallbacks)

        // 内存检测
        initLeakCanary()
        // 日志打印
        Logger.addLogAdapter(AndroidLogAdapter())
    }

    private fun initLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return
        }
        LeakCanary.install(this)
    }

    private var mActivityCount = 0

    private val mActivityLifecycleCallbacks = object : Application.ActivityLifecycleCallbacks {

        override fun onActivityPaused(activity: Activity?) {

        }

        override fun onActivityResumed(activity: Activity?) {

        }

        override fun onActivityStarted(activity: Activity?) {
            mActivityCount++
        }

        override fun onActivityDestroyed(activity: Activity) {
            Logger.d("onDestroyed: " + activity.componentName.className)

        }

        override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {

        }

        override fun onActivityStopped(activity: Activity?) {
            mActivityCount--
        }

        override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
            Logger.d("onCreated: " + activity.componentName.className)
        }

    }


    // 应用是否处于前台
    public fun isForeground() = mActivityCount != 0

}

