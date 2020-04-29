
package com.moringa.faqs_project.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel

public class QuestionSearchResponse {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("body")
    @Expose
    private String body;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("poster")
    @Expose
    private Integer poster;
//    @SerializedName("tags")
//    @Expose
//    private List<Object> tags = null;

    public QuestionSearchResponse(){

    }

    public QuestionSearchResponse(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public Integer getPoster() {
        return poster;
    }

    public void setPoster(Integer poster) {
        this.poster = poster;
    }

//    public List<Object> getTags() {
//        return tags;
//    }
//
//    public void setTags(List<Object> tags) {
//        this.tags = tags;
//    }

}
