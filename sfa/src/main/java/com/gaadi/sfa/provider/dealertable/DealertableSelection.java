package com.gaadi.sfa.provider.dealertable;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import com.gaadi.sfa.provider.base.AbstractSelection;

/**
 * Selection for the {@code dealertable} table.
 */
public class DealertableSelection extends AbstractSelection<DealertableSelection> {
    @Override
    protected Uri baseUri() {
        return DealertableColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code DealertableCursor} object, which is positioned before the first entry, or null.
     */
    public DealertableCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new DealertableCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public DealertableCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code DealertableCursor} object, which is positioned before the first entry, or null.
     */
    public DealertableCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new DealertableCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public DealertableCursor query(Context context) {
        return query(context, null);
    }


    public DealertableSelection id(long... value) {
        addEquals("dealertable." + DealertableColumns._ID, toObjectArray(value));
        return this;
    }

    public DealertableSelection idNot(long... value) {
        addNotEquals("dealertable." + DealertableColumns._ID, toObjectArray(value));
        return this;
    }

    public DealertableSelection orderById(boolean desc) {
        orderBy("dealertable." + DealertableColumns._ID, desc);
        return this;
    }

    public DealertableSelection orderById() {
        return orderById(false);
    }

    public DealertableSelection dealername(String... value) {
        addEquals(DealertableColumns.DEALERNAME, value);
        return this;
    }

    public DealertableSelection dealernameNot(String... value) {
        addNotEquals(DealertableColumns.DEALERNAME, value);
        return this;
    }

    public DealertableSelection dealernameLike(String... value) {
        addLike(DealertableColumns.DEALERNAME, value);
        return this;
    }

    public DealertableSelection dealernameContains(String... value) {
        addContains(DealertableColumns.DEALERNAME, value);
        return this;
    }

    public DealertableSelection dealernameStartsWith(String... value) {
        addStartsWith(DealertableColumns.DEALERNAME, value);
        return this;
    }

    public DealertableSelection dealernameEndsWith(String... value) {
        addEndsWith(DealertableColumns.DEALERNAME, value);
        return this;
    }

    public DealertableSelection orderByDealername(boolean desc) {
        orderBy(DealertableColumns.DEALERNAME, desc);
        return this;
    }

    public DealertableSelection orderByDealername() {
        orderBy(DealertableColumns.DEALERNAME, false);
        return this;
    }

    public DealertableSelection dealerid(String... value) {
        addEquals(DealertableColumns.DEALERID, value);
        return this;
    }

    public DealertableSelection dealeridNot(String... value) {
        addNotEquals(DealertableColumns.DEALERID, value);
        return this;
    }

    public DealertableSelection dealeridLike(String... value) {
        addLike(DealertableColumns.DEALERID, value);
        return this;
    }

    public DealertableSelection dealeridContains(String... value) {
        addContains(DealertableColumns.DEALERID, value);
        return this;
    }

    public DealertableSelection dealeridStartsWith(String... value) {
        addStartsWith(DealertableColumns.DEALERID, value);
        return this;
    }

    public DealertableSelection dealeridEndsWith(String... value) {
        addEndsWith(DealertableColumns.DEALERID, value);
        return this;
    }

    public DealertableSelection orderByDealerid(boolean desc) {
        orderBy(DealertableColumns.DEALERID, desc);
        return this;
    }

    public DealertableSelection orderByDealerid() {
        orderBy(DealertableColumns.DEALERID, false);
        return this;
    }

    public DealertableSelection cityid(String... value) {
        addEquals(DealertableColumns.CITYID, value);
        return this;
    }

    public DealertableSelection cityidNot(String... value) {
        addNotEquals(DealertableColumns.CITYID, value);
        return this;
    }

    public DealertableSelection cityidLike(String... value) {
        addLike(DealertableColumns.CITYID, value);
        return this;
    }

    public DealertableSelection cityidContains(String... value) {
        addContains(DealertableColumns.CITYID, value);
        return this;
    }

    public DealertableSelection cityidStartsWith(String... value) {
        addStartsWith(DealertableColumns.CITYID, value);
        return this;
    }

    public DealertableSelection cityidEndsWith(String... value) {
        addEndsWith(DealertableColumns.CITYID, value);
        return this;
    }

    public DealertableSelection orderByCityid(boolean desc) {
        orderBy(DealertableColumns.CITYID, desc);
        return this;
    }

    public DealertableSelection orderByCityid() {
        orderBy(DealertableColumns.CITYID, false);
        return this;
    }

    public DealertableSelection assigned(Integer... value) {
        addEquals(DealertableColumns.ASSIGNED, value);
        return this;
    }

    public DealertableSelection assignedNot(Integer... value) {
        addNotEquals(DealertableColumns.ASSIGNED, value);
        return this;
    }

    public DealertableSelection assignedGt(int value) {
        addGreaterThan(DealertableColumns.ASSIGNED, value);
        return this;
    }

    public DealertableSelection assignedGtEq(int value) {
        addGreaterThanOrEquals(DealertableColumns.ASSIGNED, value);
        return this;
    }

    public DealertableSelection assignedLt(int value) {
        addLessThan(DealertableColumns.ASSIGNED, value);
        return this;
    }

    public DealertableSelection assignedLtEq(int value) {
        addLessThanOrEquals(DealertableColumns.ASSIGNED, value);
        return this;
    }

    public DealertableSelection orderByAssigned(boolean desc) {
        orderBy(DealertableColumns.ASSIGNED, desc);
        return this;
    }

    public DealertableSelection orderByAssigned() {
        orderBy(DealertableColumns.ASSIGNED, false);
        return this;
    }

    public DealertableSelection mobile(String... value) {
        addEquals(DealertableColumns.MOBILE, value);
        return this;
    }

    public DealertableSelection mobileNot(String... value) {
        addNotEquals(DealertableColumns.MOBILE, value);
        return this;
    }

    public DealertableSelection mobileLike(String... value) {
        addLike(DealertableColumns.MOBILE, value);
        return this;
    }

    public DealertableSelection mobileContains(String... value) {
        addContains(DealertableColumns.MOBILE, value);
        return this;
    }

    public DealertableSelection mobileStartsWith(String... value) {
        addStartsWith(DealertableColumns.MOBILE, value);
        return this;
    }

    public DealertableSelection mobileEndsWith(String... value) {
        addEndsWith(DealertableColumns.MOBILE, value);
        return this;
    }

    public DealertableSelection orderByMobile(boolean desc) {
        orderBy(DealertableColumns.MOBILE, desc);
        return this;
    }

    public DealertableSelection orderByMobile() {
        orderBy(DealertableColumns.MOBILE, false);
        return this;
    }

    public DealertableSelection latitude(String... value) {
        addEquals(DealertableColumns.LATITUDE, value);
        return this;
    }

    public DealertableSelection latitudeNot(String... value) {
        addNotEquals(DealertableColumns.LATITUDE, value);
        return this;
    }

    public DealertableSelection latitudeLike(String... value) {
        addLike(DealertableColumns.LATITUDE, value);
        return this;
    }

    public DealertableSelection latitudeContains(String... value) {
        addContains(DealertableColumns.LATITUDE, value);
        return this;
    }

    public DealertableSelection latitudeStartsWith(String... value) {
        addStartsWith(DealertableColumns.LATITUDE, value);
        return this;
    }

    public DealertableSelection latitudeEndsWith(String... value) {
        addEndsWith(DealertableColumns.LATITUDE, value);
        return this;
    }

    public DealertableSelection orderByLatitude(boolean desc) {
        orderBy(DealertableColumns.LATITUDE, desc);
        return this;
    }

    public DealertableSelection orderByLatitude() {
        orderBy(DealertableColumns.LATITUDE, false);
        return this;
    }

    public DealertableSelection longitude(String... value) {
        addEquals(DealertableColumns.LONGITUDE, value);
        return this;
    }

    public DealertableSelection longitudeNot(String... value) {
        addNotEquals(DealertableColumns.LONGITUDE, value);
        return this;
    }

    public DealertableSelection longitudeLike(String... value) {
        addLike(DealertableColumns.LONGITUDE, value);
        return this;
    }

    public DealertableSelection longitudeContains(String... value) {
        addContains(DealertableColumns.LONGITUDE, value);
        return this;
    }

    public DealertableSelection longitudeStartsWith(String... value) {
        addStartsWith(DealertableColumns.LONGITUDE, value);
        return this;
    }

    public DealertableSelection longitudeEndsWith(String... value) {
        addEndsWith(DealertableColumns.LONGITUDE, value);
        return this;
    }

    public DealertableSelection orderByLongitude(boolean desc) {
        orderBy(DealertableColumns.LONGITUDE, desc);
        return this;
    }

    public DealertableSelection orderByLongitude() {
        orderBy(DealertableColumns.LONGITUDE, false);
        return this;
    }

    public DealertableSelection area(String... value) {
        addEquals(DealertableColumns.AREA, value);
        return this;
    }

    public DealertableSelection areaNot(String... value) {
        addNotEquals(DealertableColumns.AREA, value);
        return this;
    }

    public DealertableSelection areaLike(String... value) {
        addLike(DealertableColumns.AREA, value);
        return this;
    }

    public DealertableSelection areaContains(String... value) {
        addContains(DealertableColumns.AREA, value);
        return this;
    }

    public DealertableSelection areaStartsWith(String... value) {
        addStartsWith(DealertableColumns.AREA, value);
        return this;
    }

    public DealertableSelection areaEndsWith(String... value) {
        addEndsWith(DealertableColumns.AREA, value);
        return this;
    }

    public DealertableSelection orderByArea(boolean desc) {
        orderBy(DealertableColumns.AREA, desc);
        return this;
    }

    public DealertableSelection orderByArea() {
        orderBy(DealertableColumns.AREA, false);
        return this;
    }

    public DealertableSelection logintoken(String... value) {
        addEquals(DealertableColumns.LOGINTOKEN, value);
        return this;
    }

    public DealertableSelection logintokenNot(String... value) {
        addNotEquals(DealertableColumns.LOGINTOKEN, value);
        return this;
    }

    public DealertableSelection logintokenLike(String... value) {
        addLike(DealertableColumns.LOGINTOKEN, value);
        return this;
    }

    public DealertableSelection logintokenContains(String... value) {
        addContains(DealertableColumns.LOGINTOKEN, value);
        return this;
    }

    public DealertableSelection logintokenStartsWith(String... value) {
        addStartsWith(DealertableColumns.LOGINTOKEN, value);
        return this;
    }

    public DealertableSelection logintokenEndsWith(String... value) {
        addEndsWith(DealertableColumns.LOGINTOKEN, value);
        return this;
    }

    public DealertableSelection orderByLogintoken(boolean desc) {
        orderBy(DealertableColumns.LOGINTOKEN, desc);
        return this;
    }

    public DealertableSelection orderByLogintoken() {
        orderBy(DealertableColumns.LOGINTOKEN, false);
        return this;
    }
}
