package com.gaadi.sfa.provider.notificationtable;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.gaadi.sfa.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code notificationtable} table.
 */
public class NotificationtableContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return NotificationtableColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable NotificationtableSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable NotificationtableSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    public NotificationtableContentValues putNotificationId(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("notificationId must not be null");
        mContentValues.put(NotificationtableColumns.NOTIFICATION_ID, value);
        return this;
    }


    public NotificationtableContentValues putNotificationTitle(@Nullable String value) {
        mContentValues.put(NotificationtableColumns.NOTIFICATION_TITLE, value);
        return this;
    }

    public NotificationtableContentValues putNotificationTitleNull() {
        mContentValues.putNull(NotificationtableColumns.NOTIFICATION_TITLE);
        return this;
    }

    public NotificationtableContentValues putNotificationMsg(@Nullable String value) {
        mContentValues.put(NotificationtableColumns.NOTIFICATION_MSG, value);
        return this;
    }

    public NotificationtableContentValues putNotificationMsgNull() {
        mContentValues.putNull(NotificationtableColumns.NOTIFICATION_MSG);
        return this;
    }

    public NotificationtableContentValues putNotificationImage(@Nullable String value) {
        mContentValues.put(NotificationtableColumns.NOTIFICATION_IMAGE, value);
        return this;
    }

    public NotificationtableContentValues putNotificationImageNull() {
        mContentValues.putNull(NotificationtableColumns.NOTIFICATION_IMAGE);
        return this;
    }

    public NotificationtableContentValues putNotificationTime(@Nullable String value) {
        mContentValues.put(NotificationtableColumns.NOTIFICATION_TIME, value);
        return this;
    }

    public NotificationtableContentValues putNotificationTimeNull() {
        mContentValues.putNull(NotificationtableColumns.NOTIFICATION_TIME);
        return this;
    }

    public NotificationtableContentValues putTag(@Nullable String value) {
        mContentValues.put(NotificationtableColumns.TAG, value);
        return this;
    }

    public NotificationtableContentValues putTagNull() {
        mContentValues.putNull(NotificationtableColumns.TAG);
        return this;
    }

    public NotificationtableContentValues putHtmlSource(@Nullable String value) {
        mContentValues.put(NotificationtableColumns.HTML_SOURCE, value);
        return this;
    }

    public NotificationtableContentValues putHtmlSourceNull() {
        mContentValues.putNull(NotificationtableColumns.HTML_SOURCE);
        return this;
    }

    public NotificationtableContentValues putNotificationStatus(@Nullable Integer value) {
        mContentValues.put(NotificationtableColumns.NOTIFICATION_STATUS, value);
        return this;
    }

    public NotificationtableContentValues putNotificationStatusNull() {
        mContentValues.putNull(NotificationtableColumns.NOTIFICATION_STATUS);
        return this;
    }
}
