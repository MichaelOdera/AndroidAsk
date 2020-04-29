
package com.moringa.faqs_project.models;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Answer implements Parcelable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("body")
    @Expose
    private String body;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("poster")
    @Expose
    private Integer poster;
    @SerializedName("question")
    @Expose
    private Integer question;
    @SerializedName("upvotes")
    @Expose
    private List<Integer> upvotes = null;
    @SerializedName("downvotes")
    @Expose
    private List<Integer> downvotes = null;
    public final static Creator<Answer> CREATOR = new Creator<Answer>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Answer createFromParcel(Parcel in) {
            return new Answer(in);
        }

        public Answer[] newArray(int size) {
            return (new Answer[size]);
        }

    }
    ;

    protected Answer(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.body = ((String) in.readValue((String.class.getClassLoader())));
        this.created = ((String) in.readValue((String.class.getClassLoader())));
        this.poster = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.question = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.upvotes, (Integer.class.getClassLoader()));
        in.readList(this.downvotes, (Integer.class.getClassLoader()));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Answer() {
    }

    /**
     * 
     * @param question
     * @param upvotes
     * @param created
     * @param id
     * @param body
     * @param downvotes
     * @param poster
     */
    public Answer(Integer id, String body, String created, Integer poster, Integer question, List<Integer> upvotes, List<Integer> downvotes) {
        super();
        this.id = id;
        this.body = body;
        this.created = created;
        this.poster = poster;
        this.question = question;
        this.upvotes = upvotes;
        this.downvotes = downvotes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getQuestion() {
        return question;
    }

    public void setQuestion(Integer question) {
        this.question = question;
    }

    public List<Integer> getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(List<Integer> upvotes) {
        this.upvotes = upvotes;
    }

    public List<Integer> getDownvotes() {
        return downvotes;
    }

    public void setDownvotes(List<Integer> downvotes) {
        this.downvotes = downvotes;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(body);
        dest.writeValue(created);
        dest.writeValue(poster);
        dest.writeValue(question);
        dest.writeList(upvotes);
        dest.writeList(downvotes);
    }

    public int describeContents() {
        return  0;
    }

}
