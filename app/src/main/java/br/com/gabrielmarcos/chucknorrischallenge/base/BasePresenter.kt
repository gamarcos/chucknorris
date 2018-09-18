package br.com.gabrielmarcos.chucknorrischallenge.base

import br.com.gabrielmarcos.chucknorrischallenge.injection.component.DaggerPresenterInjector
import br.com.gabrielmarcos.chucknorrischallenge.injection.component.PresenterInjector
import br.com.gabrielmarcos.chucknorrischallenge.injection.modules.ContextModule
import br.com.gabrielmarcos.chucknorrischallenge.injection.modules.NetworkModule
import br.com.gabrielmarcos.chucknorrischallenge.ui.category.ChuckCategoriesPresenter
import br.com.gabrielmarcos.chucknorrischallenge.ui.detail.ChuckDetailPresenter

/**
 * Created by Gabriel Marcos on 16/09/2018
 */
abstract class BasePresenter<out C : BaseContract>(protected val contract: C) {
    private val injector: PresenterInjector? = DaggerPresenterInjector
            .builder()
            .baseContract(contract)
            .contextModule(ContextModule)
            .networkModule(NetworkModule)
            .build()

    init {
        inject()
    }
    open fun onViewCreated(){}

    open fun onViewDestroyed(){}

    private fun inject() {
        when(this) {
            is ChuckCategoriesPresenter -> injector?.inject(this)
            is ChuckDetailPresenter -> injector?.inject(this)
        }
    }
}