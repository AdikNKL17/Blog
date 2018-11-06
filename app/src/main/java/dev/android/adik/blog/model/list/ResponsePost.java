package dev.android.adik.blog.model.list;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("ALL")
public class ResponsePost {
    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("jumlah")
    @Expose
    private Integer jumlah;
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("per_page")
    @Expose
    private Integer perPage;
    @SerializedName("current_page")
    @Expose
    private Integer currentPage;
    @SerializedName("next_page_url")
    @Expose
    private Object nextPageUrl;
    @SerializedName("prev_page_url")
    @Expose
    private Object prevPageUrl;
    @SerializedName("blog")
    @Expose
    private List<Post> post = null;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Object getNextPageUrl() {
        return nextPageUrl;
    }

    public void setNextPageUrl(Object nextPageUrl) {
        this.nextPageUrl = nextPageUrl;
    }

    public Object getPrevPageUrl() {
        return prevPageUrl;
    }

    public void setPrevPageUrl(Object prevPageUrl) {
        this.prevPageUrl = prevPageUrl;
    }

    public List<Post> getBlog() {
        return post;
    }

    public void setBlog(List<Post> post) {
        this.post = post;
    }
}
