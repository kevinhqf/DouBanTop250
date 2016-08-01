package com.source.kevin.doubantop250;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.source.kevin.doubantop250.loadmovie.MovieFragment;
import com.source.kevin.doubantop250.loadmovie.MoviePresenter;

public class MainActivity extends AppCompatActivity {

    MoviePresenter mPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MovieFragment movieFragment = MovieFragment.newInstance();
        addFragment(R.id.content_frame,movieFragment);
        mPresenter = new MoviePresenter(movieFragment);
    }

    private void addFragment(int id, Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(id, fragment);
        transaction.commit();
    }


}
