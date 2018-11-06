package dev.android.adik.blog.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import dev.android.adik.blog.DetailActivity;
import dev.android.adik.blog.R;
import dev.android.adik.blog.model.list.Post;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostHolder> {

    private Context context;
    private List<Post> postList;

    @NonNull
    @Override
    public PostAdapter.PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_item, parent, false);
        return new PostHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapter.PostHolder holder, int position) {
        final Post post = postList.get(position);
        Picasso.get()
                .load(postList.get(position).getGambar())
                .into(holder.postThumbnail);
        holder.postTitle.setText(postList.get(position).getJudul());
        holder.postDate.setText(postList.get(position).getTanggal());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("ID_POST", post.getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public class PostHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView postThumbnail;
        TextView postTitle;
        TextView postDate;
        public PostHolder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.post);
            postThumbnail = itemView.findViewById(R.id.card_thumbnail);
            postTitle = itemView.findViewById(R.id.card_title);
            postDate = itemView.findViewById(R.id.card_date);
        }
    }

    public PostAdapter(Context context, List<Post> postList){
        this.context = context;
        this.postList = postList;
    }

}
