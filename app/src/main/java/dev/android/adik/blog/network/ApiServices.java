package dev.android.adik.blog.network;

import dev.android.adik.blog.model.ResponsePost;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServices {
    @GET("get_list_blog")
    Call<ResponsePost> getAllPost();
}
