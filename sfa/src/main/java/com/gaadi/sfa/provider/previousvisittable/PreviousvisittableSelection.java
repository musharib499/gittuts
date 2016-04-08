package com.gaadi.sfa.provider.previousvisittable;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import com.gaadi.sfa.provider.base.AbstractSelection;

/**
 * Selection for the {@code previousvisittable} table.
 */
public class PreviousvisittableSelection extends AbstractSelection<PreviousvisittableSelection> {
    @Override
    protected Uri baseUri() {
        return PreviousvisittableColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code PreviousvisittableCursor} object, which is positioned before the first entry, or null.
     */
    public PreviousvisittableCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new PreviousvisittableCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public PreviousvisittableCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code PreviousvisittableCursor} object, which is positioned before the first entry, or null.
     */
    public PreviousvisittableCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new PreviousvisittableCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public PreviousvisittableCursor query(Context context) {
        return query(context, null);
    }


    public PreviousvisittableSelection id(long... value) {
        addEquals("previousvisittable." + PreviousvisittableColumns._ID, toObjectArray(value));
        return this;
    }

    public PreviousvisittableSelection idNot(long... value) {
        addNotEquals("previousvisittable." + PreviousvisittableColumns._ID, toObjectArray(value));
        return this;
    }

    public PreviousvisittableSelection orderById(boolean desc) {
        orderBy("previousvisittable." + PreviousvisittableColumns._ID, desc);
        return this;
    }

    public PreviousvisittableSelection orderById() {
        return orderById(false);
    }

    public PreviousvisittableSelection date(String... value) {
        addEquals(PreviousvisittableColumns.DATE, value);
        return this;
    }

    public PreviousvisittableSelection dateNot(String... value) {
        addNotEquals(PreviousvisittableColumns.DATE, value);
        return this;
    }

    public PreviousvisittableSelection dateLike(String... value) {
        addLike(PreviousvisittableColumns.DATE, value);
        return this;
    }

    public PreviousvisittableSelection dateContains(String... value) {
        addContains(PreviousvisittableColumns.DATE, value);
        return this;
    }

    public PreviousvisittableSelection dateStartsWith(String... value) {
        addStartsWith(PreviousvisittableColumns.DATE, value);
        return this;
    }

    public PreviousvisittableSelection dateEndsWith(String... value) {
        addEndsWith(PreviousvisittableColumns.DATE, value);
        return this;
    }

    public PreviousvisittableSelection orderByDate(boolean desc) {
        orderBy(PreviousvisittableColumns.DATE, desc);
        return this;
    }

    public PreviousvisittableSelection orderByDate() {
        orderBy(PreviousvisittableColumns.DATE, false);
        return this;
    }

    public PreviousvisittableSelection checkin(String... value) {
        addEquals(PreviousvisittableColumns.CHECKIN, value);
        return this;
    }

    public PreviousvisittableSelection checkinNot(String... value) {
        addNotEquals(PreviousvisittableColumns.CHECKIN, value);
        return this;
    }

    public PreviousvisittableSelection checkinLike(String... value) {
        addLike(PreviousvisittableColumns.CHECKIN, value);
        return this;
    }

    public PreviousvisittableSelection checkinContains(String... value) {
        addContains(PreviousvisittableColumns.CHECKIN, value);
        return this;
    }

    public PreviousvisittableSelection checkinStartsWith(String... value) {
        addStartsWith(PreviousvisittableColumns.CHECKIN, value);
        return this;
    }

    public PreviousvisittableSelection checkinEndsWith(String... value) {
        addEndsWith(PreviousvisittableColumns.CHECKIN, value);
        return this;
    }

    public PreviousvisittableSelection orderByCheckin(boolean desc) {
        orderBy(PreviousvisittableColumns.CHECKIN, desc);
        return this;
    }

    public PreviousvisittableSelection orderByCheckin() {
        orderBy(PreviousvisittableColumns.CHECKIN, false);
        return this;
    }

    public PreviousvisittableSelection checkout(String... value) {
        addEquals(PreviousvisittableColumns.CHECKOUT, value);
        return this;
    }

    public PreviousvisittableSelection checkoutNot(String... value) {
        addNotEquals(PreviousvisittableColumns.CHECKOUT, value);
        return this;
    }

    public PreviousvisittableSelection checkoutLike(String... value) {
        addLike(PreviousvisittableColumns.CHECKOUT, value);
        return this;
    }

    public PreviousvisittableSelection checkoutContains(String... value) {
        addContains(PreviousvisittableColumns.CHECKOUT, value);
        return this;
    }

    public PreviousvisittableSelection checkoutStartsWith(String... value) {
        addStartsWith(PreviousvisittableColumns.CHECKOUT, value);
        return this;
    }

    public PreviousvisittableSelection checkoutEndsWith(String... value) {
        addEndsWith(PreviousvisittableColumns.CHECKOUT, value);
        return this;
    }

    public PreviousvisittableSelection orderByCheckout(boolean desc) {
        orderBy(PreviousvisittableColumns.CHECKOUT, desc);
        return this;
    }

    public PreviousvisittableSelection orderByCheckout() {
        orderBy(PreviousvisittableColumns.CHECKOUT, false);
        return this;
    }

    public PreviousvisittableSelection comments(String... value) {
        addEquals(PreviousvisittableColumns.COMMENTS, value);
        return this;
    }

    public PreviousvisittableSelection commentsNot(String... value) {
        addNotEquals(PreviousvisittableColumns.COMMENTS, value);
        return this;
    }

    public PreviousvisittableSelection commentsLike(String... value) {
        addLike(PreviousvisittableColumns.COMMENTS, value);
        return this;
    }

    public PreviousvisittableSelection commentsContains(String... value) {
        addContains(PreviousvisittableColumns.COMMENTS, value);
        return this;
    }

    public PreviousvisittableSelection commentsStartsWith(String... value) {
        addStartsWith(PreviousvisittableColumns.COMMENTS, value);
        return this;
    }

    public PreviousvisittableSelection commentsEndsWith(String... value) {
        addEndsWith(PreviousvisittableColumns.COMMENTS, value);
        return this;
    }

    public PreviousvisittableSelection orderByComments(boolean desc) {
        orderBy(PreviousvisittableColumns.COMMENTS, desc);
        return this;
    }

    public PreviousvisittableSelection orderByComments() {
        orderBy(PreviousvisittableColumns.COMMENTS, false);
        return this;
    }

    public PreviousvisittableSelection dealerid(String... value) {
        addEquals(PreviousvisittableColumns.DEALERID, value);
        return this;
    }

    public PreviousvisittableSelection dealeridNot(String... value) {
        addNotEquals(PreviousvisittableColumns.DEALERID, value);
        return this;
    }

    public PreviousvisittableSelection dealeridLike(String... value) {
        addLike(PreviousvisittableColumns.DEALERID, value);
        return this;
    }

    public PreviousvisittableSelection dealeridContains(String... value) {
        addContains(PreviousvisittableColumns.DEALERID, value);
        return this;
    }

    public PreviousvisittableSelection dealeridStartsWith(String... value) {
        addStartsWith(PreviousvisittableColumns.DEALERID, value);
        return this;
    }

    public PreviousvisittableSelection dealeridEndsWith(String... value) {
        addEndsWith(PreviousvisittableColumns.DEALERID, value);
        return this;
    }

    public PreviousvisittableSelection orderByDealerid(boolean desc) {
        orderBy(PreviousvisittableColumns.DEALERID, desc);
        return this;
    }

    public PreviousvisittableSelection orderByDealerid() {
        orderBy(PreviousvisittableColumns.DEALERID, false);
        return this;
    }
}
