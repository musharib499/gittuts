package com.gaadi.sfa.provider.notificationtable;

import com.gaadi.sfa.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * to make available notifications offline
 */
public interface NotificationtableModel extends BaseModel {

    /**
     * Get the {@code notification_id} value.
     * Cannot be {@code null}.
     */
    @NonNull
    String getNotificationId();

    /**
     * Get the {@code notification_title} value.
     * Can be {@code null}.
     */
    @Nullable
    String getNotificationTitle();

    /**
     * Get the {@code notification_msg} value.
     * Can be {@code null}.
     */
    @Nullable
    String getNotificationMsg();

    /**
     * Get the {@code notification_image} value.
     * Can be {@code null}.
     */
    @Nullable
    String getNotificationImage();

    /**
     * Get the {@code notification_time} value.
     * Can be {@code null}.
     */
    @Nullable
    String getNotificationTime();

    /**
     * Get the {@code tag} value.
     * Can be {@code null}.
     */
    @Nullable
    String getTag();

    /**
     * Get the {@code html_source} value.
     * Can be {@code null}.
     */
    @Nullable
    String getHtmlSource();

    /**
     * Get the {@code notification_status} value.
     * Can be {@code null}.
     */
    @Nullable
    Integer getNotificationStatus();
}
