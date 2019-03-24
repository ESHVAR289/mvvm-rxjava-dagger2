
package com.einfoplanet.news.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Article {

    @SerializedName("source")
    @Expose
    public Source source;
    @SerializedName("author")
    @Expose
    public Object author;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("description")
    @Expose
    public Object description;
    @SerializedName("url")
    @Expose
    public String url;
    @SerializedName("urlToImage")
    @Expose
    public Object urlToImage;
    @SerializedName("publishedAt")
    @Expose
    public String publishedAt;
    @SerializedName("content")
    @Expose
    public String content;

    public Article withSource(Source source) {
        this.source = source;
        return this;
    }

    public Article withAuthor(Object author) {
        this.author = author;
        return this;
    }

    public Article withTitle(String title) {
        this.title = title;
        return this;
    }

    public Article withDescription(Object description) {
        this.description = description;
        return this;
    }

    public Article withUrl(String url) {
        this.url = url;
        return this;
    }

    public Article withUrlToImage(Object urlToImage) {
        this.urlToImage = urlToImage;
        return this;
    }

    public Article withPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
        return this;
    }

    public Article withContent(String content) {
        this.content = content;
        return this;
    }

}
