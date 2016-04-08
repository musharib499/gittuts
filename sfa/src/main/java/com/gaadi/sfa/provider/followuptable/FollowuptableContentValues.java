package com.gaadi.sfa.provider.followuptable;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.gaadi.sfa.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code followuptable} table.
 */
public class FollowuptableContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return FollowuptableColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable FollowuptableSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable FollowuptableSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    public FollowuptableContentValues putDate(@Nullable String value) {
        mContentValues.put(FollowuptableColumns.DATE, value);
        return this;
    }

    public FollowuptableContentValues putDateNull() {
        mContentValues.putNull(FollowuptableColumns.DATE);
        return this;
    }

    public FollowuptableContentValues putComments(@Nullable String value) {
        mContentValues.put(FollowuptableColumns.COMMENTS, value);
        return this;
    }

    public FollowuptableContentValues putCommentsNull() {
        mContentValues.putNull(FollowuptableColumns.COMMENTS);
        return this;
    }

    public FollowuptableContentValues putOverdue(@Nullable Integer value) {
        mContentValues.put(FollowuptableColumns.OVERDUE, value);
        return this;
    }

    public FollowuptableContentValues putOverdueNull() {
        mContentValues.putNull(FollowuptableColumns.OVERDUE);
        return this;
    }

    public FollowuptableContentValues putDealerid(@Nullable String value) {
        mContentValues.put(FollowuptableColumns.DEALERID, value);
        return this;
    }

    public FollowuptableContentValues putDealeridNull() {
        mContentValues.putNull(FollowuptableColumns.DEALERID);
        return this;
    }
}
