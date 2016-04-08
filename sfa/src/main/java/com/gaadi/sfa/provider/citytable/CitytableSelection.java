package com.gaadi.sfa.provider.citytable;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import com.gaadi.sfa.provider.base.AbstractSelection;

/**
 * Selection for the {@code citytable} table.
 */
public class CitytableSelection extends AbstractSelection<CitytableSelection> {
    @Override
    protected Uri baseUri() {
        return CitytableColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code CitytableCursor} object, which is positioned before the first entry, or null.
     */
    public CitytableCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new CitytableCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public CitytableCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code CitytableCursor} object, which is positioned before the first entry, or null.
     */
    public CitytableCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new CitytableCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public CitytableCursor query(Context context) {
        return query(context, null);
    }


    public CitytableSelection id(long... value) {
        addEquals("citytable." + CitytableColumns._ID, toObjectArray(value));
        return this;
    }

    public CitytableSelection idNot(long... value) {
        addNotEquals("citytable." + CitytableColumns._ID, toObjectArray(value));
        return this;
    }

    public CitytableSelection orderById(boolean desc) {
        orderBy("citytable." + CitytableColumns._ID, desc);
        return this;
    }

    public CitytableSelection orderById() {
        return orderById(false);
    }

    public CitytableSelection cityname(String... value) {
        addEquals(CitytableColumns.CITYNAME, value);
        return this;
    }

    public CitytableSelection citynameNot(String... value) {
        addNotEquals(CitytableColumns.CITYNAME, value);
        return this;
    }

    public CitytableSelection citynameLike(String... value) {
        addLike(CitytableColumns.CITYNAME, value);
        return this;
    }

    public CitytableSelection citynameContains(String... value) {
        addContains(CitytableColumns.CITYNAME, value);
        return this;
    }

    public CitytableSelection citynameStartsWith(String... value) {
        addStartsWith(CitytableColumns.CITYNAME, value);
        return this;
    }

    public CitytableSelection citynameEndsWith(String... value) {
        addEndsWith(CitytableColumns.CITYNAME, value);
        return this;
    }

    public CitytableSelection orderByCityname(boolean desc) {
        orderBy(CitytableColumns.CITYNAME, desc);
        return this;
    }

    public CitytableSelection orderByCityname() {
        orderBy(CitytableColumns.CITYNAME, false);
        return this;
    }

    public CitytableSelection cityId(String... value) {
        addEquals(CitytableColumns.CITY_ID, value);
        return this;
    }

    public CitytableSelection cityIdNot(String... value) {
        addNotEquals(CitytableColumns.CITY_ID, value);
        return this;
    }

    public CitytableSelection cityIdLike(String... value) {
        addLike(CitytableColumns.CITY_ID, value);
        return this;
    }

    public CitytableSelection cityIdContains(String... value) {
        addContains(CitytableColumns.CITY_ID, value);
        return this;
    }

    public CitytableSelection cityIdStartsWith(String... value) {
        addStartsWith(CitytableColumns.CITY_ID, value);
        return this;
    }

    public CitytableSelection cityIdEndsWith(String... value) {
        addEndsWith(CitytableColumns.CITY_ID, value);
        return this;
    }

    public CitytableSelection orderByCityId(boolean desc) {
        orderBy(CitytableColumns.CITY_ID, desc);
        return this;
    }

    public CitytableSelection orderByCityId() {
        orderBy(CitytableColumns.CITY_ID, false);
        return this;
    }

    public CitytableSelection stateName(String... value) {
        addEquals(CitytableColumns.STATE_NAME, value);
        return this;
    }

    public CitytableSelection stateNameNot(String... value) {
        addNotEquals(CitytableColumns.STATE_NAME, value);
        return this;
    }

    public CitytableSelection stateNameLike(String... value) {
        addLike(CitytableColumns.STATE_NAME, value);
        return this;
    }

    public CitytableSelection stateNameContains(String... value) {
        addContains(CitytableColumns.STATE_NAME, value);
        return this;
    }

    public CitytableSelection stateNameStartsWith(String... value) {
        addStartsWith(CitytableColumns.STATE_NAME, value);
        return this;
    }

    public CitytableSelection stateNameEndsWith(String... value) {
        addEndsWith(CitytableColumns.STATE_NAME, value);
        return this;
    }

    public CitytableSelection orderByStateName(boolean desc) {
        orderBy(CitytableColumns.STATE_NAME, desc);
        return this;
    }

    public CitytableSelection orderByStateName() {
        orderBy(CitytableColumns.STATE_NAME, false);
        return this;
    }

    public CitytableSelection stateCode(String... value) {
        addEquals(CitytableColumns.STATE_CODE, value);
        return this;
    }

    public CitytableSelection stateCodeNot(String... value) {
        addNotEquals(CitytableColumns.STATE_CODE, value);
        return this;
    }

    public CitytableSelection stateCodeLike(String... value) {
        addLike(CitytableColumns.STATE_CODE, value);
        return this;
    }

    public CitytableSelection stateCodeContains(String... value) {
        addContains(CitytableColumns.STATE_CODE, value);
        return this;
    }

    public CitytableSelection stateCodeStartsWith(String... value) {
        addStartsWith(CitytableColumns.STATE_CODE, value);
        return this;
    }

    public CitytableSelection stateCodeEndsWith(String... value) {
        addEndsWith(CitytableColumns.STATE_CODE, value);
        return this;
    }

    public CitytableSelection orderByStateCode(boolean desc) {
        orderBy(CitytableColumns.STATE_CODE, desc);
        return this;
    }

    public CitytableSelection orderByStateCode() {
        orderBy(CitytableColumns.STATE_CODE, false);
        return this;
    }

    public CitytableSelection isBooking(String... value) {
        addEquals(CitytableColumns.IS_BOOKING, value);
        return this;
    }

    public CitytableSelection isBookingNot(String... value) {
        addNotEquals(CitytableColumns.IS_BOOKING, value);
        return this;
    }

    public CitytableSelection isBookingLike(String... value) {
        addLike(CitytableColumns.IS_BOOKING, value);
        return this;
    }

    public CitytableSelection isBookingContains(String... value) {
        addContains(CitytableColumns.IS_BOOKING, value);
        return this;
    }

    public CitytableSelection isBookingStartsWith(String... value) {
        addStartsWith(CitytableColumns.IS_BOOKING, value);
        return this;
    }

    public CitytableSelection isBookingEndsWith(String... value) {
        addEndsWith(CitytableColumns.IS_BOOKING, value);
        return this;
    }

    public CitytableSelection orderByIsBooking(boolean desc) {
        orderBy(CitytableColumns.IS_BOOKING, desc);
        return this;
    }

    public CitytableSelection orderByIsBooking() {
        orderBy(CitytableColumns.IS_BOOKING, false);
        return this;
    }
}
