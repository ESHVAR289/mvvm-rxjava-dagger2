package com.einfoplanet.news.ui.list;

import android.arch.lifecycle.LifecycleOwner;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.einfoplanet.news.R;
import com.einfoplanet.news.data.model.Article;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.ArticleViewHolder> {

    private ArticleSelectedListener articleSelectedListener;
    private final List<Article> data = new ArrayList<>();

    NewsListAdapter(NewsListViewModel viewModel, LifecycleOwner lifecycleOwner, ArticleSelectedListener articleSelectedListener) {
        this.articleSelectedListener = articleSelectedListener;
        viewModel.getNewsData().observe(lifecycleOwner, news -> {
            data.clear();
            if (news != null) {
                data.addAll(news.articles);
                notifyDataSetChanged();
            }
        });
        setHasStableIds(true);
    }

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_article_single_view, parent, false);
        return new ArticleViewHolder(view, articleSelectedListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    static final class ArticleViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_source_name)
        TextView txtSourceName;
        @BindView(R.id.txt_author_name)
        TextView txtAuthorName;
        @BindView(R.id.txt_title)
        TextView txtTitle;
        @BindView(R.id.txt_description)
        TextView txtDescription;
        @BindView(R.id.ll_author_container)
        LinearLayout llAuthorContainer;
        @BindView(R.id.iv_article)
        ImageView ivArticleImage;

        private Article article;

        ArticleViewHolder(View itemView, ArticleSelectedListener articleSelectedListener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(v -> {
                if (article != null) {
                    articleSelectedListener.onArticleSelected(article);
                }
            });
        }

        void bind(Article article) {
            this.article = article;
            if (isValidSourceName(article.source.name)) {
                txtSourceName.setText(article.source.name);
            } else
                txtSourceName.setVisibility(View.INVISIBLE);

            txtTitle.setText(article.title);
            if (isValidDescription(article.description)) {
                String articleDescription = String.valueOf(article.description);
                txtDescription.setText(articleDescription);
            } else
                txtDescription.setVisibility(View.GONE);

            if (isValidAuthor(article.author)) {
                String authorName = String.valueOf(article.author);
                if (!authorName.equalsIgnoreCase("")) {
                    llAuthorContainer.setVisibility(View.VISIBLE);
                    txtAuthorName.setVisibility(View.VISIBLE);
                    txtAuthorName.setText(authorName);
                } else {
                    txtAuthorName.setVisibility(View.INVISIBLE);
                    llAuthorContainer.setVisibility(View.GONE);
                }
            } else {
                llAuthorContainer.setVisibility(View.INVISIBLE);
                txtAuthorName.setVisibility(View.GONE);
            }

            if (isValidUrlToImage(article.urlToImage)) {
                String articleImageUrl = String.valueOf(article.urlToImage);
                Picasso.with(itemView.getContext()).load(articleImageUrl).into(ivArticleImage);
            }

        }
    }

    public static boolean isValidUrlToImage(Object objUrlToImage) {
        System.out.println("UrlToImage :-> " + objUrlToImage);
        if (objUrlToImage != null) {
            String strUrlToImage = String.valueOf(objUrlToImage);
            return !strUrlToImage.equalsIgnoreCase("");
        }
        return false;
    }

    public static boolean isValidDescription(Object objDescription) {
        System.out.println("Description :-> " + objDescription);
        if (objDescription != null) {
            String strDescription = String.valueOf(objDescription);
            return !strDescription.equalsIgnoreCase("");
        }
        return false;
    }

    public static boolean isValidAuthor(Object objAuthor) {
        System.out.println("Author :-> " + objAuthor);
        if (objAuthor != null) {
            String authorName = String.valueOf(objAuthor);
            return !authorName.equalsIgnoreCase("");
        }
        return false;
    }

    public static boolean isValidSourceName(String sourceName) {
        System.out.println("Source name :-> " + sourceName);
        if (sourceName != null) {
            return !sourceName.equalsIgnoreCase("");
        }
        return false;
    }
}
