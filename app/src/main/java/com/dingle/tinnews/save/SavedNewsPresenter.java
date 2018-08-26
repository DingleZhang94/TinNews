package com.dingle.tinnews.save;

import com.dingle.tinnews.mvp.MvpContract;
import com.dingle.tinnews.retrofit.response.News;

import java.util.List;

public class SavedNewsPresenter implements SavedNewsContract.Presenter {

    private final SavedNewsContract.Model model;
    private SavedNewsContract.View  view;


    public SavedNewsPresenter() {
        this.model = new SavedNewsModel();
        model.setPresenter(this);
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onViewAttached(SavedNewsContract.View view) {
     this.view = view;
     model.fetchData();
    }

    @Override
    public void onViewDetached() {
        view = null;
    }

    @Override
    public void loadSavedNews(List<News> newsList) {
        if (view != null){
            view.loadSavedNews(newsList);
        }
    }


}
