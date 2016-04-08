package com.gaadi.sfa.retrofit;

/**
 * Created by ankitgarg on 29/06/15.
 */
public class UnauthorizedException extends Exception {

    Throwable throwable;

    public UnauthorizedException(Throwable throwable) {
        this.throwable = throwable;
    }

    @Override
    public String getMessage() {
        return this.throwable.getMessage();
    }
}
