package br.com.gabrielmarcos.chucknorrischallenge.ui.detail

import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View
import android.webkit.WebView
import android.widget.Toast
import br.com.gabrielmarcos.chucknorrischallenge.R
import br.com.gabrielmarcos.chucknorrischallenge.base.BaseActivity
import br.com.gabrielmarcos.chucknorrischallenge.model.ChuckNorrisModel
import br.com.gabrielmarcos.chucknorrischallenge.ui.webview.WebViewActivity
import br.com.gabrielmarcos.chucknorrischallenge.utils.PicassoServiceHelper
import kotlinx.android.synthetic.main.detail_activity.*

/**
 * Created by Gabriel Marcos on 17/09/2018
 */
class ChuckDetailActivity : BaseActivity<ChuckDetailPresenter>(), ChuckDetailContract {

    companion object {
        const val CATEGORY = "category"
    }

    private var url = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)

        val category = intent.extras.getString(CATEGORY)

        presenter.showDetailCategorie(category)

        detailToolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        detailToolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.colorBlack))
        detailToolbar.title = getString(R.string.detail_title)
        setupButton()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onViewDestroyed()
    }

    override fun instantiatePresenter(): ChuckDetailPresenter {
        return ChuckDetailPresenter(this)
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }

    override fun showLoading() {
        categoryProgress.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        categoryProgress.visibility = View.INVISIBLE
    }

    override fun detailChuck(detail: ChuckNorrisModel) {
        val picassoService = PicassoServiceHelper(this)
        picassoService.loadImage(detail.iconUrl, detailIcon)
        detailPhrase.text = detail.phrase
        detailLink.text = detail.url

        url = detail.url
    }

    private fun setupButton() {
        detailVisitPage.setOnClickListener {
            val intent = Intent(this, WebViewActivity::class.java)
            intent.putExtra(WebViewActivity.URL, url)
            startActivity(intent)
        }
    }
}