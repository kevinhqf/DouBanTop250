package com.source.kevin.doubantop250.loadmovie;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MovieFragment extends Fragment implements MovieContract.View{

    //持有Presenter的实例
    MoviePresenter mPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }


    @Override
    public void setPresenter(MovieContract.Presenter presenter) {
        mPresenter = (MoviePresenter) presenter;
    }
}
