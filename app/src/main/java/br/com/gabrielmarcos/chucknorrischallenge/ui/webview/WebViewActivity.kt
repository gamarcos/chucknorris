package br.com.gabrielmarcos.chucknorrischallenge.ui.webview

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View
import android.webkit.WebViewClient
import android.widget.Toast
import br.com.gabrielmarcos.chucknorrischallenge.R
import br.com.gabrielmarcos.chucknorrischallenge.base.BaseActivity
import kotlinx.android.synthetic.main.activity_web_view.*

/**
 * Created by Gabriel Marcos on 18/09/2018
 */
class WebViewActivity: BaseActivity<WebViewPresenter>(), WebViewContract {

    companion object {
        const val URL = "url"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        webViewToolbar.title = getString(R.string.detail_title_button)
        webViewToolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.colorBlack))

        webViewToolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        setupView()
    }

    override fun instantiatePresenter(): WebViewPresenter {
        return WebViewPresenter(this)
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }

    override fun showLoading() {
        categoryProgress.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        categoryProgress.visibility = View.INVISIBLE
    }

    private fun setupView() {
        val url = intent.extras.getString(URL)

        webView.webViewClient = WebViewClient()
        webView.settings.setAppCacheEnabled (true)
        webView.settings.javaScriptEnabled = true
        webView.settings.loadWithOverviewMode = true
        webView.settings.allowFileAccess = true
        webView.settings.allowContentAccess = true

        webView.loadUrl(url)
    }
}