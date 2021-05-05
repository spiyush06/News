package com.example.news.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.news.R;
import com.example.news.adapter.Adapter;
import com.example.news.model.Articles;
import com.example.news.viewmodel.NewsViewModel;

import java.util.ArrayList;
import java.util.List;

public class PageFragment extends Fragment {

    public static final String ARG_PAGE = "position";
    public static final String ARG_ID = "ARG_PAGE";
    public static final String COUNTRYID = "COUNTRY_ID";

    private int mPage;
    private String  mPageD, countryId;

    RecyclerView recyclerView;
    final String API_KEY = "ed3e7aecf8094abeada85a12579cbf47";
    Adapter adapter;
    List<Articles> articles = new ArrayList<>();
    NewsViewModel articleViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
        mPageD = getArguments().getString(ARG_ID);
        countryId = getArguments().getString(COUNTRYID);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new Adapter(getContext(), articles);
        recyclerView.setAdapter(adapter);

        TextView textView = (TextView) view.findViewById(R.id.title);
        textView.setText("Fragment #" + mPage);

        articleViewModel = ViewModelProviders.of(this).get(NewsViewModel.class);

        retrieveJson(countryId, API_KEY);
        return view;
    }

    public void retrieveJson(String country, String apiKey){
        articleViewModel.getArticleResponseLiveData(country).observe(this, articleResponse -> {
            if (articleResponse != null) {
                List<Articles> aaaa = articleResponse.getArticles();
                articles.addAll(aaaa);
                adapter.notifyDataSetChanged();
            }
        });
    }
}