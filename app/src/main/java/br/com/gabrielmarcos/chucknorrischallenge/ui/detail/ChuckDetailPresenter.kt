package br.com.gabrielmarcos.chucknorrischallenge.ui.detail

import br.com.gabrielmarcos.chucknorrischallenge.base.BasePresenter
import br.com.gabrielmarcos.chucknorrischallenge.network.ChuckNorrisApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Gabriel Marcos on 17/09/2018
 */
class ChuckDetailPresenter(detailContract: ChuckDetailContract): BasePresenter<ChuckDetailContract>(detailContract) {

    @Inject
    lateinit var chuckDetailApi: ChuckNorrisApi

    private var subscription: Disposable? = null

    override fun onViewCreated() {}


    fun showDetailCategorie(category: String) {
        contract.showLoading()
        subscription = chuckDetailApi
                .getDetailCategorie(category)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnTerminate { contract.hideLoading() }
                .subscribe(
                        { detail ->
                            contract.detailChuck(detail)
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