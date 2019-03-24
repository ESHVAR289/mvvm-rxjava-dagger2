package com.einfoplanet.news.ui.detail;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

import javax.inject.Inject;

import butterknife.BindView;
import com.einfoplanet.news.R;
import com.einfoplanet.news.base.BaseFragment;
import com.einfoplanet.news.util.ViewModelFactory;

import static android.content.Context.CONNECTIVITY_SERVICE;

public class DetailsFragment extends BaseFragment {

    @BindView(R.id.article_web_view)
    WebView webViewArtcle;

    @Inject
    ViewModelFactory viewModelFactory;
    private DetailsViewModel detailsViewModel;

    @Override
    protected int layoutRes() {
        return R.layout.screen_details;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        detailsViewModel = ViewModelProviders.of(getBaseActivity(), viewModelFactory).get(DetailsViewModel.class);
        loadArticle(view);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        detailsViewModel.saveToBundle(outState);
    }

    private void loadArticle(View view) {
        webViewArtcle.getSettings().setAppCacheMaxSize(5 * 1024 * 1024); // 5MB
        webViewArtcle.getSettings().setAppCachePath(view.getContext().getCacheDir().getAbsolutePath());
        webViewArtcle.getSettings().setAllowFileAccess(true);
        webViewArtcle.getSettings().setAppCacheEnabled(true);
        webViewArtcle.getSettings().setJavaScriptEnabled(true);
        webViewArtcle.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT); // load online by default

        if (!isNetworkAvailable(view.getContext())) { // loading offline
            webViewArtcle.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        }

        String webViewUrl = detailsViewModel.getSelectedArticleUrl().getValue();
        Log.e("WEB VIEW", "Web view url :-> " + webViewUrl);
        webViewArtcle.loadUrl(webViewUrl);
    }

    private boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
