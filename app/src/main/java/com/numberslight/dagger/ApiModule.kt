package com.numberslight.dagger

import com.numberslight.networking.Api
import dagger.Module
import dagger.Provides

/**
 * Created by Silviu Pal on 18/02/2019.
 */
@Module
class ApiModule {
    @Provides
    fun provideApi(): Api = Api.create()
}