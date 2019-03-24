package com.einfoplanet.news.data.rest;

import java.util.Map;

import io.reactivex.Single;
import com.einfoplanet.news.data.model.NewsApiDO;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface ArticleService {

    @GET("v2/top-headlines/")
    Single<NewsApiDO> getNewsData(@QueryMap Map<String, String> options);

}
