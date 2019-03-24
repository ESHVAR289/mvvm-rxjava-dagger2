
package com.einfoplanet.news.data.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NewsApiDO {

    @SerializedName("status")
    @Expose
    public String status;
    @SerializedName("totalResults")
    @Expose
    public int totalResults;
    @SerializedName("articles")
    @Expose
    public List<Article> articles = null;

    public NewsApiDO withStatus(String status) {
        this.status = status;
        return this;
    }

    public NewsApiDO withTotalResults(int totalResults) {
        this.totalResults = totalResults;
        return this;
    }

    public NewsApiDO withArticles(List<Article> articles) {
        this.articles = articles;
        return this;
    }

}
