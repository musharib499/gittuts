package com.gaadi.sfa.provider.offlinetable;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.gaadi.sfa.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code offlinetable} table.
 */
public class OfflinetableContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return OfflinetableColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable OfflinetableSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable OfflinetableSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Name of Key
     */
    public OfflinetableContentValues putKey(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("key must not be null");
        mContentValues.put(OfflinetableColumns.KEY, value);
        return this;
    }


    /**
     * json of record
     */
    public OfflinetableContentValues putJsonData(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("jsonData must not be null");
        mContentValues.put(OfflinetableColumns.JSON_DATA, value);
        return this;
    }

}
