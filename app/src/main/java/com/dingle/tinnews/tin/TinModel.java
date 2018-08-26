package com.dingle.tinnews.tin;

import com.dingle.tinnews.TinApplication;
import com.dingle.tinnews.database.AppDatabase;
import com.dingle.tinnews.retrofit.NewsRequestApi;
import com.dingle.tinnews.retrofit.RetrofitClient;
import com.dingle.tinnews.retrofit.response.News;

import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class TinModel implements TinContract.Model {
    private TinContract.Presenter presenter;
    private final NewsRequestApi newsRequestApi;
    private final AppDatabase db;

    @Override
    public void saveFavoriteViews(News news) {
        Completable.fromAction(() -> db.newsDao().insertNews(news)).
                subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(() ->{
        }, error -> {
                    presenter.onError();
        });
    }

    @Override
    public void setPresenter(   TinContract.Presenter presenter) {
        this.presenter = presenter;
    }

    public TinModel() {
        newsRequestApi = RetrofitClient.getInstance().create(NewsRequestApi.class);
        db = TinApplication.getDataBase();
    }

    @Override
    public void fetchData() {
        newsRequestApi.getNewsByCountry("us")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .filter(baseResponse -> baseResponse != null && baseResponse.articles != null)
                .subscribe(baseResponse -> {
                    presenter.showNewsCard(baseResponse.articles);
                });
    }
}
