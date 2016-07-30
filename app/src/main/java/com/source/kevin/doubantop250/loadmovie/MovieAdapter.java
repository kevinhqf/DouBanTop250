package com.source.kevin.doubantop250.loadmovie;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Movie列表的Adapter
 */
public class MovieAdapter extends RecyclerView.Adapter<MovieVH>{
    @Override
    public MovieVH onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(MovieVH holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

}

class MovieVH extends RecyclerView.ViewHolder{

    public MovieVH(View itemView) {
        super(itemView);
    }
}