package br.com.gabrielmarcos.chucknorrischallenge.base

import android.content.Context

/**
 * Created by Gabriel Marcos on 16/09/2018
 */
interface BaseContract {
    fun getContext(): Context

    fun showError(error: String)

    fun showLoading()

    fun hideLoading()
}