package com.moringa.faqs_project.models;

public class Question {
    private int id;
    private String title;
    private String description;
    private String body;

    public Question(String title, String description, String body){
        this.title = title;
        this.description = description;
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
}
