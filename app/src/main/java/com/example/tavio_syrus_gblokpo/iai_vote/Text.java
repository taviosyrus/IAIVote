package com.example.tavio_syrus_gblokpo.iai_vote;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.tavio_syrus_gblokpo.iai_vote.Adapter.PostAdapter;
import com.example.tavio_syrus_gblokpo.iai_vote.model.Post;
import com.example.tavio_syrus_gblokpo.iai_vote.retrofit.IMyAPI;
import com.example.tavio_syrus_gblokpo.iai_vote.retrofit.RetrofitClient;

import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class Text extends AppCompatActivity {
    IMyAPI  iMyAPI;
    RecyclerView recyclerView;
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        iniAPI();
    }
public void iniAPI(){
    Retrofit retrofit = RetrofitClient.getInstance();
    iMyAPI = retrofit.create(IMyAPI.class);

    recyclerView =  findViewById(R.id.recyclerView);
    recyclerView.setHasFixedSize(true);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));

    fechData();
}

    private void fechData() {
        compositeDisposable.add(iMyAPI.getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Post>>() {
                    @Override
                    public void accept(List<Post> posts) throws Exception {
                        displayData(posts);


                    }
                }));
    }

    private void displayData(List<Post> posts) {

        PostAdapter adapter = new PostAdapter(this,posts);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStop() {
        compositeDisposable.clear();
        super.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
