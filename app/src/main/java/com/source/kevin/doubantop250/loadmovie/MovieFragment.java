package com.source.kevin.doubantop250.loadmovie;


import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.source.kevin.doubantop250.R;
import com.source.kevin.doubantop250.data.Movie;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieFragment extends Fragment implements MovieContract.View {

    //持有Presenter的实例
    MoviePresenter mPresenter;
    ArrayList<Movie> movies = new ArrayList<>();
    MovieAdapter mAdapter;
    @BindView(R.id.mf_rv_list)
    RecyclerView rv_list;
    @BindView(R.id.mf_srl)
    SwipeRefreshLayout srl;
    @BindView(R.id.load_more)
    LinearLayout load_more;
    private boolean isLoading=false;

    public static MovieFragment newInstance() {
        return new MovieFragment();
    }

    public MovieFragment() {

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.movie_frag, container, false);
        ButterKnife.bind(this, root);

        mAdapter = new MovieAdapter(getActivity(), movies);
        initView();


        return root;
    }

    private void initView() {
        load_more.setVisibility(View.GONE);
        srl.setColorSchemeColors(R.color.colorPrimary);
        srl.post(new Runnable() {
            @Override
            public void run() {
                srl.setRefreshing(true);
            }
        });
        srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.refresh();
            }
        });
        mPresenter.refresh();
        final StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        rv_list.setLayoutManager(layoutManager);
        rv_list.setAdapter(mAdapter);
        rv_list.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int lastPositions[] = layoutManager.findLastVisibleItemPositions(new int[layoutManager.getSpanCount()]);
                int lastVisiableItemPos = findMax(lastPositions);
                if (lastVisiableItemPos == mAdapter.getItemCount()-1) {
                    if(!isLoading) {
                        isLoading=true;
                        load_more.setVisibility(View.VISIBLE);
                        mPresenter.loadMore(lastVisiableItemPos + 1);
                    }
                }
            }

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }
        });
    }

    private int findMax(int[] lastPositions) {
        int max = lastPositions[0];
        for (int value : lastPositions) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    @Override
    public void setPresenter(MovieContract.Presenter presenter) {
        mPresenter = (MoviePresenter) presenter;
    }


    @Override
    public void loadMore(ArrayList<Movie> movie) {
        movies.addAll(movie);
        mAdapter.notifyDataSetChanged();
        load_more.setVisibility(View.GONE);
    }

    @Override
    public void refresh(ArrayList<Movie> movie) {
        movies.clear();
        movies.addAll(movie);
        mAdapter.notifyDataSetChanged();
        srl.setRefreshing(false);
    }



    @Override
    public void loadCompleted() {
        isLoading = false;
    }
}
