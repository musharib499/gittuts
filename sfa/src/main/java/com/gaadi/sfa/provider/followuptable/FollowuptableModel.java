package com.gaadi.sfa.provider.followuptable;

import com.gaadi.sfa.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * to store dealers information
 */
public interface FollowuptableModel extends BaseModel {

    /**
     * Get the {@code date} value.
     * Can be {@code null}.
     */
    @Nullable
    String getDate();

    /**
     * Get the {@code comments} value.
     * Can be {@code null}.
     */
    @Nullable
    String getComments();

    /**
     * Get the {@code overdue} value.
     * Can be {@code null}.
     */
    @Nullable
    Integer getOverdue();

    /**
     * Get the {@code dealerid} value.
     * Can be {@code null}.
     */
    @Nullable
    String getDealerid();
}
