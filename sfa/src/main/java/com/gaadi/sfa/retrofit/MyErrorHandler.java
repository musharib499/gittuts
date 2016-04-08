package com.gaadi.sfa.retrofit;


import retrofit.ErrorHandler;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by ankitgarg on 29/06/15.
 */
public class MyErrorHandler implements ErrorHandler {
    @Override
    public Throwable handleError(RetrofitError cause) {
        Response r = cause.getResponse();
        if (r != null && r.getStatus() == 401) {
            return new UnauthorizedException(cause);
        }
        return cause;
    }
}
