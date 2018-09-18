package br.com.gabrielmarcos.chucknorrischallenge.ui.detail

import br.com.gabrielmarcos.chucknorrischallenge.base.BaseContract
import br.com.gabrielmarcos.chucknorrischallenge.model.ChuckNorrisModel

/**
 * Created by Gabriel Marcos on 16/09/2018
 */
interface ChuckDetailContract: BaseContract {
    fun detailChuck(detail: ChuckNorrisModel)

}