package com.example.tavio_syrus_gblokpo.iai_vote.model;

public class Post {
    public  int userId;
    public  int id;
    public String title;
    public String body;

    public Post(int userId, int id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }
}
