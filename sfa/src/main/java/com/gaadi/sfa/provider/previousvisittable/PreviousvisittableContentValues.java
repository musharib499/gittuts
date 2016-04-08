package com.gaadi.sfa.provider.previousvisittable;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.gaadi.sfa.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code previousvisittable} table.
 */
public class PreviousvisittableContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return PreviousvisittableColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable PreviousvisittableSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable PreviousvisittableSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    public PreviousvisittableContentValues putDate(@Nullable String value) {
        mContentValues.put(PreviousvisittableColumns.DATE, value);
        return this;
    }

    public PreviousvisittableContentValues putDateNull() {
        mContentValues.putNull(PreviousvisittableColumns.DATE);
        return this;
    }

    public PreviousvisittableContentValues putCheckin(@Nullable String value) {
        mContentValues.put(PreviousvisittableColumns.CHECKIN, value);
        return this;
    }

    public PreviousvisittableContentValues putCheckinNull() {
        mContentValues.putNull(PreviousvisittableColumns.CHECKIN);
        return this;
    }

    public PreviousvisittableContentValues putCheckout(@Nullable String value) {
        mContentValues.put(PreviousvisittableColumns.CHECKOUT, value);
        return this;
    }

    public PreviousvisittableContentValues putCheckoutNull() {
        mContentValues.putNull(PreviousvisittableColumns.CHECKOUT);
        return this;
    }

    public PreviousvisittableContentValues putComments(@Nullable String value) {
        mContentValues.put(PreviousvisittableColumns.COMMENTS, value);
        return this;
    }

    public PreviousvisittableContentValues putCommentsNull() {
        mContentValues.putNull(PreviousvisittableColumns.COMMENTS);
        return this;
    }

    public PreviousvisittableContentValues putDealerid(@Nullable String value) {
        mContentValues.put(PreviousvisittableColumns.DEALERID, value);
        return this;
    }

    public PreviousvisittableContentValues putDealeridNull() {
        mContentValues.putNull(PreviousvisittableColumns.DEALERID);
        return this;
    }
}
