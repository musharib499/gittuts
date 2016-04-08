package com.gaadi.sfa.provider.previousvisittable;

import com.gaadi.sfa.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * to store dealers information
 */
public interface PreviousvisittableModel extends BaseModel {

    /**
     * Get the {@code date} value.
     * Can be {@code null}.
     */
    @Nullable
    String getDate();

    /**
     * Get the {@code checkin} value.
     * Can be {@code null}.
     */
    @Nullable
    String getCheckin();

    /**
     * Get the {@code checkout} value.
     * Can be {@code null}.
     */
    @Nullable
    String getCheckout();

    /**
     * Get the {@code comments} value.
     * Can be {@code null}.
     */
    @Nullable
    String getComments();

    /**
     * Get the {@code dealerid} value.
     * Can be {@code null}.
     */
    @Nullable
    String getDealerid();
}
