package com.dingle.tinnews.save;

import com.dingle.tinnews.TinApplication;
import com.dingle.tinnews.database.AppDatabase;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class SavedNewsModel implements SavedNewsContract.Model {
    private SavedNewsContract.Presenter presenter;

    private final AppDatabase db;

    SavedNewsModel(){
        db = TinApplication.getDataBase();
    }

    @Override
    public void setPresenter(SavedNewsContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void fetchData() {
        db.newsDao().getAll().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(
                news ->{
                    presenter.loadSavedNews(news);
                },err ->{

                },() ->{
                    System.out.println("error");
                }
        );
    }
}
