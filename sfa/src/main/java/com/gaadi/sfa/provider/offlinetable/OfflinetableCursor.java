package com.gaadi.sfa.provider.offlinetable;

import java.util.Date;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.gaadi.sfa.provider.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code offlinetable} table.
 */
public class OfflinetableCursor extends AbstractCursor implements OfflinetableModel {
    public OfflinetableCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    public long getId() {
        Long res = getLongOrNull(OfflinetableColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Name of Key
     * Cannot be {@code null}.
     */
    @NonNull
    public String getKey() {
        String res = getStringOrNull(OfflinetableColumns.KEY);
        if (res == null)
            throw new NullPointerException("The value of 'key' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * json of record
     * Cannot be {@code null}.
     */
    @NonNull
    public String getJsonData() {
        String res = getStringOrNull(OfflinetableColumns.JSON_DATA);
        if (res == null)
            throw new NullPointerException("The value of 'json_data' in the database was null, which is not allowed according to the model definition");
        return res;
    }
}
