package com.gaadi.sfa.provider;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.DefaultDatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;

import com.gaadi.sfa.BuildConfig;
import com.gaadi.sfa.provider.citytable.CitytableColumns;
import com.gaadi.sfa.provider.dealertable.DealertableColumns;
import com.gaadi.sfa.provider.followuptable.FollowuptableColumns;
import com.gaadi.sfa.provider.notificationtable.NotificationtableColumns;
import com.gaadi.sfa.provider.offlinetable.OfflinetableColumns;
import com.gaadi.sfa.provider.previousvisittable.PreviousvisittableColumns;

public class SfaDb extends SQLiteOpenHelper {
    private static final String TAG = SfaDb.class.getSimpleName();

    public static final String DATABASE_FILE_NAME = "sfa.db";
    private static final int DATABASE_VERSION = 1;
    private static SfaDb sInstance;
    private final Context mContext;
    private final SfaDbCallbacks mOpenHelperCallbacks;

    // @formatter:off
    public static final String SQL_CREATE_TABLE_CITYTABLE = "CREATE TABLE IF NOT EXISTS "
            + CitytableColumns.TABLE_NAME + " ( "
            + CitytableColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + CitytableColumns.CITYNAME + " TEXT NOT NULL, "
            + CitytableColumns.CITY_ID + " TEXT NOT NULL, "
            + CitytableColumns.STATE_NAME + " TEXT, "
            + CitytableColumns.STATE_CODE + " TEXT, "
            + CitytableColumns.IS_BOOKING + " TEXT "
            + ", CONSTRAINT unique_city UNIQUE (city_id, cityname) ON CONFLICT REPLACE"
            + " );";

    public static final String SQL_CREATE_INDEX_CITYTABLE_CITYNAME = "CREATE INDEX IDX_CITYTABLE_CITYNAME "
            + " ON " + CitytableColumns.TABLE_NAME + " ( " + CitytableColumns.CITYNAME + " );";

    public static final String SQL_CREATE_TABLE_DEALERTABLE = "CREATE TABLE IF NOT EXISTS "
            + DealertableColumns.TABLE_NAME + " ( "
            + DealertableColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + DealertableColumns.DEALERNAME + " TEXT NOT NULL, "
            + DealertableColumns.DEALERID + " TEXT NOT NULL, "
            + DealertableColumns.CITYID + " TEXT, "
            + DealertableColumns.ASSIGNED + " INTEGER, "
            + DealertableColumns.MOBILE + " TEXT, "
            + DealertableColumns.LATITUDE + " TEXT, "
            + DealertableColumns.LONGITUDE + " TEXT, "
            + DealertableColumns.AREA + " TEXT, "
            + DealertableColumns.LOGINTOKEN + " TEXT "
            + ", CONSTRAINT unique_dealer UNIQUE (dealerid, dealername) ON CONFLICT REPLACE"
            + " );";

    public static final String SQL_CREATE_INDEX_DEALERTABLE_DEALERNAME = "CREATE INDEX IDX_DEALERTABLE_DEALERNAME "
            + " ON " + DealertableColumns.TABLE_NAME + " ( " + DealertableColumns.DEALERNAME + " );";

    public static final String SQL_CREATE_TABLE_FOLLOWUPTABLE = "CREATE TABLE IF NOT EXISTS "
            + FollowuptableColumns.TABLE_NAME + " ( "
            + FollowuptableColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + FollowuptableColumns.DATE + " TEXT, "
            + FollowuptableColumns.COMMENTS + " TEXT, "
            + FollowuptableColumns.OVERDUE + " INTEGER, "
            + FollowuptableColumns.DEALERID + " TEXT "
            + " );";

    public static final String SQL_CREATE_TABLE_NOTIFICATIONTABLE = "CREATE TABLE IF NOT EXISTS "
            + NotificationtableColumns.TABLE_NAME + " ( "
            + NotificationtableColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + NotificationtableColumns.NOTIFICATION_ID + " TEXT NOT NULL, "
            + NotificationtableColumns.NOTIFICATION_TITLE + " TEXT, "
            + NotificationtableColumns.NOTIFICATION_MSG + " TEXT, "
            + NotificationtableColumns.NOTIFICATION_IMAGE + " TEXT, "
            + NotificationtableColumns.NOTIFICATION_TIME + " TEXT, "
            + NotificationtableColumns.TAG + " TEXT, "
            + NotificationtableColumns.HTML_SOURCE + " TEXT, "
            + NotificationtableColumns.NOTIFICATION_STATUS + " INTEGER "
            + ", CONSTRAINT unique_notification UNIQUE (notification_id) ON CONFLICT REPLACE"
            + " );";

