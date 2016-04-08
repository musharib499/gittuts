package com.gaadi.sfa.retrofit;


import com.gaadi.sfa.ApplicationController;
import com.gaadi.sfa.BuildConfig;
import com.gaadi.sfa.model.CityApiModel;
import com.gaadi.sfa.model.DealerApiModel;
import com.gaadi.sfa.model.BaseResponseModel;
import com.gaadi.sfa.model.DealerRootModel;
import com.gaadi.sfa.utils.AppConstants;
import com.gaadi.sfa.utils.Logger;

import org.json.JSONObject;

import retrofit.Callback;

/**
 * Created by vinodtakhar
 */
public class RetrofitRequest {

    private static final String TAG = "RetrofitRequest.java";

    private static RequestInterface requestInterface = RetrofitAdapter.getRestAdapter().create(RequestInterface.class);
    private static RequestInterfaceDev requestInterfaceDev = RetrofitAdapter.getRestAdapter().create(RequestInterfaceDev.class);

    public static void makeCityRequest(String method, JSONObject inputData, Callback<CityApiModel> cb) {
        if (BuildConfig.ENVIRONMENT.equals("DEV")) {
            requestInterfaceDev.makeCityRequest( method, new RetrofitFieldMap(ApplicationController.getInstance(), inputData).getJsonParams(), cb);
        }
        else {
            requestInterface.makeCityRequest(method, new RetrofitFieldMap(ApplicationController.getInstance(), inputData).getJsonParams(), cb);
        }
    }

    public static void getDealershipsInCity(String email,String password, Callback<DealerRootModel> cb) {
        if (BuildConfig.ENVIRONMENT.equals("DEV")) {
            requestInterfaceDev.getDealers(AppConstants.METHOD_DEALERS, BuildConfig.API_KEY, email, password, cb);
        }
        else {
//            requestInterface.getDealers(method, new RetrofitFieldMap(ApplicationController.getInstance(), null).getJsonParams(), cb);
        }
    }

    public static void requestCheckIn(String email,String password,String checkInType,String dealerId,String latitude,String logitude, Callback<BaseResponseModel> cb) {
        if (BuildConfig.ENVIRONMENT.equals("DEV")) {
            requestInterfaceDev.checkin(AppConstants.METHOD_CHECKIN, BuildConfig.API_KEY, email, password, checkInType, dealerId, latitude, logitude, cb);
        }
        else {
//            requestInterface.getDealers(method, new RetrofitFieldMap(ApplicationController.getInstance(), null).getJsonParams(), cb);
        }
    }

    public static void requestCheckOut(String email,String password,String checkInType,String dealerId,String dealerStatus,String comment,String nextFollowUp,String isJoinVisit,String reasons,String joined,String latitude,String longitude,String  visitId, Callback<BaseResponseModel> cb) {
        if (BuildConfig.ENVIRONMENT.equals("DEV")) {
            requestInterfaceDev.checkout(AppConstants.METHOD_CHECKIN, BuildConfig.API_KEY, email, password, checkInType, dealerId, dealerStatus, comment,nextFollowUp,isJoinVisit,reasons,joined,latitude,longitude,visitId ,cb);
        }
        else {
//            requestInterface.getDealers(method, new RetrofitFieldMap(ApplicationController.getInstance(), null).getJsonParams(), cb);
        }
    }

    public static void getLoginResponse(String email,String password, Callback<BaseResponseModel> cb) {
        if (BuildConfig.ENVIRONMENT.equals("DEV")) {
            requestInterfaceDev.loginUser(AppConstants.METHOD_USER_LOGIN, BuildConfig.API_KEY, email, password, cb);
        }
        else {
            requestInterfaceDev.loginUser(AppConstants.METHOD_USER_LOGIN, BuildConfig.API_KEY, email, password, cb);
        }
    }

    public static void forgotPassword(String email, Callback<BaseResponseModel> cb) {
        if (BuildConfig.ENVIRONMENT.equals("DEV")) {
            requestInterfaceDev.forgotPassword(AppConstants.METHOD_FORGOT_PASSWORD, BuildConfig.API_KEY, email, cb);
        }
        else {
            requestInterface.forgotPassword(AppConstants.METHOD_FORGOT_PASSWORD, BuildConfig.API_KEY, email, cb);
        }
    }

    public static void resetPassword(String email,String password,String verificationCode, Callback<BaseResponseModel> cb) {
        if (BuildConfig.ENVIRONMENT.equals("DEV")) {
            requestInterfaceDev.resetPassword(AppConstants.METHOD_RESET_PASSWORD, BuildConfig.API_KEY, email, password, verificationCode, cb);
        }
        else {
            requestInterface.resetPassword(AppConstants.METHOD_RESET_PASSWORD, BuildConfig.API_KEY, email, password, verificationCode, cb);
        }
    }
}