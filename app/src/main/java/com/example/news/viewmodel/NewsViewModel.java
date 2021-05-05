package com.example.news.viewmodel;


import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.news.model.Headlines;
import com.example.news.repo.NewsRepository;

public class NewsViewModel extends AndroidViewModel {

    final String API_KEY = "ed3e7aecf8094abeada85a12579cbf47";
    private NewsRepository newsRepository;
    private LiveData<Headlines> headlinesLiveData;
    String country ="in";

    public NewsViewModel(@NonNull Application application) {
        super(application);

        newsRepository = new NewsRepository();
        this.headlinesLiveData = newsRepository.getHeadLines(country, API_KEY);
    }

    public LiveData<Headlines> getArticleResponseLiveData() {
        return headlinesLiveData;
    }
}
