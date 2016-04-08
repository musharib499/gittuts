package com.gaadi.sfa.provider.citytable;

import java.util.Date;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.gaadi.sfa.provider.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code citytable} table.
 */
public class CitytableCursor extends AbstractCursor implements CitytableModel {
    public CitytableCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    public long getId() {
        Long res = getLongOrNull(CitytableColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Name of city
     * Cannot be {@code null}.
     */
    @NonNull
    public String getCityname() {
        String res = getStringOrNull(CitytableColumns.CITYNAME);
        if (res == null)
            throw new NullPointerException("The value of 'cityname' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * unique id of city
     * Cannot be {@code null}.
     */
    @NonNull
    public String getCityId() {
        String res = getStringOrNull(CitytableColumns.CITY_ID);
        if (res == null)
            throw new NullPointerException("The value of 'city_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code state_name} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getStateName() {
        String res = getStringOrNull(CitytableColumns.STATE_NAME);
        return res;
    }

    /**
     * Get the {@code state_code} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getStateCode() {
        String res = getStringOrNull(CitytableColumns.STATE_CODE);
        return res;
    }

    /**
     * Get the {@code is_booking} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getIsBooking() {
        String res = getStringOrNull(CitytableColumns.IS_BOOKING);
        return res;
    }
}
