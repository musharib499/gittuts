package com.gaadi.sfa.provider.dealertable;

import java.util.Date;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.gaadi.sfa.provider.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code dealertable} table.
 */
public class DealertableCursor extends AbstractCursor implements DealertableModel {
    public DealertableCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    public long getId() {
        Long res = getLongOrNull(DealertableColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Name of dealer
     * Cannot be {@code null}.
     */
    @NonNull
    public String getDealername() {
        String res = getStringOrNull(DealertableColumns.DEALERNAME);
        if (res == null)
            throw new NullPointerException("The value of 'dealername' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * unique id of dealer
     * Cannot be {@code null}.
     */
    @NonNull
    public String getDealerid() {
        String res = getStringOrNull(DealertableColumns.DEALERID);
        if (res == null)
            throw new NullPointerException("The value of 'dealerid' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code cityid} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getCityid() {
        String res = getStringOrNull(DealertableColumns.CITYID);
        return res;
    }

    /**
     * Get the {@code assigned} value.
     * Can be {@code null}.
     */
    @Nullable
    public Integer getAssigned() {
        Integer res = getIntegerOrNull(DealertableColumns.ASSIGNED);
        return res;
    }

    /**
     * Get the {@code mobile} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getMobile() {
        String res = getStringOrNull(DealertableColumns.MOBILE);
        return res;
    }

    /**
     * Get the {@code latitude} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getLatitude() {
        String res = getStringOrNull(DealertableColumns.LATITUDE);
        return res;
    }

    /**
     * Get the {@code longitude} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getLongitude() {
        String res = getStringOrNull(DealertableColumns.LONGITUDE);
        return res;
    }

    /**
     * Get the {@code area} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getArea() {
        String res = getStringOrNull(DealertableColumns.AREA);
        return res;
    }

    /**
     * Get the {@code logintoken} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getLogintoken() {
        String res = getStringOrNull(DealertableColumns.LOGINTOKEN);
        return res;
    }
}
