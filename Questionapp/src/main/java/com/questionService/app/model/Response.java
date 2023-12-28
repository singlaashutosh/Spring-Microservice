package com.questionService.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Response {
    public Response(int id, String response) {
        this.id = id;
        this.response = response;
    }
    @Id
    private int id;
    private String response;

    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getResponse() {
        return this.response;
    }
    public void setResponse(String response) {
        this.response = response;
    }


}
