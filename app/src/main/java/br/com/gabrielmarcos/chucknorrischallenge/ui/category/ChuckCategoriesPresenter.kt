package br.com.gabrielmarcos.chucknorrischallenge.ui.category

import br.com.gabrielmarcos.chucknorrischallenge.base.BasePresenter
import br.com.gabrielmarcos.chucknorrischallenge.network.ChuckNorrisApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Gabriel Marcos on 16/09/2018
 */
class ChuckCategoriesPresenter(categoriesContract: ChuckCategoriesContract):
        BasePresenter<ChuckCategoriesContract>(categoriesContract) {

    @Inject
    lateinit var chuckCatergoriesApi: ChuckNorrisApi

    private var subscription: Disposable? = null

    override fun onViewCreated() {
        showCategories()
    }

    fun showCategories() {
        contract.showLoading()
        subscription = chuckCatergoriesApi
                .getCategories()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnTerminate { contract.hideLoading() }
                .subscribe(
                        { categories ->
                            contract.updateCategories(categories)
                        },
                        {
                            contract.showError(it.message.toString())
                        }
                )
    }

    override fun onViewDestroyed() {
        subscription?.dispose()
    }
}