package com.gaadi.sfa.provider.notificationtable;

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
 * to make available notifications offline
 */
public class NotificationtableColumns implements BaseColumns {
    public static final String TABLE_NAME = "notificationtable";
    public static final Uri CONTENT_URI = Uri.parse(SfaContentProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    public static final String NOTIFICATION_ID = "notification_id";

    public static final String NOTIFICATION_TITLE = "notification_title";

    public static final String NOTIFICATION_MSG = "notification_msg";

    public static final String NOTIFICATION_IMAGE = "notification_image";

    public static final String NOTIFICATION_TIME = "notification_time";

    public static final String TAG = "tag";

    public static final String HTML_SOURCE = "html_source";

    public static final String NOTIFICATION_STATUS = "notification_status";


    public static final String DEFAULT_ORDER = TABLE_NAME + "." +_ID;

    // @formatter:off
    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            NOTIFICATION_ID,
            NOTIFICATION_TITLE,
            NOTIFICATION_MSG,
            NOTIFICATION_IMAGE,
            NOTIFICATION_TIME,
            TAG,
            HTML_SOURCE,
            NOTIFICATION_STATUS
    };
    // @formatter:on

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(NOTIFICATION_ID) || c.contains("." + NOTIFICATION_ID)) return true;
            if (c.equals(NOTIFICATION_TITLE) || c.contains("." + NOTIFICATION_TITLE)) return true;
            if (c.equals(NOTIFICATION_MSG) || c.contains("." + NOTIFICATION_MSG)) return true;
            if (c.equals(NOTIFICATION_IMAGE) || c.contains("." + NOTIFICATION_IMAGE)) return true;
            if (c.equals(NOTIFICATION_TIME) || c.contains("." + NOTIFICATION_TIME)) return true;
            if (c.equals(TAG) || c.contains("." + TAG)) return true;
            if (c.equals(HTML_SOURCE) || c.contains("." + HTML_SOURCE)) return true;
            if (c.equals(NOTIFICATION_STATUS) || c.contains("." + NOTIFICATION_STATUS)) return true;
        }
        return false;
    }

}
