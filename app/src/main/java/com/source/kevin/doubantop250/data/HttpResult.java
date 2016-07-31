package com.source.kevin.doubantop250.data;

import java.util.ArrayList;

/**
 * 网络请求返回的Json数据
 */
public class HttpResult {
    ArrayList<Movie> subjects;

    public ArrayList<Movie> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<Movie> subjects) {
        this.subjects = subjects;
    }
}
