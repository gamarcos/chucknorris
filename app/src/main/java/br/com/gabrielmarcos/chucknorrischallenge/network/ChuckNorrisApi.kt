package br.com.gabrielmarcos.chucknorrischallenge.network

import br.com.gabrielmarcos.chucknorrischallenge.model.ChuckNorrisModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

/**
 * Created by Gabriel Marcos on 16/09/2018
 */
interface ChuckNorrisApi {

    @GET("categories")
    fun getCategories(): Observable<ArrayList<String>>

    @GET("random")
    fun getDetailCategorie(@Query("category") category: String?): Observable<ChuckNorrisModel>
}