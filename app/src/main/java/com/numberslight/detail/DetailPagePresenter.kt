package com.numberslight.detail

import com.numberslight.App
import com.numberslight.R
import com.numberslight.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Silviu Pal on 18/02/2019.
 */
class DetailPagePresenter : BasePresenter<DetailPageContract.View>(), DetailPageContract.Presenter {
    init {
        App.instance.apiComponent.inject(this)
    }

    override fun getData(name: String) {
        api.getDetailData(name)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ item ->
                item?.let {
                    view?.updateUI(it)
                } ?: view?.showError(R.string.error_data_null)
            }, {
                view?.showError(R.string.error_loading_data)
            })
    }
}