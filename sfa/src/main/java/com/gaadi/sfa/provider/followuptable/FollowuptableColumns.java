package com.gaadi.sfa.provider.followuptable;

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
 * to store dealers information
 */
public class FollowuptableColumns implements BaseColumns {
    public static final String TABLE_NAME = "followuptable";
    public static final Uri CONTENT_URI = Uri.parse(SfaContentProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    public static final String DATE = "date";

    public static final String COMMENTS = "comments";

    public static final String OVERDUE = "overdue";

    public static final String DEALERID = "dealerid";


    public static final String DEFAULT_ORDER = TABLE_NAME + "." +_ID;

    // @formatter:off
    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            DATE,
            COMMENTS,
            OVERDUE,
            DEALERID
    };
    // @formatter:on

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(DATE) || c.contains("." + DATE)) return true;
            if (c.equals(COMMENTS) || c.contains("." + COMMENTS)) return true;
            if (c.equals(OVERDUE) || c.contains("." + OVERDUE)) return true;
            if (c.equals(DEALERID) || c.contains("." + DEALERID)) return true;
        }
        return false;
    }

}