    public static final String SQL_CREATE_TABLE_OFFLINETABLE = "CREATE TABLE IF NOT EXISTS "
            + OfflinetableColumns.TABLE_NAME + " ( "
            + OfflinetableColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + OfflinetableColumns.KEY + " TEXT NOT NULL, "
            + OfflinetableColumns.JSON_DATA + " TEXT NOT NULL "
            + " );";

    public static final String SQL_CREATE_INDEX_OFFLINETABLE_KEY = "CREATE INDEX IDX_OFFLINETABLE_KEY "
            + " ON " + OfflinetableColumns.TABLE_NAME + " ( " + OfflinetableColumns.KEY + " );";

    public static final String SQL_CREATE_TABLE_PREVIOUSVISITTABLE = "CREATE TABLE IF NOT EXISTS "
            + PreviousvisittableColumns.TABLE_NAME + " ( "
            + PreviousvisittableColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + PreviousvisittableColumns.DATE + " TEXT, "
            + PreviousvisittableColumns.CHECKIN + " TEXT, "
            + PreviousvisittableColumns.CHECKOUT + " TEXT, "
            + PreviousvisittableColumns.COMMENTS + " TEXT, "
            + PreviousvisittableColumns.DEALERID + " TEXT "
            + " );";

    // @formatter:on

    public static SfaDb getInstance(Context context) {
        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (sInstance == null) {
            sInstance = newInstance(context.getApplicationContext());
        }
        return sInstance;
    }

    private static SfaDb newInstance(Context context) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
            return newInstancePreHoneycomb(context);
        }
        return newInstancePostHoneycomb(context);
    }


    /*
     * Pre Honeycomb.
     */
    private static SfaDb newInstancePreHoneycomb(Context context) {
        return new SfaDb(context);
    }

    private SfaDb(Context context) {
        super(context, DATABASE_FILE_NAME, null, DATABASE_VERSION);
        mContext = context;
        mOpenHelperCallbacks = new SfaDbCallbacks();
    }


    /*
     * Post Honeycomb.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private static SfaDb newInstancePostHoneycomb(Context context) {
        return new SfaDb(context, new DefaultDatabaseErrorHandler());
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private SfaDb(Context context, DatabaseErrorHandler errorHandler) {
        super(context, DATABASE_FILE_NAME, null, DATABASE_VERSION, errorHandler);
        mContext = context;
        mOpenHelperCallbacks = new SfaDbCallbacks();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        if (BuildConfig.DEBUG) Log.d(TAG, "onCreate");
        mOpenHelperCallbacks.onPreCreate(mContext, db);
        db.execSQL(SQL_CREATE_TABLE_CITYTABLE);
        db.execSQL(SQL_CREATE_INDEX_CITYTABLE_CITYNAME);
        db.execSQL(SQL_CREATE_TABLE_DEALERTABLE);
        db.execSQL(SQL_CREATE_INDEX_DEALERTABLE_DEALERNAME);
        db.execSQL(SQL_CREATE_TABLE_FOLLOWUPTABLE);
        db.execSQL(SQL_CREATE_TABLE_NOTIFICATIONTABLE);
        db.execSQL(SQL_CREATE_TABLE_OFFLINETABLE);
        db.execSQL(SQL_CREATE_INDEX_OFFLINETABLE_KEY);
        db.execSQL(SQL_CREATE_TABLE_PREVIOUSVISITTABLE);
        mOpenHelperCallbacks.onPostCreate(mContext, db);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()) {
            setForeignKeyConstraintsEnabled(db);
        }
        mOpenHelperCallbacks.onOpen(mContext, db);
    }

    private void setForeignKeyConstraintsEnabled(SQLiteDatabase db) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
            setForeignKeyConstraintsEnabledPreJellyBean(db);
        } else {
            setForeignKeyConstraintsEnabledPostJellyBean(db);
        }
    }

    private void setForeignKeyConstraintsEnabledPreJellyBean(SQLiteDatabase db) {
        db.execSQL("PRAGMA foreign_keys=ON;");
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void setForeignKeyConstraintsEnabledPostJellyBean(SQLiteDatabase db) {
        db.setForeignKeyConstraintsEnabled(true);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        mOpenHelperCallbacks.onUpgrade(mContext, db, oldVersion, newVersion);
    }
}
