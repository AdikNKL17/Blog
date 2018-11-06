package dev.android.adik.blog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telecom.Call;
import android.util.Log;

import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
import java.util.List;

import dev.android.adik.blog.adapter.PostAdapter;
import dev.android.adik.blog.model.Post;
import dev.android.adik.blog.model.ResponsePost;
import dev.android.adik.blog.network.ApiServices;
import dev.android.adik.blog.network.InitRetrofit;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Post> postList;
    PostAdapter postAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView =(RecyclerView) findViewById(R.id.blog_list);
        postList = new ArrayList<>();
        postAdapter = new PostAdapter(this, postList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(postAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");

        dataPost();
    }

    private void dataPost() {
        ApiServices apiServices = InitRetrofit.getInstance();

        retrofit2.Call<ResponsePost> postCall = apiServices.getAllPost();

        postCall.enqueue(new Callback<ResponsePost>() {
            @Override
            public void onResponse(retrofit2.Call<ResponsePost> call, Response<ResponsePost> response) {
                if (response.isSuccessful()){
                    Log.d("response", response.body().toString());

                    List<Post> dataPost = response.body().getBlog();
                    boolean status = response.body().getStatus();

                    if (status){
                        PostAdapter postAdapter = new PostAdapter(MainActivity.this, dataPost);
                        recyclerView.setAdapter(postAdapter);
                    }
                }
            }

            @Override
            public void onFailure(retrofit2.Call<ResponsePost> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
