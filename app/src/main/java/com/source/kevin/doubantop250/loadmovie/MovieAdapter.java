package com.source.kevin.doubantop250.loadmovie;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.source.kevin.doubantop250.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Movie列表的Adapter
 */
public class MovieAdapter extends RecyclerView.Adapter<MovieVH>{

    Context mContext;

    public MovieAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public MovieVH onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MovieVH(LayoutInflater.from(mContext).inflate(R.layout.item_movie,null));
    }

    @Override
    public void onBindViewHolder(MovieVH holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 20;
    }

}

class MovieVH extends RecyclerView.ViewHolder{
    @BindView(R.id.im_iv_movie) ImageView iv_movie;
    @BindView(R.id.im_tv_title) TextView tv_title;
    public MovieVH(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}