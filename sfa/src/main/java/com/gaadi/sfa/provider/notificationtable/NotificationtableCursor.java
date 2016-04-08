package com.gaadi.sfa.provider.notificationtable;

import java.util.Date;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.gaadi.sfa.provider.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code notificationtable} table.
 */
public class NotificationtableCursor extends AbstractCursor implements NotificationtableModel {
    public NotificationtableCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    public long getId() {
        Long res = getLongOrNull(NotificationtableColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code notification_id} value.
     * Cannot be {@code null}.
     */
    @NonNull
    public String getNotificationId() {
        String res = getStringOrNull(NotificationtableColumns.NOTIFICATION_ID);
        if (res == null)
            throw new NullPointerException("The value of 'notification_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code notification_title} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getNotificationTitle() {
        String res = getStringOrNull(NotificationtableColumns.NOTIFICATION_TITLE);
        return res;
    }

    /**
     * Get the {@code notification_msg} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getNotificationMsg() {
        String res = getStringOrNull(NotificationtableColumns.NOTIFICATION_MSG);
        return res;
    }

    /**
     * Get the {@code notification_image} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getNotificationImage() {
        String res = getStringOrNull(NotificationtableColumns.NOTIFICATION_IMAGE);
        return res;
    }

    /**
     * Get the {@code notification_time} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getNotificationTime() {
        String res = getStringOrNull(NotificationtableColumns.NOTIFICATION_TIME);
        return res;
    }

    /**
     * Get the {@code tag} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getTag() {
        String res = getStringOrNull(NotificationtableColumns.TAG);
        return res;
    }

    /**
     * Get the {@code html_source} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getHtmlSource() {
        String res = getStringOrNull(NotificationtableColumns.HTML_SOURCE);
        return res;
    }

    /**
     * Get the {@code notification_status} value.
     * Can be {@code null}.
     */
    @Nullable
    public Integer getNotificationStatus() {
        Integer res = getIntegerOrNull(NotificationtableColumns.NOTIFICATION_STATUS);
        return res;
    }
}
