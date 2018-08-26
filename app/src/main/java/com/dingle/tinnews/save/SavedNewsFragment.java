package com.dingle.tinnews.save;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.dingle.tinnews.R;
import com.dingle.tinnews.common.TinBasicFragment;
import com.dingle.tinnews.mvp.MvpFragment;
import com.dingle.tinnews.retrofit.response.News;
import com.dingle.tinnews.save.detail.SavedNewsDetailedFragment;

import org.w3c.dom.Text;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SavedNewsFragment extends MvpFragment<SavedNewsContract.Presenter> implements SavedNewsContract.View{

    private TextView author;
    private TextView description;
    public static SavedNewsFragment newInstance() {
        SavedNewsFragment fragment = new SavedNewsFragment();
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_saved_news, container, false);
        author = view .findViewById(R.id.author);
        description = view.findViewById(R.id.description);
        description.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tinFragmentManager.doFragmentTransaction(SavedNewsDetailedFragment.newInstance());
            }
        });
        return view;
    }

    @Override
    public SavedNewsPresenter getPresenter() {
        return new SavedNewsPresenter();
    }

    @Override
    public void loadSavedNews(List<News> newsList) {
        if(newsList != null || newsList.size() > 0){
            News news = newsList.get(newsList.size() - 1);
            author.setText(news.getAuthor());
            description.setText(news.getDescription());
        }
    }


}
