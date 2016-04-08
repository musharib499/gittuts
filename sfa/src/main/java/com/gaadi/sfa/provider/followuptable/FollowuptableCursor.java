package com.gaadi.sfa.provider.followuptable;

import java.util.Date;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.gaadi.sfa.provider.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code followuptable} table.
 */
public class FollowuptableCursor extends AbstractCursor implements FollowuptableModel {
    public FollowuptableCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    public long getId() {
        Long res = getLongOrNull(FollowuptableColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code date} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getDate() {
        String res = getStringOrNull(FollowuptableColumns.DATE);
        return res;
    }

    /**
     * Get the {@code comments} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getComments() {
        String res = getStringOrNull(FollowuptableColumns.COMMENTS);
        return res;
    }

    /**
     * Get the {@code overdue} value.
     * Can be {@code null}.
     */
    @Nullable
    public Integer getOverdue() {
        Integer res = getIntegerOrNull(FollowuptableColumns.OVERDUE);
        return res;
    }

    /**
     * Get the {@code dealerid} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getDealerid() {
        String res = getStringOrNull(FollowuptableColumns.DEALERID);
        return res;
    }
}
