package com.einfoplanet.news.data.rest;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Single;
import com.einfoplanet.news.data.model.NewsApiDO;

public class ArticleRepository {

    private final ArticleService articleService;

    @Inject
    public ArticleRepository(ArticleService articleService) {
        this.articleService = articleService;
    }

    public Single<NewsApiDO> getNewsData(String country, String apiKey) {
        Map<String, String> data = new HashMap<>();
        data.put("country", country);
        data.put("apiKey", apiKey);
        return articleService.getNewsData(data);
    }
}
