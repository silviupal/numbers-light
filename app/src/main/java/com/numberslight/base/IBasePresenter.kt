package com.numberslight.base

/**
 * Created by Silviu Pal on 18/02/2019.
 */
interface IBasePresenter<in T> {
    fun attachPresenter(view: T)

    fun isAttached(): Boolean

    fun detachPresenter()
}