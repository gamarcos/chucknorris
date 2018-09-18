package br.com.gabrielmarcos.chucknorrischallenge.injection.component

import br.com.gabrielmarcos.chucknorrischallenge.base.BaseContract
import br.com.gabrielmarcos.chucknorrischallenge.injection.modules.ContextModule
import br.com.gabrielmarcos.chucknorrischallenge.injection.modules.NetworkModule
import br.com.gabrielmarcos.chucknorrischallenge.ui.category.ChuckCategoriesPresenter
import br.com.gabrielmarcos.chucknorrischallenge.ui.detail.ChuckDetailPresenter
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Gabriel Marcos on 16/09/2018
 */

@Singleton
@Component(modules = [(ContextModule::class), (NetworkModule::class)])
interface PresenterInjector {
    fun inject(chuckPresenter: ChuckCategoriesPresenter)
    fun inject(chuckDetailPresenter: ChuckDetailPresenter)

    @Component.Builder
    interface Builder {
        fun build(): PresenterInjector

        fun networkModule(networkModule: NetworkModule): Builder
        fun contextModule(contextModule: ContextModule): Builder

        @BindsInstance
        fun baseContract(baseContract: BaseContract): Builder
    }
}
