package com.gaadi.sfa.provider;

import java.util.Arrays;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.util.Log;

import com.gaadi.sfa.BuildConfig;
import com.gaadi.sfa.provider.base.BaseContentProvider;
import com.gaadi.sfa.provider.citytable.CitytableColumns;
import com.gaadi.sfa.provider.dealertable.DealertableColumns;
import com.gaadi.sfa.provider.followuptable.FollowuptableColumns;
import com.gaadi.sfa.provider.notificationtable.NotificationtableColumns;
import com.gaadi.sfa.provider.offlinetable.OfflinetableColumns;
import com.gaadi.sfa.provider.previousvisittable.PreviousvisittableColumns;

public class SfaContentProvider extends BaseContentProvider {
    private static final String TAG = SfaContentProvider.class.getSimpleName();

    private static final boolean DEBUG = BuildConfig.DEBUG;

    private static final String TYPE_CURSOR_ITEM = "vnd.android.cursor.item/";
    private static final String TYPE_CURSOR_DIR = "vnd.android.cursor.dir/";

    public static final String AUTHORITY = "com.gaadi.sfa.provider";
    public static final String CONTENT_URI_BASE = "content://" + AUTHORITY;

    private static final int URI_TYPE_CITYTABLE = 0;
    private static final int URI_TYPE_CITYTABLE_ID = 1;

    private static final int URI_TYPE_DEALERTABLE = 2;
    private static final int URI_TYPE_DEALERTABLE_ID = 3;

    private static final int URI_TYPE_FOLLOWUPTABLE = 4;
    private static final int URI_TYPE_FOLLOWUPTABLE_ID = 5;

    private static final int URI_TYPE_NOTIFICATIONTABLE = 6;
    private static final int URI_TYPE_NOTIFICATIONTABLE_ID = 7;

    private static final int URI_TYPE_OFFLINETABLE = 8;
    private static final int URI_TYPE_OFFLINETABLE_ID = 9;

    private static final int URI_TYPE_PREVIOUSVISITTABLE = 10;
    private static final int URI_TYPE_PREVIOUSVISITTABLE_ID = 11;



