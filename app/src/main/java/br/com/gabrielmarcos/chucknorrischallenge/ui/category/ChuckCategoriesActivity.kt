package br.com.gabrielmarcos.chucknorrischallenge.ui.category

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import br.com.gabrielmarcos.chucknorrischallenge.R
import br.com.gabrielmarcos.chucknorrischallenge.base.BaseActivity
import br.com.gabrielmarcos.chucknorrischallenge.ui.detail.ChuckDetailActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class ChuckCategoriesActivity : BaseActivity<ChuckCategoriesPresenter>(),
        ChuckCategoriesContract, ChuckCategoriesAdapter.ChuckCategoriesAdapterListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.onViewCreated()
    }

    override fun onResume() {
        super.onResume()
        presenter.onViewCreated()
    }

    override fun onPause() {
        super.onPause()
        presenter.onViewDestroyed()
    }

    private fun setupAdapter(categories: ArrayList<String>) {
        categorieRecyclerView.adapter = ChuckCategoriesAdapter(this, this, categories)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        categorieRecyclerView.layoutManager = layoutManager
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onViewDestroyed()
    }

    override fun instantiatePresenter(): ChuckCategoriesPresenter {
        return ChuckCategoriesPresenter(this)
    }

    override fun updateCategories(categories: ArrayList<String>) {
        setupAdapter(categories)
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }

    override fun showLoading() {
        categoryProgress.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        categoryProgress.visibility = View.GONE
    }

    override fun onCategorieClicked(categorie: String) {
        val intent = Intent(this, ChuckDetailActivity::class.java)
        intent.putExtra(ChuckDetailActivity.CATEGORY, categorie)
        startActivity(intent)
    }
}
