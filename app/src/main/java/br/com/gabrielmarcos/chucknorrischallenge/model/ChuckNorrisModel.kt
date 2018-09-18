package br.com.gabrielmarcos.chucknorrischallenge.model

import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * Created by Gabriel Marcos on 16/09/2018
 */

class ChuckNorrisModel(val category: ArrayList<String>, @SerializedName("icon_url")val iconUrl: String, id: String,
                       val url: String, @SerializedName("value") val phrase: String)