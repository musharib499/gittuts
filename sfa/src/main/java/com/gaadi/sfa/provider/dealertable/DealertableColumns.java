package com.gaadi.sfa.provider.dealertable;

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
public class DealertableColumns implements BaseColumns {
    public static final String TABLE_NAME = "dealertable";
    public static final Uri CONTENT_URI = Uri.parse(SfaContentProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    /**
     * Name of dealer
     */
    public static final String DEALERNAME = "dealername";

    /**
     * unique id of dealer
     */
    public static final String DEALERID = "dealerid";

    public static final String CITYID = "cityid";

    public static final String ASSIGNED = "assigned";

    public static final String MOBILE = "mobile";

    public static final String LATITUDE = "latitude";

    public static final String LONGITUDE = "longitude";

    public static final String AREA = "area";

    public static final String LOGINTOKEN = "loginToken";


    public static final String DEFAULT_ORDER = TABLE_NAME + "." +_ID;

    // @formatter:off
    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            DEALERNAME,
            DEALERID,
            CITYID,
            ASSIGNED,
            MOBILE,
            LATITUDE,
            LONGITUDE,
            AREA,
            LOGINTOKEN
    };
    // @formatter:on

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(DEALERNAME) || c.contains("." + DEALERNAME)) return true;
            if (c.equals(DEALERID) || c.contains("." + DEALERID)) return true;
            if (c.equals(CITYID) || c.contains("." + CITYID)) return true;
            if (c.equals(ASSIGNED) || c.contains("." + ASSIGNED)) return true;
            if (c.equals(MOBILE) || c.contains("." + MOBILE)) return true;
            if (c.equals(LATITUDE) || c.contains("." + LATITUDE)) return true;
            if (c.equals(LONGITUDE) || c.contains("." + LONGITUDE)) return true;
            if (c.equals(AREA) || c.contains("." + AREA)) return true;
            if (c.equals(LOGINTOKEN) || c.contains("." + LOGINTOKEN)) return true;
        }
        return false;
    }

}
