package com.example.sos.infinitepops.dto;

import java.io.Serializable;

/**
 * BaseResponse
 *
 * @author SOS
 * @since 07/09/2018.
 */
public class BaseResponse implements Serializable {
    private String errorMessage;

    private int errorCode;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}
