package br.com.gabrielmarcos.chucknorrischallenge.ui.category

import br.com.gabrielmarcos.chucknorrischallenge.base.BaseContract
import java.util.*

/**
 * Created by Gabriel Marcos on 16/09/2018
 */
interface ChuckCategoriesContract: BaseContract {
    fun updateCategories(categories: ArrayList<String>)
}