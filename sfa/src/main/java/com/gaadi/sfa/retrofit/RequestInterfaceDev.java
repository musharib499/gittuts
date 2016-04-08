package com.gaadi.sfa.retrofit;


import com.gaadi.sfa.model.BaseResponseModel;
import com.gaadi.sfa.model.CityApiModel;
import com.gaadi.sfa.model.DealerApiModel;
import com.gaadi.sfa.model.DealerRootModel;
import com.gaadi.sfa.utils.AppConstants;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

/**
 * Created by ankitgarg on 03/09/15.
 */
public interface RequestInterfaceDev {

    @FormUrlEncoded
    @POST("/api/v1/{method}")
    void makeCityRequest(
            @Path("method") String method,
            @Field(AppConstants.KEY) String params,
            Callback<CityApiModel> cb);

    @FormUrlEncoded
    @POST("/api/v1/{method}")
    void getDealers(
            @Path("method") String method,
            @Field(AppConstants.API_KEY_LABEL) String key,
            @Field("email") String email,
            @Field("password") String password,
            Callback<DealerRootModel> cb);

    @FormUrlEncoded
    @POST("/api/v1/{method}")
    void checkin(
            @Path("method") String method,
            @Field(AppConstants.API_KEY_LABEL) String key,
            @Field("email") String email,
            @Field("password") String password,
            @Field("checkinType") String checKInType,
            @Field("dealerId") String dealerId,
            @Field("latitude") String latitude,
            @Field("longitude") String longitude,
            Callback<BaseResponseModel> cb);

    @FormUrlEncoded
    @POST("/api/v1/{method}")
    void checkout(
            @Path("method") String method,
            @Field(AppConstants.API_KEY_LABEL) String key,
            @Field("email") String email,
            @Field("password") String password,
            @Field("checkinType") String checKInType,
            @Field("dealerId") String dealerId,
            @Field("dealerStatus") String dealerStatus,
            @Field("comment") String comment,
            @Field("nextFollowup") String nextFollowUp,
            @Field("isJoinVisit") String isJoinVisit,
            @Field("reasons") String reasons,
            @Field("joined") String joined,
            @Field("latitude") String latitude,
            @Field("longitude") String longitude,
            @Field("visitId") String visitId,
            Callback<BaseResponseModel> cb);

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
