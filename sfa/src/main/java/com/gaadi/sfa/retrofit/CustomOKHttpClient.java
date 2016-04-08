package com.gaadi.sfa.retrofit;

import com.gaadi.sfa.utils.Logger;
import com.squareup.okhttp.OkHttpClient;

import java.io.IOException;

import retrofit.client.OkClient;
import retrofit.client.Request;
import retrofit.client.Response;

/**
 * Created by ankitgarg on 21/10/15.
 */
public class CustomOKHttpClient extends OkClient {

    private static final String TAG = "CustomOkHttpClient.java";
    private OkHttpClient okHttpClient;

    public CustomOKHttpClient() {

    }

    public CustomOKHttpClient(OkHttpClient okHttpClient) {
        super(okHttpClient);
        this.okHttpClient = okHttpClient;
    }

    @Override
    public Response execute(Request request) throws IOException {
        Response response = super.execute(request);

        try {
//            AnalyticsDataDispatcher.sendEvent(getClass().getSimpleName(), request.getUrl(), String.valueOf(response.getStatus()), response.getReason());
        } catch (Exception e) {
//            Crashlytics.logException(e.getCause());
        }

        Logger.e(TAG, "response : " + response.toString());

        int tryCount = 0;

        return response;
    }
}
