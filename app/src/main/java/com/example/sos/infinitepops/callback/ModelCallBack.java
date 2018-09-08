package com.example.sos.infinitepops.callback;

import com.example.sos.infinitepops.dto.BaseResponse;

/**
 * ModelCallBack
 *
 * @author SOS
 * @since 07/09/2018.
 */
public interface ModelCallBack<T extends BaseResponse> {
    void onResponse(T response);
    void onError(String errorMessage, int errorCode);
}
