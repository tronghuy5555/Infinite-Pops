package com.example.sos.infinitepops.model;

/**
 * BaseModel
 *
 * @author SOS
 * @since 07/09/2018.
 */

import com.example.sos.infinitepops.callback.ModelCallBack;
import com.example.sos.infinitepops.dto.BaseResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseModel<T extends BaseResponse> {

    protected static final Retrofit RETROFIT = new Retrofit.Builder()
            .baseUrl("https://api.popjam.com/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    protected Call<T> call;
    private static final String errorMessage = "Error";
    private static final int errorCode = 404;

    protected void requestApi(final ModelCallBack callBack) {
        call.enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                if (!response.isSuccessful() || response == null) {
                    callBack.onError(errorMessage, errorCode);
                    return;
                }
                callBack.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                callBack.onError(errorMessage,errorCode);
            }
        });
    }

}
