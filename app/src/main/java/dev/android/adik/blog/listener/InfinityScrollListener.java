package dev.android.adik.blog.listener;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


public abstract class InfinityScrollListener extends RecyclerView.OnScrollListener {

    LinearLayoutManager layoutManager;

    public InfinityScrollListener(LinearLayoutManager layoutManager){
        this.layoutManager = layoutManager;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy){
        super.onScrolled(recyclerView, dx, dy);

        int tampil = layoutManager.getChildCount();
        int jumlah = layoutManager.getItemCount();
        int firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();

        if (!isLoading() && !isLastPage()){
            if ((tampil + firstVisibleItemPosition) >= jumlah && firstVisibleItemPosition >= 0){
                loadMoreItems();
            }
        }

    }

    protected abstract void loadMoreItems();

    public abstract int getTotalPageCount();

    public abstract boolean isLastPage();

    public abstract boolean isLoading();
}
