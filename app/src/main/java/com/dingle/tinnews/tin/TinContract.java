package com.dingle.tinnews.tin;

import com.dingle.tinnews.mvp.MvpContract;
import com.dingle.tinnews.retrofit.response.News;

import java.util.List;

public interface TinContract{
    interface View extends MvpContract.View<Presenter>{
        void showNewsCard(List<News> newsList);
        void onError();
    }

    interface Presenter extends MvpContract.Presenter<View, Model>{
        void showNewsCard(List<News> newsList);

        void saveFavoriteNews(News news);
        void onError();
    }

    interface Model extends MvpContract.Model<Presenter>{
        void fetchData();

        void saveFavoriteViews(News news);
    }
}
