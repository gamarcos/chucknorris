package br.com.gabrielmarcos.chucknorrischallenge.base

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by Gabriel Marcos on 16/09/2018
 */
abstract class BaseActivity<P: BasePresenter<BaseContract>> : BaseContract, AppCompatActivity() {
    protected lateinit var presenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter = instantiatePresenter()
    }

    protected abstract fun instantiatePresenter(): P

    override fun getContext(): Context {
        return this
    }
}