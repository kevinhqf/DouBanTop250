package com.source.kevin.doubantop250.loadmovie;

import com.source.kevin.doubantop250.BasePresenter;
import com.source.kevin.doubantop250.BaseView;

/**
 * 用于管理loadMovie功能模块的View与Presenter
 */
public class MovieContract {

    /**
     * loadMovie模块的View,提供对外的UI更新接口
     */
    interface View extends BaseView<Presenter>{

    }

    /**
     * loadMovie模块的Presenter,负责获取数据并处理,更新UI
     */
    interface Presenter extends BasePresenter{

    }

}
