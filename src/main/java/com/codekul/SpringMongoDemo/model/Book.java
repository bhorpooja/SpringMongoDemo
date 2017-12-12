package com.codekul.SpringMongoDemo.model;

import org.springframework.data.annotation.Id;

/**
 * Created by pooja on 7/12/17.
 */
public class Book {

    @Id
    String id;
    String name;
    String auth;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }
}
