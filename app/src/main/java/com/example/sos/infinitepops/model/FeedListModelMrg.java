package com.example.sos.infinitepops.model;

import com.example.sos.infinitepops.callback.ModelCallBack;

/**
 * FeedListModelMrg
 *
 * @author SOS
 * @since 07/09/2018.
 */
public interface FeedListModelMrg {

    /**
     * Get feed list
     * @param modelCallBack
     */
    void getFeedList(ModelCallBack modelCallBack);

    /**
     * Get more feeds
     * @param lastId
     * @param modelCallBack
     */
    void getMoreFeeds(String lastId, ModelCallBack modelCallBack);
}
