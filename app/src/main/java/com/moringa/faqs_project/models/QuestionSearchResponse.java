package com.moringa.faqs_project.models;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.moringa.faqs_project.models.Answer;

import org.parceler.Parcel;

@Parcel
public class QuestionSearchResponse implements Serializable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("body")
    @Expose
    private String body;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("poster")
    @Expose
    private Integer poster;
    @SerializedName("answers")
    @Expose
    private List<Answer> answers = null;
    private final static long serialVersionUID = -124300061997938872L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public QuestionSearchResponse() {
    }

    /**
     * 
     * @param created
     * @param answers
     * @param id
     * @param title
     * @param body
     * @param poster
     */
    public QuestionSearchResponse(Integer id, String title, String body, String created, Integer poster, List<Answer> answers) {
        super();
        this.id = id;
        this.title = title;
        this.body = body;
        this.created = created;
        this.poster = poster;
        this.answers = answers;
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

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

}
