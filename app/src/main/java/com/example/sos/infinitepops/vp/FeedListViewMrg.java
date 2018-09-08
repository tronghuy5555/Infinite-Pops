package com.example.sos.infinitepops.vp;

import com.example.sos.infinitepops.callback.OnError;
import com.example.sos.infinitepops.dto.FeedItemResponse;

import java.util.List;

/**
 * FeedListViewMrg
 *
 * @author SOS
 * @since 07/09/2018.
 */
public interface FeedListViewMrg extends OnError{

    void renderFeedList(List<FeedItemResponse> data);
}
