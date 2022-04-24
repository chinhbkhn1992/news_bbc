package com.chinh.news.ui.adapter

import android.graphics.Bitmap
import android.view.View
import android.webkit.*
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.widget.ContentLoadingProgressBar
import androidx.databinding.BindingAdapter
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.chinh.news.R

fun ImageView.loadImage(url: String?, placeHolderImage: Int? = null, errorImage: Int? = null) {
    val placeHolder = placeHolderImage ?: R.drawable.ic_news_svgrepo_com
    val error = errorImage ?: R.drawable.ic_news_svgrepo_com
    val scaleType = this.scaleType
    if (url.isNullOrEmpty()) {
        var request = GlideApp.with(this.context)
            .load(error)
        if (scaleType == ImageView.ScaleType.CENTER_CROP)
            request = request.centerCrop()
        request.into(this)
        return
    }
    GlideApp.with(this.context)
        .load(url)
        .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
        .placeholder(placeHolder)
        .error(error)
        .into(this)
}

@BindingAdapter(value = ["image_url"])
fun setShopImage(imageView: ImageView, url: String?) {
    imageView.loadImage(url = url)
}

@BindingAdapter(value = ["webview_url"])
fun WebView.startWebView(url: String?) {
    if (url.isNullOrBlank()) {
        return
    }
    val process = (parent as View).findViewById<ContentLoadingProgressBar>(R.id.progress)
    val settings = settings
    settings.javaScriptEnabled = true
    scrollBarStyle = View.SCROLLBARS_OUTSIDE_OVERLAY
    settings.loadWithOverviewMode = true
    webViewClient = object : WebViewClient() {

        override fun onReceivedError(
            view: WebView,
            errorCode: Int,
            description: String,
            failingUrl: String
        ) {
            Toast.makeText(context, "Error:$description", Toast.LENGTH_SHORT).show()
        }

        override fun onReceivedError(
            view: WebView, request: WebResourceRequest,
            error: WebResourceError
        ) {
            super.onReceivedError(view, request, error)
        }

        override fun onPageFinished(view: WebView, url: String) {
            super.onPageFinished(view, url)
            process?.hide()
        }

        override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
            super.onPageStarted(view, url, favicon)
            process?.show()
        }
    }
    webChromeClient = WebChromeClient()
    loadUrl(url)
}