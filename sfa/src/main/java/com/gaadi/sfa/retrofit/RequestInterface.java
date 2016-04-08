package com.gaadi.sfa.retrofit;


import com.gaadi.sfa.model.CityApiModel;
import com.gaadi.sfa.model.DealerApiModel;
import com.gaadi.sfa.model.BaseResponseModel;
import com.gaadi.sfa.utils.AppConstants;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;
import retrofit.http.Path;

public interface RequestInterface {

    @FormUrlEncoded
    @POST("/app_launcher/{method}")
    void makeCityRequest(
            @Path("method") String method,
            @Field(AppConstants.KEY) String params,
            Callback<CityApiModel> cb);



    @FormUrlEncoded
    @POST("/app_launcher/{method}")
    void getDealers(
            @Path("method") String method,
            @Field(AppConstants.KEY) String params,
            Callback<DealerApiModel> cb);

    @FormUrlEncoded
    @POST("/api/v1/{method}")
    void loginUser(
            @Path("method") String method,
            @Field(AppConstants.API_KEY_LABEL) String key,
            @Field("email") String email,
            @Field("password") String password,
            Callback<BaseResponseModel> cb);

    @FormUrlEncoded
    @POST("/api/v1/{method}")
    void forgotPassword(
            @Path("method") String method,
            @Field(AppConstants.API_KEY_LABEL) String key,
            @Field("email") String email,
            Callback<BaseResponseModel> cb);

    @FormUrlEncoded
    @POST("/api/v1/{method}")
    void resetPassword(
            @Path("method") String method,
            @Field(AppConstants.API_KEY_LABEL) String key,
            @Field("email") String email,
            @Field("password") String password,
            @Field("otp") String verficationCode,
            Callback<BaseResponseModel> cb);

}
