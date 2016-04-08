package com.gaadi.sfa.retrofit;


import com.gaadi.sfa.BuildConfig;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.ConnectionPool;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import retrofit.RestAdapter;


public class RetrofitAdapter {

    private static float backOffMultiplier = 1.8f;
    private static long interval = 5000; // in seconds
    private static Callback responseCallback = new Callback() {
        @Override
        public void onFailure(Request request, IOException e) {

        }

        @Override
        public void onResponse(Response response) throws IOException {

        }
    };

    public static RestAdapter getRestAdapter() {
        String serviceUrl = BuildConfig.REST_HOST;
       // String urlBase = serviceUrl.substring(0, serviceUrl.lastIndexOf("/"));
        //String urlPath = serviceUrl.substring(serviceUrl.lastIndexOf("/")+1);

        final OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setConnectTimeout(50, TimeUnit.SECONDS);
        okHttpClient.setWriteTimeout(50, TimeUnit.SECONDS);
        okHttpClient.setReadTimeout(50, TimeUnit.SECONDS);
        okHttpClient.setRetryOnConnectionFailure(true);
        okHttpClient.setConnectionPool(new ConnectionPool(4, 5000));
        /*okHttpClient.interceptors().add(new Interceptor() {
            @Override
            public Response intercept(final Chain chain) throws IOException {

                Response response = chain.proceed(chain.request());

                try {
                    AnalyticsDataDispatcher.sendEvent(getClass().getSimpleName(), chain.request().urlString(), String.valueOf(response.code()), response.networkResponse().toString());
                } catch (Exception e) {
                    Crashlytics.logException(e.getCause());
                }

                Logger.e(AppConstants.TAG, "response : " + response.toString());

                int tryCount = 0;

                if (!response.isSuccessful()) {
                    while (tryCount < 3) {

                        tryCount++;

                        // retry the request
                        try {
                            Logger.e(AppConstants.TAG, "retrying request");
                            response = chain.proceed(chain.request());

                            try {
                                AnalyticsDataDispatcher.sendEvent(getClass().getSimpleName(), chain.request().urlString(), String.valueOf(response.code()), response.networkResponse().toString());
                            } catch (Exception e) {
                                Crashlytics.logException(e.getCause());
                            }

                            Logger.e(AppConstants.TAG, "response: " + response.toString());

                        } catch (IOException e) {
                            Logger.e(AppConstants.TAG, "exception : " + e.getMessage());

                        }

                    }
                }

                return response;

            }
        });*/


        return new RestAdapter.Builder()
                .setEndpoint(serviceUrl)
                .setErrorHandler(new MyErrorHandler())
                .setClient(new CustomOKHttpClient(okHttpClient))
                .setLogLevel(!BuildConfig.DEBUG ? RestAdapter.LogLevel.FULL : RestAdapter.LogLevel.FULL)
                .build();
    }

    public static RestAdapter getRestAdapterMockable() {
        String serviceUrl = "https://demo4630405.mockable.io";
        // String urlBase = serviceUrl.substring(0, serviceUrl.lastIndexOf("/"));
        //String urlPath = serviceUrl.substring(serviceUrl.lastIndexOf("/")+1);

        final OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setConnectTimeout(50, TimeUnit.SECONDS);
        okHttpClient.setWriteTimeout(50, TimeUnit.SECONDS);
        okHttpClient.setReadTimeout(50, TimeUnit.SECONDS);
        okHttpClient.setRetryOnConnectionFailure(true);
        okHttpClient.setConnectionPool(new ConnectionPool(4, 5000));
        /*okHttpClient.interceptors().add(new Interceptor() {
            @Override
            public Response intercept(final Chain chain) throws IOException {

                Response response = chain.proceed(chain.request());

                try {
                    AnalyticsDataDispatcher.sendEvent(getClass().getSimpleName(), chain.request().urlString(), String.valueOf(response.code()), response.networkResponse().toString());
                } catch (Exception e) {
                    Crashlytics.logException(e.getCause());
                }

                Logger.e(AppConstants.TAG, "response : " + response.toString());

                int tryCount = 0;

                if (!response.isSuccessful()) {
                    while (tryCount < 3) {

                        tryCount++;

                        // retry the request
                        try {
                            Logger.e(AppConstants.TAG, "retrying request");
                            response = chain.proceed(chain.request());

                            try {
                                AnalyticsDataDispatcher.sendEvent(getClass().getSimpleName(), chain.request().urlString(), String.valueOf(response.code()), response.networkResponse().toString());
                            } catch (Exception e) {
                                Crashlytics.logException(e.getCause());
                            }

                            Logger.e(AppConstants.TAG, "response: " + response.toString());

                        } catch (IOException e) {
                            Logger.e(AppConstants.TAG, "exception : " + e.getMessage());

                        }

                    }
                }

                return response;

            }
        });*/


        return new RestAdapter.Builder()
                .setEndpoint(serviceUrl)
                .setErrorHandler(new MyErrorHandler())
                .setClient(new CustomOKHttpClient(okHttpClient))
                .setLogLevel(!BuildConfig.DEBUG ? RestAdapter.LogLevel.FULL : RestAdapter.LogLevel.FULL)
                .build();
    }

}
