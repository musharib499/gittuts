package com.gaadi.sfa.retrofit;

import com.gaadi.sfa.model.CityApiModel;
import com.gaadi.sfa.model.DealerApiModel;
import com.gaadi.sfa.utils.AppConstants;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

/**
 * Created by vinodtakhar on 10/2/16.
 */
public interface RequestInterfaceMockable {

    @GET("{/method}")
    void makeCityRequest(
            @Path("method") String method,
            Callback<CityApiModel> cb);

    @GET("/{method}")
    void getDealers(
            @Path("method") String method,
            Callback<DealerApiModel> cb);

}
