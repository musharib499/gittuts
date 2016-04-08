package com.gaadi.sfa.provider.followuptable;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import com.gaadi.sfa.provider.base.AbstractSelection;

/**
 * Selection for the {@code followuptable} table.
 */
public class FollowuptableSelection extends AbstractSelection<FollowuptableSelection> {
    @Override
    protected Uri baseUri() {
        return FollowuptableColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code FollowuptableCursor} object, which is positioned before the first entry, or null.
     */
    public FollowuptableCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new FollowuptableCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public FollowuptableCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code FollowuptableCursor} object, which is positioned before the first entry, or null.
     */
    public FollowuptableCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new FollowuptableCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public FollowuptableCursor query(Context context) {
        return query(context, null);
    }


    public FollowuptableSelection id(long... value) {
        addEquals("followuptable." + FollowuptableColumns._ID, toObjectArray(value));
        return this;
    }

    public FollowuptableSelection idNot(long... value) {
        addNotEquals("followuptable." + FollowuptableColumns._ID, toObjectArray(value));
        return this;
    }

    public FollowuptableSelection orderById(boolean desc) {
        orderBy("followuptable." + FollowuptableColumns._ID, desc);
        return this;
    }

    public FollowuptableSelection orderById() {
        return orderById(false);
    }

    public FollowuptableSelection date(String... value) {
        addEquals(FollowuptableColumns.DATE, value);
        return this;
    }

    public FollowuptableSelection dateNot(String... value) {
        addNotEquals(FollowuptableColumns.DATE, value);
        return this;
    }

    public FollowuptableSelection dateLike(String... value) {
        addLike(FollowuptableColumns.DATE, value);
        return this;
    }

    public FollowuptableSelection dateContains(String... value) {
        addContains(FollowuptableColumns.DATE, value);
        return this;
    }

    public FollowuptableSelection dateStartsWith(String... value) {
        addStartsWith(FollowuptableColumns.DATE, value);
        return this;
    }

    public FollowuptableSelection dateEndsWith(String... value) {
        addEndsWith(FollowuptableColumns.DATE, value);
        return this;
    }

    public FollowuptableSelection orderByDate(boolean desc) {
        orderBy(FollowuptableColumns.DATE, desc);
        return this;
    }

    public FollowuptableSelection orderByDate() {
        orderBy(FollowuptableColumns.DATE, false);
        return this;
    }

    public FollowuptableSelection comments(String... value) {
        addEquals(FollowuptableColumns.COMMENTS, value);
        return this;
    }

    public FollowuptableSelection commentsNot(String... value) {
        addNotEquals(FollowuptableColumns.COMMENTS, value);
        return this;
    }

    public FollowuptableSelection commentsLike(String... value) {
        addLike(FollowuptableColumns.COMMENTS, value);
        return this;
    }

    public FollowuptableSelection commentsContains(String... value) {
        addContains(FollowuptableColumns.COMMENTS, value);
        return this;
    }

    public FollowuptableSelection commentsStartsWith(String... value) {
        addStartsWith(FollowuptableColumns.COMMENTS, value);
        return this;
    }

    public FollowuptableSelection commentsEndsWith(String... value) {
        addEndsWith(FollowuptableColumns.COMMENTS, value);
        return this;
    }

    public FollowuptableSelection orderByComments(boolean desc) {
        orderBy(FollowuptableColumns.COMMENTS, desc);
        return this;
    }

    public FollowuptableSelection orderByComments() {
        orderBy(FollowuptableColumns.COMMENTS, false);
        return this;
    }

    public FollowuptableSelection overdue(Integer... value) {
        addEquals(FollowuptableColumns.OVERDUE, value);
        return this;
    }

    public FollowuptableSelection overdueNot(Integer... value) {
        addNotEquals(FollowuptableColumns.OVERDUE, value);
        return this;
    }

    public FollowuptableSelection overdueGt(int value) {
        addGreaterThan(FollowuptableColumns.OVERDUE, value);
        return this;
    }

    public FollowuptableSelection overdueGtEq(int value) {
        addGreaterThanOrEquals(FollowuptableColumns.OVERDUE, value);
        return this;
    }

    public FollowuptableSelection overdueLt(int value) {
        addLessThan(FollowuptableColumns.OVERDUE, value);
        return this;
    }

    public FollowuptableSelection overdueLtEq(int value) {
        addLessThanOrEquals(FollowuptableColumns.OVERDUE, value);
        return this;
    }

    public FollowuptableSelection orderByOverdue(boolean desc) {
        orderBy(FollowuptableColumns.OVERDUE, desc);
        return this;
    }

    public FollowuptableSelection orderByOverdue() {
        orderBy(FollowuptableColumns.OVERDUE, false);
        return this;
    }

    public FollowuptableSelection dealerid(String... value) {
        addEquals(FollowuptableColumns.DEALERID, value);
        return this;
    }

    public FollowuptableSelection dealeridNot(String... value) {
        addNotEquals(FollowuptableColumns.DEALERID, value);
        return this;
    }

    public FollowuptableSelection dealeridLike(String... value) {
        addLike(FollowuptableColumns.DEALERID, value);
        return this;
    }

    public FollowuptableSelection dealeridContains(String... value) {
        addContains(FollowuptableColumns.DEALERID, value);
        return this;
    }

    public FollowuptableSelection dealeridStartsWith(String... value) {
        addStartsWith(FollowuptableColumns.DEALERID, value);
        return this;
    }

    public FollowuptableSelection dealeridEndsWith(String... value) {
        addEndsWith(FollowuptableColumns.DEALERID, value);
        return this;
    }

    public FollowuptableSelection orderByDealerid(boolean desc) {
        orderBy(FollowuptableColumns.DEALERID, desc);
        return this;
    }

    public FollowuptableSelection orderByDealerid() {
        orderBy(FollowuptableColumns.DEALERID, false);
        return this;
    }
}
