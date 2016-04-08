package com.gaadi.sfa.provider.offlinetable;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import com.gaadi.sfa.provider.base.AbstractSelection;

/**
 * Selection for the {@code offlinetable} table.
 */
public class OfflinetableSelection extends AbstractSelection<OfflinetableSelection> {
    @Override
    protected Uri baseUri() {
        return OfflinetableColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code OfflinetableCursor} object, which is positioned before the first entry, or null.
     */
    public OfflinetableCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new OfflinetableCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public OfflinetableCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code OfflinetableCursor} object, which is positioned before the first entry, or null.
     */
    public OfflinetableCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new OfflinetableCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public OfflinetableCursor query(Context context) {
        return query(context, null);
    }


    public OfflinetableSelection id(long... value) {
        addEquals("offlinetable." + OfflinetableColumns._ID, toObjectArray(value));
        return this;
    }

    public OfflinetableSelection idNot(long... value) {
        addNotEquals("offlinetable." + OfflinetableColumns._ID, toObjectArray(value));
        return this;
    }

    public OfflinetableSelection orderById(boolean desc) {
        orderBy("offlinetable." + OfflinetableColumns._ID, desc);
        return this;
    }

    public OfflinetableSelection orderById() {
        return orderById(false);
    }

    public OfflinetableSelection key(String... value) {
        addEquals(OfflinetableColumns.KEY, value);
        return this;
    }

    public OfflinetableSelection keyNot(String... value) {
        addNotEquals(OfflinetableColumns.KEY, value);
        return this;
    }

    public OfflinetableSelection keyLike(String... value) {
        addLike(OfflinetableColumns.KEY, value);
        return this;
    }

    public OfflinetableSelection keyContains(String... value) {
        addContains(OfflinetableColumns.KEY, value);
        return this;
    }

    public OfflinetableSelection keyStartsWith(String... value) {
        addStartsWith(OfflinetableColumns.KEY, value);
        return this;
    }

    public OfflinetableSelection keyEndsWith(String... value) {
        addEndsWith(OfflinetableColumns.KEY, value);
        return this;
    }

    public OfflinetableSelection orderByKey(boolean desc) {
        orderBy(OfflinetableColumns.KEY, desc);
        return this;
    }

    public OfflinetableSelection orderByKey() {
        orderBy(OfflinetableColumns.KEY, false);
        return this;
    }

    public OfflinetableSelection jsonData(String... value) {
        addEquals(OfflinetableColumns.JSON_DATA, value);
        return this;
    }

    public OfflinetableSelection jsonDataNot(String... value) {
        addNotEquals(OfflinetableColumns.JSON_DATA, value);
        return this;
    }

    public OfflinetableSelection jsonDataLike(String... value) {
        addLike(OfflinetableColumns.JSON_DATA, value);
        return this;
    }

    public OfflinetableSelection jsonDataContains(String... value) {
        addContains(OfflinetableColumns.JSON_DATA, value);
        return this;
    }

    public OfflinetableSelection jsonDataStartsWith(String... value) {
        addStartsWith(OfflinetableColumns.JSON_DATA, value);
        return this;
    }

    public OfflinetableSelection jsonDataEndsWith(String... value) {
        addEndsWith(OfflinetableColumns.JSON_DATA, value);
        return this;
    }

    public OfflinetableSelection orderByJsonData(boolean desc) {
        orderBy(OfflinetableColumns.JSON_DATA, desc);
        return this;
    }

    public OfflinetableSelection orderByJsonData() {
        orderBy(OfflinetableColumns.JSON_DATA, false);
        return this;
    }
}
