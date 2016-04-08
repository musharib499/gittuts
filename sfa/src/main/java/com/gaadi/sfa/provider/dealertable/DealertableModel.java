package com.gaadi.sfa.provider.dealertable;

import com.gaadi.sfa.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * to store dealers information
 */
public interface DealertableModel extends BaseModel {

    /**
     * Name of dealer
     * Cannot be {@code null}.
     */
    @NonNull
    String getDealername();

    /**
     * unique id of dealer
     * Cannot be {@code null}.
     */
    @NonNull
    String getDealerid();

    /**
     * Get the {@code cityid} value.
     * Can be {@code null}.
     */
    @Nullable
    String getCityid();

    /**
     * Get the {@code assigned} value.
     * Can be {@code null}.
     */
    @Nullable
    Integer getAssigned();

    /**
     * Get the {@code mobile} value.
     * Can be {@code null}.
     */
    @Nullable
    String getMobile();

    /**
     * Get the {@code latitude} value.
     * Can be {@code null}.
     */
    @Nullable
    String getLatitude();

    /**
     * Get the {@code longitude} value.
     * Can be {@code null}.
     */
    @Nullable
    String getLongitude();

    /**
     * Get the {@code area} value.
     * Can be {@code null}.
     */
    @Nullable
    String getArea();

    /**
     * Get the {@code logintoken} value.
     * Can be {@code null}.
     */
    @Nullable
    String getLogintoken();
}
