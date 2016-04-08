package com.gaadi.sfa.provider.previousvisittable;

import java.util.Date;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.gaadi.sfa.provider.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code previousvisittable} table.
 */
public class PreviousvisittableCursor extends AbstractCursor implements PreviousvisittableModel {
    public PreviousvisittableCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    public long getId() {
        Long res = getLongOrNull(PreviousvisittableColumns._ID);
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
        String res = getStringOrNull(PreviousvisittableColumns.DATE);
        return res;
    }

    /**
     * Get the {@code checkin} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getCheckin() {
        String res = getStringOrNull(PreviousvisittableColumns.CHECKIN);
        return res;
    }

    /**
     * Get the {@code checkout} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getCheckout() {
        String res = getStringOrNull(PreviousvisittableColumns.CHECKOUT);
        return res;
    }

    /**
     * Get the {@code comments} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getComments() {
        String res = getStringOrNull(PreviousvisittableColumns.COMMENTS);
        return res;
    }

    /**
     * Get the {@code dealerid} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getDealerid() {
        String res = getStringOrNull(PreviousvisittableColumns.DEALERID);
        return res;
    }
}
