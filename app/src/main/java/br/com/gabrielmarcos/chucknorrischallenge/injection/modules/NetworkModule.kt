package br.com.gabrielmarcos.chucknorrischallenge.injection.modules

import br.com.gabrielmarcos.chucknorrischallenge.BuildConfig
import br.com.gabrielmarcos.chucknorrischallenge.network.ChuckNorrisApi
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by Gabriel Marcos on 16/09/2018
 */
@Module
object NetworkModule {
    @Provides
    internal fun provideApi(retrofit: Retrofit): ChuckNorrisApi{
        return retrofit.create(ChuckNorrisApi::class.java)
    }

    @Provides
    internal fun provideRetrofitInterface(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build()
    }
}