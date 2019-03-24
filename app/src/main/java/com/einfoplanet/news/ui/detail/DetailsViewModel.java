package com.einfoplanet.news.ui.detail;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.Bundle;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import com.einfoplanet.news.data.rest.ArticleRepository;

public class DetailsViewModel extends ViewModel {
    private CompositeDisposable disposable;
    private final MutableLiveData<String> selectedArticleUrl = new MutableLiveData<>();

    public LiveData<String> getSelectedArticleUrl() {
        return selectedArticleUrl;
    }

    @Inject
    public DetailsViewModel(ArticleRepository articleRepository) {
        disposable = new CompositeDisposable();
    }


    public void setSelectedArticleUrl(String urlToLoad) {
        selectedArticleUrl.setValue(urlToLoad);
    }

    public void saveToBundle(Bundle outState) {
        if (selectedArticleUrl.getValue() != null) {
            outState.putString("article_url",selectedArticleUrl.getValue());
        }
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (disposable != null) {
            disposable.clear();
            disposable = null;
        }
    }
}
