package br.com.gabrielmarcos.chucknorrischallenge.ui.category

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.gabrielmarcos.chucknorrischallenge.R
import kotlinx.android.synthetic.main.adapter_category.view.*
import java.util.*

/**
 * Created by Gabriel Marcos on 16/09/2018
 */
class ChuckCategoriesAdapter(private val context: Context,
                             private val listener: ChuckCategoriesAdapterListener,
                             private val categories: ArrayList<String>): RecyclerView.Adapter<ChuckCategoriesAdapter.ViewHolder>() {

    interface ChuckCategoriesAdapterListener {
        fun onCategorieClicked(categorie: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.adapter_category, parent, false)
        return ViewHolder(view, listener)
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(categories[position])
    }

    class ViewHolder(itemView: View, val listener: ChuckCategoriesAdapterListener ): RecyclerView.ViewHolder(itemView) {

        fun bindView(categorie: String) {
            itemView.categorieTitle.text = categorie

            itemView.categorieCell.setOnClickListener {
                listener.onCategorieClicked(categorie)
            }
        }
    }
}