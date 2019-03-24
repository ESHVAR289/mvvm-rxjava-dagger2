package com.einfoplanet.news.ui.list;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import com.einfoplanet.news.R;
import com.einfoplanet.news.base.BaseFragment;
import com.einfoplanet.news.data.model.Article;
import com.einfoplanet.news.ui.detail.DetailsFragment;
import com.einfoplanet.news.ui.detail.DetailsViewModel;
import com.einfoplanet.news.util.ViewModelFactory;

public class ListFragment extends BaseFragment implements ArticleSelectedListener {

    @BindView(R.id.recyclerView) RecyclerView listView;
    @BindView(R.id.tv_error) TextView errorTextView;
    @BindView(R.id.loading_view) View loadingView;

    @Inject ViewModelFactory viewModelFactory;
    private NewsListViewModel newsListViewModel;

    @Override
    protected int layoutRes() {
        return R.layout.screen_list;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        newsListViewModel = ViewModelProviders.of(this, viewModelFactory).get(NewsListViewModel.class);

        listView.addItemDecoration(new DividerItemDecoration(getBaseActivity(), DividerItemDecoration.VERTICAL));
        listView.setAdapter(new NewsListAdapter(newsListViewModel, this, this));
        listView.setLayoutManager(new LinearLayoutManager(getContext()));

        newsObservableViewModel();
    }

    @Override
    public void onArticleSelected(Article article) {
        DetailsViewModel detailsViewModel = ViewModelProviders.of(getBaseActivity(), viewModelFactory).get(DetailsViewModel.class);
        detailsViewModel.setSelectedArticleUrl(article.url);
        getBaseActivity().getSupportFragmentManager().beginTransaction().replace(R.id.screenContainer, new DetailsFragment())
                .addToBackStack(null).commit();
    }

    private void newsObservableViewModel() {
        newsListViewModel.getNewsData().observe(this, news -> {
            if (news != null) listView.setVisibility(View.VISIBLE);
        });
        newsListViewModel.getError().observe(this, isError -> {
            if (isError != null) if (isError) {
                errorTextView.setVisibility(View.VISIBLE);
                listView.setVisibility(View.GONE);
                errorTextView.setText("An Error Occurred While Loading Data!");
            } else {
                errorTextView.setVisibility(View.GONE);
                errorTextView.setText(null);
            }
        });

        newsListViewModel.getLoading().observe(this, isLoading -> {
            if (isLoading != null) {
                loadingView.setVisibility(isLoading ? View.VISIBLE : View.GONE);
                if (isLoading) {
                    errorTextView.setVisibility(View.GONE);
                    listView.setVisibility(View.GONE);
                }
            }
        });
    }
}
