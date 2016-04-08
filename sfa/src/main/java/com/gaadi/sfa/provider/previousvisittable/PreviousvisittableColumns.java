package com.gaadi.sfa.provider.previousvisittable;

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
public class PreviousvisittableColumns implements BaseColumns {
    public static final String TABLE_NAME = "previousvisittable";
    public static final Uri CONTENT_URI = Uri.parse(SfaContentProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    public static final String DATE = "date";

    public static final String CHECKIN = "checkin";

    public static final String CHECKOUT = "checkout";

    public static final String COMMENTS = "comments";

    public static final String DEALERID = "dealerid";


    public static final String DEFAULT_ORDER = TABLE_NAME + "." +_ID;

    // @formatter:off
    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            DATE,
            CHECKIN,
            CHECKOUT,
            COMMENTS,
            DEALERID
    };
    // @formatter:on

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(DATE) || c.contains("." + DATE)) return true;
            if (c.equals(CHECKIN) || c.contains("." + CHECKIN)) return true;
            if (c.equals(CHECKOUT) || c.contains("." + CHECKOUT)) return true;
            if (c.equals(COMMENTS) || c.contains("." + COMMENTS)) return true;
            if (c.equals(DEALERID) || c.contains("." + DEALERID)) return true;
        }
        return false;
    }

}
