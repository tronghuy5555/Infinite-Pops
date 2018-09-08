package com.example.sos.infinitepops.vp;

import com.example.sos.infinitepops.callback.ModelCallBack;
import com.example.sos.infinitepops.dto.BaseResponse;
import com.example.sos.infinitepops.dto.FeedItemResponse;
import com.example.sos.infinitepops.dto.FeedResponse;
import com.example.sos.infinitepops.model.FeedListModel;
import com.example.sos.infinitepops.model.FeedListModelMrg;

import java.util.ArrayList;
import java.util.List;

/**
 * FeedListPresenter
 *
 * @author SOS
 * @since 07/09/2018.
 */
public class FeedListPresenter implements FeedListPresenterMgr {

    private FeedListViewMrg viewMrg;
    private FeedListModelMrg modelMrg;
    private List<FeedItemResponse> items;

    public FeedListPresenter(FeedListViewMrg viewMrg) {
        this.viewMrg = viewMrg;
        this.modelMrg = new FeedListModel();
        items = new ArrayList<>();
    }

    @Override
    public void getFeedList() {
        this.modelMrg.getFeedList(new ModelCallBack<FeedResponse>() {
            @Override
            public void onResponse(FeedResponse response) {
                items.clear();
                items.addAll(response.getFeedItems());
                viewMrg.renderFeedList(items);
            }

            @Override
            public void onError(String errorMessage, int errorCode) {
                viewMrg.onError(errorMessage, errorCode);
            }
        });
    }

    @Override
    public void getMoreFeeds() {
        String lastId = items.get(items.size() - 1).getId();
        this.modelMrg.getMoreFeeds(lastId, new ModelCallBack<FeedResponse>() {
            @Override
            public void onResponse(FeedResponse response) {
                items.addAll(response.getFeedItems());
                viewMrg.renderFeedList(items);
            }

            @Override
            public void onError(String errorMessage, int errorCode) {
                viewMrg.onError(errorMessage, errorCode);
            }
        });
    }
}
