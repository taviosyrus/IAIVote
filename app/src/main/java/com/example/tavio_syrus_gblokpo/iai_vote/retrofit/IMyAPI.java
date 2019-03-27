package com.example.tavio_syrus_gblokpo.iai_vote.retrofit;

import com.example.tavio_syrus_gblokpo.iai_vote.model.Post;

import java.util.List;


import io.reactivex.Observable;
import retrofit2.http.GET;

public interface IMyAPI {
    @GET("posts")
    Observable<List<Post>> getPosts();


}
