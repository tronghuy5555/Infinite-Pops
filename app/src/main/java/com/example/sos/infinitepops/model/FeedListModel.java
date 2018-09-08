package com.example.sos.infinitepops.model;

import com.example.sos.infinitepops.callback.ModelCallBack;
import com.example.sos.infinitepops.dto.BaseResponse;
import com.example.sos.infinitepops.dto.FeedResponse;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * BaseModel
 *
 * @author SOS
 * @since 07/09/2018.
 */
public class FeedListModel extends BaseModel implements FeedListModelMrg{

    private interface Service {

        @GET("users/2e009fcf-d63c-4a3f-92f4-e847e2d5eee8/homeFeed")
        Call<FeedResponse> getFeedList();

        @GET("users/2e009fcf-d63c-4a3f-92f4-e847e2d5eee8/homeFeed")
        Call<FeedResponse> getMoreFeed(@Query("lastId") String lastId);
    }

    @Override
    public void getFeedList(ModelCallBack modelCallBack) {
        Service service  = RETROFIT.create(Service.class);
        call = service.getFeedList();
        requestApi(modelCallBack);
    }

    @Override
    public void getMoreFeeds(String lastId, ModelCallBack modelCallBack) {
        Service service  = RETROFIT.create(Service.class);
        call = service.getMoreFeed(lastId);
        requestApi(modelCallBack);
    }
}
