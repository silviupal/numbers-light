package com.numberslight.main

import com.numberslight.App
import com.numberslight.R
import com.numberslight.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Silviu Pal on 18/02/2019.
 */
class MainPresenter : BasePresenter<MainContract.View>(), MainContract.Presenter {
    init {
        App.instance.apiComponent.inject(this)
    }

    override fun getData() {
        api.getData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ list ->
                list?.let {
                    view?.updateList(it)
                } ?: view?.showError(R.string.error_data_null)
            }, {
                view?.showError(R.string.error_loading_data)
            })
    }
}