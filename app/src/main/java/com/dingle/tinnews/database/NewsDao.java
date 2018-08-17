package com.dingle.tinnews.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;

import com.dingle.tinnews.retrofit.response.News;
@Dao
public interface NewsDao {
    @Insert
    void insertNews(News news);
}
