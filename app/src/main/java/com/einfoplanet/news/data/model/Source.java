
package com.einfoplanet.news.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Source {

    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("name")
    @Expose
    public String name;

    public Source withId(String id) {
        this.id = id;
        return this;
    }

    public Source withName(String name) {
        this.name = name;
        return this;
    }

}
