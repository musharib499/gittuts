package com.gaadi.sfa.provider.citytable;

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
 * to make available city names offline
 */
public class CitytableColumns implements BaseColumns {
    public static final String TABLE_NAME = "citytable";
    public static final Uri CONTENT_URI = Uri.parse(SfaContentProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    /**
     * Name of city
     */
    public static final String CITYNAME = "cityname";

    /**
     * unique id of city
     */
    public static final String CITY_ID = "city_id";

    public static final String STATE_NAME = "state_name";

    public static final String STATE_CODE = "state_code";

    public static final String IS_BOOKING = "is_booking";


    public static final String DEFAULT_ORDER = TABLE_NAME + "." +_ID;

    // @formatter:off
    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            CITYNAME,
            CITY_ID,
            STATE_NAME,
            STATE_CODE,
            IS_BOOKING
    };
    // @formatter:on

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(CITYNAME) || c.contains("." + CITYNAME)) return true;
            if (c.equals(CITY_ID) || c.contains("." + CITY_ID)) return true;
            if (c.equals(STATE_NAME) || c.contains("." + STATE_NAME)) return true;
            if (c.equals(STATE_CODE) || c.contains("." + STATE_CODE)) return true;
            if (c.equals(IS_BOOKING) || c.contains("." + IS_BOOKING)) return true;
        }
        return false;
    }

}
