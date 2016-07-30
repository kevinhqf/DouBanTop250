package com.source.kevin.doubantop250.loadmovie;

/**
 * 具体的loadMovie模块的Presenter
 */
public class MoviePresenter implements MovieContract.Presenter{
    //持有View对象,用于对UI进行更新
    MovieContract.View mView;

    public MoviePresenter(MovieContract.View view) {
        this.mView = view;
        mView.setPresenter(this);
    }

    @Override
    public void start() {

    }
}
