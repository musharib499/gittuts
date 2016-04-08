package com.gaadi.sfa.provider.citytable;

import com.gaadi.sfa.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * to make available city names offline
 */
public interface CitytableModel extends BaseModel {

    /**
     * Name of city
     * Cannot be {@code null}.
     */
    @NonNull
    String getCityname();

    /**
     * unique id of city
     * Cannot be {@code null}.
     */
    @NonNull
    String getCityId();

    /**
     * Get the {@code state_name} value.
     * Can be {@code null}.
     */
    @Nullable
    String getStateName();

    /**
     * Get the {@code state_code} value.
     * Can be {@code null}.
     */
    @Nullable
    String getStateCode();

    /**
     * Get the {@code is_booking} value.
     * Can be {@code null}.
     */
    @Nullable
    String getIsBooking();
}
