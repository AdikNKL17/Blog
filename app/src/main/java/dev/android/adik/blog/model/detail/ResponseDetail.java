package dev.android.adik.blog.model.detail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseDetail {
    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("berita")
    @Expose
    private Post post;
    @SerializedName("related")
    @Expose
    private List<Related> related = null;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public List<Related> getRelated() {
        return related;
    }

    public void setRelated(List<Related> related) {
        this.related = related;
    }
}
