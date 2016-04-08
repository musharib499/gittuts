package com.gaadi.sfa.provider.notificationtable;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import com.gaadi.sfa.provider.base.AbstractSelection;

/**
 * Selection for the {@code notificationtable} table.
 */
public class NotificationtableSelection extends AbstractSelection<NotificationtableSelection> {
    @Override
    protected Uri baseUri() {
        return NotificationtableColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code NotificationtableCursor} object, which is positioned before the first entry, or null.
     */
    public NotificationtableCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new NotificationtableCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public NotificationtableCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code NotificationtableCursor} object, which is positioned before the first entry, or null.
     */
    public NotificationtableCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new NotificationtableCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public NotificationtableCursor query(Context context) {
        return query(context, null);
    }


    public NotificationtableSelection id(long... value) {
        addEquals("notificationtable." + NotificationtableColumns._ID, toObjectArray(value));
        return this;
    }

    public NotificationtableSelection idNot(long... value) {
        addNotEquals("notificationtable." + NotificationtableColumns._ID, toObjectArray(value));
        return this;
    }

    public NotificationtableSelection orderById(boolean desc) {
        orderBy("notificationtable." + NotificationtableColumns._ID, desc);
        return this;
    }

    public NotificationtableSelection orderById() {
        return orderById(false);
    }

    public NotificationtableSelection notificationId(String... value) {
        addEquals(NotificationtableColumns.NOTIFICATION_ID, value);
        return this;
    }

    public NotificationtableSelection notificationIdNot(String... value) {
        addNotEquals(NotificationtableColumns.NOTIFICATION_ID, value);
        return this;
    }

    public NotificationtableSelection notificationIdLike(String... value) {
        addLike(NotificationtableColumns.NOTIFICATION_ID, value);
        return this;
    }

    public NotificationtableSelection notificationIdContains(String... value) {
        addContains(NotificationtableColumns.NOTIFICATION_ID, value);
        return this;
    }

    public NotificationtableSelection notificationIdStartsWith(String... value) {
        addStartsWith(NotificationtableColumns.NOTIFICATION_ID, value);
        return this;
    }

    public NotificationtableSelection notificationIdEndsWith(String... value) {
        addEndsWith(NotificationtableColumns.NOTIFICATION_ID, value);
        return this;
    }

    public NotificationtableSelection orderByNotificationId(boolean desc) {
        orderBy(NotificationtableColumns.NOTIFICATION_ID, desc);
        return this;
    }

    public NotificationtableSelection orderByNotificationId() {
        orderBy(NotificationtableColumns.NOTIFICATION_ID, false);
        return this;
    }

    public NotificationtableSelection notificationTitle(String... value) {
        addEquals(NotificationtableColumns.NOTIFICATION_TITLE, value);
        return this;
    }

    public NotificationtableSelection notificationTitleNot(String... value) {
        addNotEquals(NotificationtableColumns.NOTIFICATION_TITLE, value);
        return this;
    }

    public NotificationtableSelection notificationTitleLike(String... value) {
        addLike(NotificationtableColumns.NOTIFICATION_TITLE, value);
        return this;
    }

    public NotificationtableSelection notificationTitleContains(String... value) {
        addContains(NotificationtableColumns.NOTIFICATION_TITLE, value);
        return this;
    }

    public NotificationtableSelection notificationTitleStartsWith(String... value) {
        addStartsWith(NotificationtableColumns.NOTIFICATION_TITLE, value);
        return this;
    }

    public NotificationtableSelection notificationTitleEndsWith(String... value) {
        addEndsWith(NotificationtableColumns.NOTIFICATION_TITLE, value);
        return this;
    }

    public NotificationtableSelection orderByNotificationTitle(boolean desc) {
        orderBy(NotificationtableColumns.NOTIFICATION_TITLE, desc);
        return this;
    }

    public NotificationtableSelection orderByNotificationTitle() {
        orderBy(NotificationtableColumns.NOTIFICATION_TITLE, false);
        return this;
    }

    public NotificationtableSelection notificationMsg(String... value) {
        addEquals(NotificationtableColumns.NOTIFICATION_MSG, value);
        return this;
    }

    public NotificationtableSelection notificationMsgNot(String... value) {
        addNotEquals(NotificationtableColumns.NOTIFICATION_MSG, value);
        return this;
    }

    public NotificationtableSelection notificationMsgLike(String... value) {
        addLike(NotificationtableColumns.NOTIFICATION_MSG, value);
        return this;
    }

    public NotificationtableSelection notificationMsgContains(String... value) {
        addContains(NotificationtableColumns.NOTIFICATION_MSG, value);
        return this;
    }

    public NotificationtableSelection notificationMsgStartsWith(String... value) {
        addStartsWith(NotificationtableColumns.NOTIFICATION_MSG, value);
        return this;
    }

    public NotificationtableSelection notificationMsgEndsWith(String... value) {
        addEndsWith(NotificationtableColumns.NOTIFICATION_MSG, value);
        return this;
    }

    public NotificationtableSelection orderByNotificationMsg(boolean desc) {
        orderBy(NotificationtableColumns.NOTIFICATION_MSG, desc);
        return this;
    }

    public NotificationtableSelection orderByNotificationMsg() {
        orderBy(NotificationtableColumns.NOTIFICATION_MSG, false);
        return this;
    }

    public NotificationtableSelection notificationImage(String... value) {
        addEquals(NotificationtableColumns.NOTIFICATION_IMAGE, value);
        return this;
    }

    public NotificationtableSelection notificationImageNot(String... value) {
        addNotEquals(NotificationtableColumns.NOTIFICATION_IMAGE, value);
        return this;
    }

    public NotificationtableSelection notificationImageLike(String... value) {
        addLike(NotificationtableColumns.NOTIFICATION_IMAGE, value);
        return this;
    }

    public NotificationtableSelection notificationImageContains(String... value) {
        addContains(NotificationtableColumns.NOTIFICATION_IMAGE, value);
        return this;
    }

    public NotificationtableSelection notificationImageStartsWith(String... value) {
        addStartsWith(NotificationtableColumns.NOTIFICATION_IMAGE, value);
        return this;
    }

    public NotificationtableSelection notificationImageEndsWith(String... value) {
        addEndsWith(NotificationtableColumns.NOTIFICATION_IMAGE, value);
        return this;
    }

    public NotificationtableSelection orderByNotificationImage(boolean desc) {
        orderBy(NotificationtableColumns.NOTIFICATION_IMAGE, desc);
        return this;
    }

    public NotificationtableSelection orderByNotificationImage() {
        orderBy(NotificationtableColumns.NOTIFICATION_IMAGE, false);
        return this;
    }

    public NotificationtableSelection notificationTime(String... value) {
        addEquals(NotificationtableColumns.NOTIFICATION_TIME, value);
        return this;
    }

    public NotificationtableSelection notificationTimeNot(String... value) {
        addNotEquals(NotificationtableColumns.NOTIFICATION_TIME, value);
        return this;
    }

    public NotificationtableSelection notificationTimeLike(String... value) {
        addLike(NotificationtableColumns.NOTIFICATION_TIME, value);
        return this;
    }

    public NotificationtableSelection notificationTimeContains(String... value) {
        addContains(NotificationtableColumns.NOTIFICATION_TIME, value);
        return this;
    }

    public NotificationtableSelection notificationTimeStartsWith(String... value) {
        addStartsWith(NotificationtableColumns.NOTIFICATION_TIME, value);
        return this;
    }

    public NotificationtableSelection notificationTimeEndsWith(String... value) {
        addEndsWith(NotificationtableColumns.NOTIFICATION_TIME, value);
        return this;
    }

    public NotificationtableSelection orderByNotificationTime(boolean desc) {
        orderBy(NotificationtableColumns.NOTIFICATION_TIME, desc);
        return this;
    }

    public NotificationtableSelection orderByNotificationTime() {
        orderBy(NotificationtableColumns.NOTIFICATION_TIME, false);
        return this;
    }

    public NotificationtableSelection tag(String... value) {
        addEquals(NotificationtableColumns.TAG, value);
        return this;
    }

    public NotificationtableSelection tagNot(String... value) {
        addNotEquals(NotificationtableColumns.TAG, value);
        return this;
    }

    public NotificationtableSelection tagLike(String... value) {
        addLike(NotificationtableColumns.TAG, value);
        return this;
    }

    public NotificationtableSelection tagContains(String... value) {
        addContains(NotificationtableColumns.TAG, value);
        return this;
    }

    public NotificationtableSelection tagStartsWith(String... value) {
        addStartsWith(NotificationtableColumns.TAG, value);
        return this;
    }

    public NotificationtableSelection tagEndsWith(String... value) {
        addEndsWith(NotificationtableColumns.TAG, value);
        return this;
    }

    public NotificationtableSelection orderByTag(boolean desc) {
        orderBy(NotificationtableColumns.TAG, desc);
        return this;
    }

    public NotificationtableSelection orderByTag() {
        orderBy(NotificationtableColumns.TAG, false);
        return this;
    }

    public NotificationtableSelection htmlSource(String... value) {
        addEquals(NotificationtableColumns.HTML_SOURCE, value);
        return this;
    }

    public NotificationtableSelection htmlSourceNot(String... value) {
        addNotEquals(NotificationtableColumns.HTML_SOURCE, value);
        return this;
    }

    public NotificationtableSelection htmlSourceLike(String... value) {
        addLike(NotificationtableColumns.HTML_SOURCE, value);
        return this;
    }

    public NotificationtableSelection htmlSourceContains(String... value) {
        addContains(NotificationtableColumns.HTML_SOURCE, value);
        return this;
    }

    public NotificationtableSelection htmlSourceStartsWith(String... value) {
        addStartsWith(NotificationtableColumns.HTML_SOURCE, value);
        return this;
    }

    public NotificationtableSelection htmlSourceEndsWith(String... value) {
        addEndsWith(NotificationtableColumns.HTML_SOURCE, value);
        return this;
    }

    public NotificationtableSelection orderByHtmlSource(boolean desc) {
        orderBy(NotificationtableColumns.HTML_SOURCE, desc);
        return this;
    }

    public NotificationtableSelection orderByHtmlSource() {
        orderBy(NotificationtableColumns.HTML_SOURCE, false);
        return this;
    }

    public NotificationtableSelection notificationStatus(Integer... value) {
        addEquals(NotificationtableColumns.NOTIFICATION_STATUS, value);
        return this;
    }

    public NotificationtableSelection notificationStatusNot(Integer... value) {
        addNotEquals(NotificationtableColumns.NOTIFICATION_STATUS, value);
        return this;
    }

    public NotificationtableSelection notificationStatusGt(int value) {
        addGreaterThan(NotificationtableColumns.NOTIFICATION_STATUS, value);
        return this;
    }

    public NotificationtableSelection notificationStatusGtEq(int value) {
        addGreaterThanOrEquals(NotificationtableColumns.NOTIFICATION_STATUS, value);
        return this;
    }

    public NotificationtableSelection notificationStatusLt(int value) {
        addLessThan(NotificationtableColumns.NOTIFICATION_STATUS, value);
        return this;
    }

    public NotificationtableSelection notificationStatusLtEq(int value) {
        addLessThanOrEquals(NotificationtableColumns.NOTIFICATION_STATUS, value);
        return this;
    }

    public NotificationtableSelection orderByNotificationStatus(boolean desc) {
        orderBy(NotificationtableColumns.NOTIFICATION_STATUS, desc);
        return this;
    }

    public NotificationtableSelection orderByNotificationStatus() {
        orderBy(NotificationtableColumns.NOTIFICATION_STATUS, false);
        return this;
    }
}
