package com.source.kevin.doubantop250.loadmovie;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.source.kevin.doubantop250.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieFragment extends Fragment implements MovieContract.View{

    //持有Presenter的实例
    MoviePresenter mPresenter;

    MovieAdapter mAdapter;
    @BindView(R.id.mf_rv_list)
    RecyclerView rv_list;
    public static MovieFragment newInstance(){
        return new MovieFragment();
    }
    public MovieFragment(){

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.movie_frag,container,false);
        ButterKnife.bind(this,root);
        mAdapter = new MovieAdapter(getActivity());
        rv_list.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        rv_list.setAdapter(mAdapter);
        return root;
    }


    @Override
    public void setPresenter(MovieContract.Presenter presenter) {
        mPresenter = (MoviePresenter) presenter;
    }
}
