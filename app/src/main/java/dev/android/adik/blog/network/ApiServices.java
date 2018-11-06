package dev.android.adik.blog.network;

import dev.android.adik.blog.model.detail.Post;
import dev.android.adik.blog.model.detail.ResponseDetail;
import dev.android.adik.blog.model.list.ResponsePost;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiServices {
    @GET("get_list_blog")
    Call<ResponsePost> getAllPost();

    @GET("get_detail_blog/{id}")
    Call<ResponseDetail> getDetail(
            @Path("id") int id
    );
}
