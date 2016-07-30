package com.source.kevin.doubantop250;

/**
 *  View模块抽象接口
 */
public interface BaseView<T> {
    /**
     * 将对应的Presenter注入到View当中
     * @param presenter 注入的Presenter
     */
    void setPresenter(T presenter);
}
