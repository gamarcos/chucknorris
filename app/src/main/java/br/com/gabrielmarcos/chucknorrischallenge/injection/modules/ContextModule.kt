package br.com.gabrielmarcos.chucknorrischallenge.injection.modules

import android.app.Application
import android.content.Context
import br.com.gabrielmarcos.chucknorrischallenge.base.BaseContract
import dagger.Module
import dagger.Provides

/**
 * Created by Gabriel Marcos on 16/09/2018
 */
@Module
object ContextModule  {
    @Provides
    @JvmStatic
    internal fun provideContext(baseContract: BaseContract): Context {
        return baseContract.getContext()
    }

    @Provides
    @JvmStatic
    internal fun provideApplication(context: Context): Application {
        return context.applicationContext as Application
    }
}