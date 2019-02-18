package com.numberslight.main

import com.numberslight.App
import com.numberslight.base.BasePresenter
import javax.inject.Inject

/**
 * Created by Silviu Pal on 18/02/2019.
 */
class MainPresenter: BasePresenter<MainContract.View>(), MainContract.Presenter {
    init {
        App.instance.apiComponent.inject(this)
    }
}