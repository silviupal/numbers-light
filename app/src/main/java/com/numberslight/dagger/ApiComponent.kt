package com.numberslight.dagger

import com.numberslight.detail.DetailPagePresenter
import com.numberslight.main.MainActivity
import com.numberslight.main.MainPresenter
import dagger.Component

/**
 * Created by Silviu Pal on 18/02/2019.
 */
@Component(modules = [ApiModule::class])
interface ApiComponent {
    fun inject(mainPresenter: MainPresenter)

    fun inject(detailPagePresenter: DetailPagePresenter)

    fun inject(mainActivity: MainActivity)
}