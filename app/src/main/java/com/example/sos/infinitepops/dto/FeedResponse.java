package com.example.sos.infinitepops.dto;

import java.util.List;

/**
 * FeedResponse
 *
 * @author SOS
 * @since 07/09/2018.
 */
public class FeedResponse extends BaseResponse{

    private List<FeedItemResponse> feedItems;

    public List<FeedItemResponse> getFeedItems() {
        return feedItems;
    }

    public void setFeedItems(List<FeedItemResponse> feedItems) {
        this.feedItems = feedItems;
    }
}
