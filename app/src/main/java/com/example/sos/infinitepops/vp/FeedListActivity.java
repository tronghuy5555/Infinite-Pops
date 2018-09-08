package com.example.sos.infinitepops.vp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.sos.infinitepops.R;
import com.example.sos.infinitepops.adapter.BaseRecycleViewAdapter;
import com.example.sos.infinitepops.callback.OnEventListener;
import com.example.sos.infinitepops.dto.FeedItemResponse;

import java.util.ArrayList;
import java.util.List;

public class FeedListActivity extends AppCompatActivity implements FeedListViewMrg, OnEventListener{

    private RecyclerView rvFeeds;
    private BaseRecycleViewAdapter feedAdapter;
    private FeedListPresenterMgr feedListPresenterMgr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_list);
        initView();
        initData();
    }

    private void initView() {
        rvFeeds = findViewById(R.id.rvFeeds);
        rvFeeds.setHasFixedSize(true);
        rvFeeds.setLayoutManager(new LinearLayoutManager(this));
        rvFeeds.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    private void initData() {
        feedListPresenterMgr = new FeedListPresenter(this);
        feedListPresenterMgr.getFeedList();
    }

    @Override
    public void renderFeedList(List<FeedItemResponse> data) {
        if (feedAdapter == null) {
            feedAdapter = new BaseRecycleViewAdapter(data);
            feedAdapter.setEventListener(this);
            rvFeeds.setAdapter(feedAdapter);
        } else {
            feedAdapter.setData(data);
        }
    }

    @Override
    public void onError(String message, int code) {
        Toast.makeText(this, message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoadMore(int position) {
        feedListPresenterMgr.getMoreFeeds();
    }
}
