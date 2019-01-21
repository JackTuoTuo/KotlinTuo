package com.tuo.dagger2forandroid

/**
 * <pre>
 *     author : Tuo
 *     e-mail : 839539179@qq.com
 *     time   : 2019/1/16 15:04
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class Chef : Cooking {


    override fun cook(): String {
        val menuList = HashMap<String, Boolean>()
        menuList["白菜"] = true
        menuList["萝卜"] = false

        val stringBuilder = StringBuilder()

        menuList.forEach { if (it.value) stringBuilder.append(it.key).append(",") }

        return stringBuilder.toString()
    }
}