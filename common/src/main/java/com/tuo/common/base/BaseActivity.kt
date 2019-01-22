package com.tuo.common.base

import android.content.Context
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity

/**
 * <pre>
 *     author : Tuo
 *     e-mail : 839539179@qq.com
 *     time   : 2019/1/15 15:04
 *     desc   :
 *     version: 1.0
 * </pre>
 */

abstract class BaseActivity : AppCompatActivity() {

    protected abstract val layoutId: Int

    protected lateinit var mContext: Context


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.mContext = this
        initWindow()
        setContentView(layoutId)
        initActivity(savedInstanceState)
    }

    private fun initWindow() {
        // 默认输入法隐藏，并且适应布局
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
                or WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
    }

    abstract fun initActivity(savedInstanceState: Bundle?)



}