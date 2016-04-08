package com.gaadi.sfa.provider.dealertable;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.gaadi.sfa.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code dealertable} table.
 */
public class DealertableContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return DealertableColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable DealertableSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable DealertableSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Name of dealer
     */
    public DealertableContentValues putDealername(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("dealername must not be null");
        mContentValues.put(DealertableColumns.DEALERNAME, value);
        return this;
    }


    /**
     * unique id of dealer
     */
    public DealertableContentValues putDealerid(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("dealerid must not be null");
        mContentValues.put(DealertableColumns.DEALERID, value);
        return this;
    }


    public DealertableContentValues putCityid(@Nullable String value) {
        mContentValues.put(DealertableColumns.CITYID, value);
        return this;
    }

    public DealertableContentValues putCityidNull() {
        mContentValues.putNull(DealertableColumns.CITYID);
        return this;
    }

    public DealertableContentValues putAssigned(@Nullable Integer value) {
        mContentValues.put(DealertableColumns.ASSIGNED, value);
        return this;
    }

    public DealertableContentValues putAssignedNull() {
        mContentValues.putNull(DealertableColumns.ASSIGNED);
        return this;
    }

    public DealertableContentValues putMobile(@Nullable String value) {
        mContentValues.put(DealertableColumns.MOBILE, value);
        return this;
    }

    public DealertableContentValues putMobileNull() {
        mContentValues.putNull(DealertableColumns.MOBILE);
        return this;
    }

    public DealertableContentValues putLatitude(@Nullable String value) {
        mContentValues.put(DealertableColumns.LATITUDE, value);
        return this;
    }

    public DealertableContentValues putLatitudeNull() {
        mContentValues.putNull(DealertableColumns.LATITUDE);
        return this;
    }

    public DealertableContentValues putLongitude(@Nullable String value) {
        mContentValues.put(DealertableColumns.LONGITUDE, value);
        return this;
    }

    public DealertableContentValues putLongitudeNull() {
        mContentValues.putNull(DealertableColumns.LONGITUDE);
        return this;
    }

    public DealertableContentValues putArea(@Nullable String value) {
        mContentValues.put(DealertableColumns.AREA, value);
        return this;
    }

    public DealertableContentValues putAreaNull() {
        mContentValues.putNull(DealertableColumns.AREA);
        return this;
    }

    public DealertableContentValues putLogintoken(@Nullable String value) {
        mContentValues.put(DealertableColumns.LOGINTOKEN, value);
        return this;
    }

    public DealertableContentValues putLogintokenNull() {
        mContentValues.putNull(DealertableColumns.LOGINTOKEN);
        return this;
    }
}
