package com.dingle.tinnews.tin;

import com.dingle.tinnews.profile.CountryEvent;
import com.dingle.tinnews.retrofit.response.News;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

public class TinPresenter implements TinContract.Presenter {

    private TinContract.View view;
    private static final String DEFAULT_COUNTRY = "us";
    private TinContract.Model model;


    public TinPresenter() {
        this.model = new TinModel();
        this.model.setPresenter(this);
    }

    @Override
    public void onCreate() {
        EventBus.getDefault().register(this);
    }

    @Override
    public void onDestroy() {
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(CountryEvent countryEvent){
        if(this.view != null){
            this.model.fetchData(countryEvent.country);
        }
    }

    @Override
    public void onViewAttached(TinContract.View view) {
        this.view = view;
        this.model.fetchData(DEFAULT_COUNTRY);
    }

    @Override
    public void onViewDetached() {
        this.view = null;
    }

    @Override
    public void saveFavoriteNews(News news) {
        model.saveFavoriteViews(news);
    }

    @Override
    public void showNewsCard(List<News> newsList) {
        if (this.view != null){
            view.showNewsCard(newsList);
        }
    }

    @Override
    public void onError() {
        if(view != null) view.onError();
    }
}