    private static final UriMatcher URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        URI_MATCHER.addURI(AUTHORITY, CitytableColumns.TABLE_NAME, URI_TYPE_CITYTABLE);
        URI_MATCHER.addURI(AUTHORITY, CitytableColumns.TABLE_NAME + "/#", URI_TYPE_CITYTABLE_ID);
        URI_MATCHER.addURI(AUTHORITY, DealertableColumns.TABLE_NAME, URI_TYPE_DEALERTABLE);
        URI_MATCHER.addURI(AUTHORITY, DealertableColumns.TABLE_NAME + "/#", URI_TYPE_DEALERTABLE_ID);
        URI_MATCHER.addURI(AUTHORITY, FollowuptableColumns.TABLE_NAME, URI_TYPE_FOLLOWUPTABLE);
        URI_MATCHER.addURI(AUTHORITY, FollowuptableColumns.TABLE_NAME + "/#", URI_TYPE_FOLLOWUPTABLE_ID);
        URI_MATCHER.addURI(AUTHORITY, NotificationtableColumns.TABLE_NAME, URI_TYPE_NOTIFICATIONTABLE);
        URI_MATCHER.addURI(AUTHORITY, NotificationtableColumns.TABLE_NAME + "/#", URI_TYPE_NOTIFICATIONTABLE_ID);
        URI_MATCHER.addURI(AUTHORITY, OfflinetableColumns.TABLE_NAME, URI_TYPE_OFFLINETABLE);
        URI_MATCHER.addURI(AUTHORITY, OfflinetableColumns.TABLE_NAME + "/#", URI_TYPE_OFFLINETABLE_ID);
        URI_MATCHER.addURI(AUTHORITY, PreviousvisittableColumns.TABLE_NAME, URI_TYPE_PREVIOUSVISITTABLE);
        URI_MATCHER.addURI(AUTHORITY, PreviousvisittableColumns.TABLE_NAME + "/#", URI_TYPE_PREVIOUSVISITTABLE_ID);
    }

    @Override
    protected SQLiteOpenHelper createSqLiteOpenHelper() {
        return SfaDb.getInstance(getContext());
    }

    @Override
    protected boolean hasDebug() {
        return DEBUG;
    }

    @Override
    public String getType(Uri uri) {
        int match = URI_MATCHER.match(uri);
        switch (match) {
            case URI_TYPE_CITYTABLE:
                return TYPE_CURSOR_DIR + CitytableColumns.TABLE_NAME;
            case URI_TYPE_CITYTABLE_ID:
                return TYPE_CURSOR_ITEM + CitytableColumns.TABLE_NAME;

            case URI_TYPE_DEALERTABLE:
                return TYPE_CURSOR_DIR + DealertableColumns.TABLE_NAME;
            case URI_TYPE_DEALERTABLE_ID:
                return TYPE_CURSOR_ITEM + DealertableColumns.TABLE_NAME;

            case URI_TYPE_FOLLOWUPTABLE:
                return TYPE_CURSOR_DIR + FollowuptableColumns.TABLE_NAME;
            case URI_TYPE_FOLLOWUPTABLE_ID:
                return TYPE_CURSOR_ITEM + FollowuptableColumns.TABLE_NAME;

            case URI_TYPE_NOTIFICATIONTABLE:
                return TYPE_CURSOR_DIR + NotificationtableColumns.TABLE_NAME;
            case URI_TYPE_NOTIFICATIONTABLE_ID:
                return TYPE_CURSOR_ITEM + NotificationtableColumns.TABLE_NAME;

            case URI_TYPE_OFFLINETABLE:
                return TYPE_CURSOR_DIR + OfflinetableColumns.TABLE_NAME;
            case URI_TYPE_OFFLINETABLE_ID:
                return TYPE_CURSOR_ITEM + OfflinetableColumns.TABLE_NAME;

            case URI_TYPE_PREVIOUSVISITTABLE:
                return TYPE_CURSOR_DIR + PreviousvisittableColumns.TABLE_NAME;
            case URI_TYPE_PREVIOUSVISITTABLE_ID:
                return TYPE_CURSOR_ITEM + PreviousvisittableColumns.TABLE_NAME;

        }
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        if (DEBUG) Log.d(TAG, "insert uri=" + uri + " values=" + values);
        return super.insert(uri, values);
    }

    @Override
    public int bulkInsert(Uri uri, ContentValues[] values) {
        if (DEBUG) Log.d(TAG, "bulkInsert uri=" + uri + " values.length=" + values.length);
        return super.bulkInsert(uri, values);
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        if (DEBUG) Log.d(TAG, "update uri=" + uri + " values=" + values + " selection=" + selection + " selectionArgs=" + Arrays.toString(selectionArgs));
        return super.update(uri, values, selection, selectionArgs);
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        if (DEBUG) Log.d(TAG, "delete uri=" + uri + " selection=" + selection + " selectionArgs=" + Arrays.toString(selectionArgs));
        return super.delete(uri, selection, selectionArgs);
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        if (DEBUG)
            Log.d(TAG, "query uri=" + uri + " selection=" + selection + " selectionArgs=" + Arrays.toString(selectionArgs) + " sortOrder=" + sortOrder
                    + " groupBy=" + uri.getQueryParameter(QUERY_GROUP_BY) + " having=" + uri.getQueryParameter(QUERY_HAVING) + " limit=" + uri.getQueryParameter(QUERY_LIMIT));
        return super.query(uri, projection, selection, selectionArgs, sortOrder);
    }

    @Override
    protected QueryParams getQueryParams(Uri uri, String selection, String[] projection) {
        QueryParams res = new QueryParams();
        String id = null;
        int matchedId = URI_MATCHER.match(uri);
        switch (matchedId) {
            case URI_TYPE_CITYTABLE:
            case URI_TYPE_CITYTABLE_ID:
                res.table = CitytableColumns.TABLE_NAME;
                res.idColumn = CitytableColumns._ID;
                res.tablesWithJoins = CitytableColumns.TABLE_NAME;
                res.orderBy = CitytableColumns.DEFAULT_ORDER;
                break;

            case URI_TYPE_DEALERTABLE:
            case URI_TYPE_DEALERTABLE_ID:
                res.table = DealertableColumns.TABLE_NAME;
                res.idColumn = DealertableColumns._ID;
                res.tablesWithJoins = DealertableColumns.TABLE_NAME;
                res.orderBy = DealertableColumns.DEFAULT_ORDER;
                break;

            case URI_TYPE_FOLLOWUPTABLE:
            case URI_TYPE_FOLLOWUPTABLE_ID:
                res.table = FollowuptableColumns.TABLE_NAME;
                res.idColumn = FollowuptableColumns._ID;
                res.tablesWithJoins = FollowuptableColumns.TABLE_NAME;
                res.orderBy = FollowuptableColumns.DEFAULT_ORDER;
                break;

            case URI_TYPE_NOTIFICATIONTABLE:
            case URI_TYPE_NOTIFICATIONTABLE_ID:
                res.table = NotificationtableColumns.TABLE_NAME;
                res.idColumn = NotificationtableColumns._ID;
                res.tablesWithJoins = NotificationtableColumns.TABLE_NAME;
                res.orderBy = NotificationtableColumns.DEFAULT_ORDER;
                break;

            case URI_TYPE_OFFLINETABLE:
            case URI_TYPE_OFFLINETABLE_ID:
                res.table = OfflinetableColumns.TABLE_NAME;
                res.idColumn = OfflinetableColumns._ID;
                res.tablesWithJoins = OfflinetableColumns.TABLE_NAME;
                res.orderBy = OfflinetableColumns.DEFAULT_ORDER;
                break;

            case URI_TYPE_PREVIOUSVISITTABLE:
            case URI_TYPE_PREVIOUSVISITTABLE_ID:
                res.table = PreviousvisittableColumns.TABLE_NAME;
                res.idColumn = PreviousvisittableColumns._ID;
                res.tablesWithJoins = PreviousvisittableColumns.TABLE_NAME;
                res.orderBy = PreviousvisittableColumns.DEFAULT_ORDER;
                break;

            default:
                throw new IllegalArgumentException("The uri '" + uri + "' is not supported by this ContentProvider");
        }

        switch (matchedId) {
            case URI_TYPE_CITYTABLE_ID:
            case URI_TYPE_DEALERTABLE_ID:
            case URI_TYPE_FOLLOWUPTABLE_ID:
            case URI_TYPE_NOTIFICATIONTABLE_ID:
            case URI_TYPE_OFFLINETABLE_ID:
            case URI_TYPE_PREVIOUSVISITTABLE_ID:
                id = uri.getLastPathSegment();
        }
        if (id != null) {
            if (selection != null) {
                res.selection = res.table + "." + res.idColumn + "=" + id + " and (" + selection + ")";
            } else {
                res.selection = res.table + "." + res.idColumn + "=" + id;
            }
        } else {
            res.selection = selection;
        }
        return res;
    }
}
