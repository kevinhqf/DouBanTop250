package com.source.kevin.doubantop250.loadmovie;

import com.source.kevin.doubantop250.BasePresenter;
import com.source.kevin.doubantop250.BaseView;
import com.source.kevin.doubantop250.data.Movie;

import java.util.ArrayList;

/**
 * 用于管理loadMovie功能模块的View与Presenter
 */
public class MovieContract {

    /**
     * loadMovie模块的View,提供对外的UI更新接口
     */
    interface View extends BaseView<Presenter>{
        void loadMore(ArrayList<Movie> movie);//上拉加载更多
        void refresh(ArrayList<Movie> movie);//下拉刷新
        void loadCompleted();//改变上拉加载状态
    }

    /**
     * loadMovie模块的Presenter,负责获取数据并处理,更新UI
     */
    interface Presenter extends BasePresenter{
        void refresh();//刷新
        void loadMore(int start);//加载更多
    }

}
