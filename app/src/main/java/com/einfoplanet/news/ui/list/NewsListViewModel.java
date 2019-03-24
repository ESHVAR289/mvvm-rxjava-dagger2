package com.einfoplanet.news.ui.list;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import com.einfoplanet.news.data.model.NewsApiDO;
import com.einfoplanet.news.data.rest.ArticleRepository;

public class NewsListViewModel extends ViewModel {

    private final ArticleRepository articleRepository;
    private CompositeDisposable disposable;
    private final MutableLiveData<NewsApiDO> newsData = new MutableLiveData<>();
    private final MutableLiveData<Boolean> articleLoadError = new MutableLiveData<>();
    private final MutableLiveData<Boolean> loading = new MutableLiveData<>();

    @Inject
    public NewsListViewModel(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
        disposable = new CompositeDisposable();
        fetchNews();
    }

    LiveData<NewsApiDO> getNewsData() {
        return newsData;
    }

    LiveData<Boolean> getError() {
        return articleLoadError;
    }

    LiveData<Boolean> getLoading() {
        return loading;
    }

    private void fetchNews() {
        loading.setValue(true);
        disposable.add(articleRepository.getNewsData("us", "4591e78026b142c59aedb833a3978494").subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableSingleObserver<NewsApiDO>() {
                    @Override
                    public void onSuccess(NewsApiDO value) {
                        articleLoadError.setValue(false);
                        newsData.setValue(value);
                        loading.setValue(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        articleLoadError.setValue(true);
                        loading.setValue(false);
                    }
                }));
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
