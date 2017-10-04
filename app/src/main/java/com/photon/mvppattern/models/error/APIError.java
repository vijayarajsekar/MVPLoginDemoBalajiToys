package com.photon.mvppattern.models.error;

/**
 * Created by balaji_sh on 6/3/2017.
 */
public class APIError {
    private int status;
    private String message;

    public APIError() {
    }

    public APIError(final int status, final String message) {
        this.status = status;
        this.message = message;
    }

    public int status() {
        return status;
    }

    public String message() {
        return message;
    }

    @Override
    public String toString() {
        return "APIError{" +
                "status=" + status +
                ", message='" + message + '\'' +
                '}';
    }
}
