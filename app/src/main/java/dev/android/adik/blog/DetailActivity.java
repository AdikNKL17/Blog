package dev.android.adik.blog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.jaredrummler.android.util.HtmlBuilder;
import com.squareup.picasso.Picasso;

import dev.android.adik.blog.model.detail.Post;
import dev.android.adik.blog.model.detail.ResponseDetail;
import dev.android.adik.blog.network.ApiServices;
import dev.android.adik.blog.network.InitRetrofit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {
    Toolbar mtoolbar;
    ImageView postImage;
    TextView postDate, postTitle, postText;
    InterstitialAd mInterstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mtoolbar = findViewById(R.id.toolbar);
        mtoolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        mtoolbar.inflateMenu(R.menu.detail_menu);

        postImage = findViewById(R.id.post_image);
        postDate = findViewById(R.id.date_detail);
        postTitle = findViewById(R.id.title_detail);
        postText = findViewById(R.id.text_detail);

        MobileAds.initialize(this, "ca-app-pub-3738675243322071~9841768298");
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3738675243322071/3440011477");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mInterstitialAd.show();


        showDetail();
    }

    private void showDetail() {
        /*String IMG_URL = getIntent().getStringExtra("IMG_URL");
        String DATE = getIntent().getStringExtra("POST_DATE");
        String POST_TITLE = getIntent().getStringExtra("POST_TITLE");

        postDate.setText(DATE);
        postTitle.setText(POST_TITLE);

        Picasso.get()
                .load(IMG_URL)
                .into(postImage);*/
        int id = getIntent().getIntExtra("ID_POST", 0);

        ApiServices apiServices = InitRetrofit.getInstance();

        retrofit2.Call<ResponseDetail> detailCall = apiServices.getDetail(id);

        detailCall.enqueue(new Callback<ResponseDetail>() {
            @Override
            public void onResponse(Call<ResponseDetail> call, Response<ResponseDetail> response) {
                if (response.isSuccessful()) {
                    Log.d("response", response.body().toString());

                    Post dataPost = response.body().getPost();

                    boolean status = response.body().getStatus();

                    if (status){
                        Picasso.get()
                                .load(dataPost.getImages())
                                .into(postImage);
                        postDate.setText(dataPost.getTanggal());
                        postTitle.setText(dataPost.getTitle());
                        HtmlBuilder html = new HtmlBuilder();
                        html.p(dataPost.getContent());
                        postText.setText(html.build());
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseDetail> call, Throwable t) {

            }
        });
    }
}
