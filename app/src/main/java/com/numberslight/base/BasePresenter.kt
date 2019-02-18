package com.numberslight.base

import com.numberslight.App
import com.numberslight.networking.Api
import javax.inject.Inject

/**
 * Created by Silviu Pal on 18/02/2019.
 */
open class BasePresenter<T>: IBasePresenter<T> {
    @Inject
    lateinit var api: Api

    protected var view: T?  = null

    override fun attachPresenter(view: T) {
        this.view = view
    }

    override fun isAttached(): Boolean = view != null

    override fun detachPresenter() {
        view = null
    }
}