package com.source.kevin.doubantop250.loadmovie;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.source.kevin.doubantop250.R;
import com.source.kevin.doubantop250.data.Movie;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Movie列表的Adapter
 */
public class MovieAdapter extends RecyclerView.Adapter<MovieVH> {

    Context mContext;
    private ArrayList<Movie> movies;

    public MovieAdapter(Context context, ArrayList<Movie> movies) {
        this.mContext = context;
        this.movies = movies;
    }

    @Override
    public MovieVH onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MovieVH(LayoutInflater.from(mContext).inflate(R.layout.item_movie, null));
    }

    @Override
    public void onBindViewHolder(MovieVH holder, int position) {
        String url = movies.get(position).getImages().getMedium();
        Glide.with(mContext).load(url).placeholder(R.drawable.pictures_no).centerCrop().into(holder.iv_movie);
        holder.tv_title.setText(movies.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return movies == null ? 0 : movies.size();
    }

}

class MovieVH extends RecyclerView.ViewHolder {
    @BindView(R.id.im_iv_movie)
    ImageView iv_movie;
    @BindView(R.id.im_tv_title)
    TextView tv_title;

    public MovieVH(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

}