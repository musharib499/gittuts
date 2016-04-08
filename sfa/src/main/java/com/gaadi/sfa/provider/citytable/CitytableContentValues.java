package com.gaadi.sfa.provider.citytable;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.gaadi.sfa.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code citytable} table.
 */
public class CitytableContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return CitytableColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable CitytableSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable CitytableSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Name of city
     */
    public CitytableContentValues putCityname(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("cityname must not be null");
        mContentValues.put(CitytableColumns.CITYNAME, value);
        return this;
    }


    /**
     * unique id of city
     */
    public CitytableContentValues putCityId(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("cityId must not be null");
        mContentValues.put(CitytableColumns.CITY_ID, value);
        return this;
    }


    public CitytableContentValues putStateName(@Nullable String value) {
        mContentValues.put(CitytableColumns.STATE_NAME, value);
        return this;
    }

    public CitytableContentValues putStateNameNull() {
        mContentValues.putNull(CitytableColumns.STATE_NAME);
        return this;
    }

    public CitytableContentValues putStateCode(@Nullable String value) {
        mContentValues.put(CitytableColumns.STATE_CODE, value);
        return this;
    }

    public CitytableContentValues putStateCodeNull() {
        mContentValues.putNull(CitytableColumns.STATE_CODE);
        return this;
    }

    public CitytableContentValues putIsBooking(@Nullable String value) {
        mContentValues.put(CitytableColumns.IS_BOOKING, value);
        return this;
    }

    public CitytableContentValues putIsBookingNull() {
        mContentValues.putNull(CitytableColumns.IS_BOOKING);
        return this;
    }
}
