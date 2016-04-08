package com.gaadi.sfa.provider.offlinetable;

import android.net.Uri;
import android.provider.BaseColumns;

import com.gaadi.sfa.provider.SfaContentProvider;
import com.gaadi.sfa.provider.citytable.CitytableColumns;
import com.gaadi.sfa.provider.dealertable.DealertableColumns;
import com.gaadi.sfa.provider.followuptable.FollowuptableColumns;
import com.gaadi.sfa.provider.notificationtable.NotificationtableColumns;
import com.gaadi.sfa.provider.offlinetable.OfflinetableColumns;
import com.gaadi.sfa.provider.previousvisittable.PreviousvisittableColumns;

/**
 * to offline data
 */
public class OfflinetableColumns implements BaseColumns {
    public static final String TABLE_NAME = "offlinetable";
    public static final Uri CONTENT_URI = Uri.parse(SfaContentProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    /**
     * Name of Key
     */
    public static final String KEY = "key";

    /**
     * json of record
     */
    public static final String JSON_DATA = "json_data";


    public static final String DEFAULT_ORDER = TABLE_NAME + "." +_ID;

    // @formatter:off
    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            KEY,
            JSON_DATA
    };
    // @formatter:on

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(KEY) || c.contains("." + KEY)) return true;
            if (c.equals(JSON_DATA) || c.contains("." + JSON_DATA)) return true;
        }
        return false;
    }

}
