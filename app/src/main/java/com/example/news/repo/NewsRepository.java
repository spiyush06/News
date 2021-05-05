package com.example.news.repo;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.news.model.Headlines;
import com.example.news.network.ApiClient;
import com.example.news.network.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsRepository {
    private static final String TAG = NewsRepository.class.getSimpleName();
    private ApiInterface apiRequest;

    public NewsRepository() {
        apiRequest = ApiClient.getInstance().getApi();
    }

    public LiveData<Headlines> getHeadLines(String query, String key) {
        final MutableLiveData<Headlines> data = new MutableLiveData<>();
        apiRequest.getHeadlines(query, key)
                .enqueue(new Callback<Headlines>() {


                    @Override
                    public void onResponse(Call<Headlines> call, Response<Headlines> response) {
                        Log.d(TAG, "onResponse response:: " + response);

                        if (response.body() != null) {
                            data.setValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<Headlines> call, Throwable t) {
                        data.setValue(null);
                    }
                });
        return data;
    }
}
