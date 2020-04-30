package com.moringa.faqs_project.models;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel

public class PostAnswer implements Serializable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("question")
    @Expose
    private Integer question;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("body")
    @Expose
    private String body;
    @SerializedName("poster")
    @Expose
    private Integer poster;
    private final static long serialVersionUID = -1955730622562357381L;

    /**
     * No args constructor for use in serialization
     *
     */
    public PostAnswer() {
    }

    /**
     *
     * @param question
     * @param created
     * @param id
     * @param body
     * @param poster
     */
    public PostAnswer(Integer id, Integer question, String created, String body, Integer poster) {
        super();
        this.id = id;
        this.question = question;
        this.created = created;
        this.body = body;
        this.poster = poster;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuestion() {
        return question;
    }

    public void setQuestion(Integer question) {
        this.question = question;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Integer getPoster() {
        return poster;
    }

    public void setPoster(Integer poster) {
        this.poster = poster;
    }

}
