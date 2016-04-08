package com.gaadi.sfa.utils;



import com.gaadi.sfa.BuildConfig;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ashish123 on 27/6/15.
 */
public class AppConstants {

    public static final String APP_SHARED_PREFERENCE = BuildConfig.APPLICATION_ID;
    public static final String APP_PACKAGE_NAME = "APP_PACKAGE_NAME";
    public static final String MODEL_ID = "MODEL_ID";
    public static final String API_KEY_LABEL = "key";
    public static final String API_RESPONSE_FORMAT_LABEL = "output";
    public static final String OEM_DATA = "data";
    public static final String PLATFORM_SOURCE = "SOURCE";
    public static final String METHOD_LABEL = "method";
    public static final String USERID = "USER_ID";


    // METHOD NAMES
    public static final String CITY_METHOD = "getCity";
    public static final String KEY = "serviceData";
    public static final String ADD_USER_METHOD = "addUser";
    public static final String CHECK_USER_LOGIN = "checkUserLogin";
    public static final String SAVE_LEAD_METHOD = "saveLead";
    public static final String GET_DEALER_METHOD = "getDealers";
    public static final String GET_NOTIFICATIONS_METHOD = "getNotifications";
    public static final String COLOR_METHOD = "getColor";
    public static final String GETOTP_METHOD ="getOTP";
    public static final String SAVEQUERY_METHOD ="saveQuery";
    public static final String VERIFIED_OTP_METHOD ="verifiedOTP";
    public static final String IMAGE_PROCESSING_METHOD ="processImage";
    public static final String DO_TRANSACTION_METHOD = "doTransaction";
    public static final String GALLERY_METHOD = "getGallery";
    public static final String BRAND_METHOD = "getBranding";
    public static final String SPEC_METHOD = "getVersionSpec";
    public static final String HOME_METHOD = "getHomePage1";
    public static final String COMPARE_METHOD = "getCompareList";
    public static final String BOOKING_HISTORY_METHOD = "checkBooking";
    public static final String TEST_DRIVE_METHOD = "testDrive";

    public static final String GET_ACCESSORIES_METHOD = "getAccessories";

    // used for shared preference
    public static final String GCM_ID = "GCM_ID";
    public static final String USER_TYPE = "USER_TYPE";
    public static final String USER_ID = "USER_ID";
    public static final String PAYMENT_DATA = "PAYMENT_DATA";

    // used to pass as input to api
    public static final String GCMID = "gcmid";


    // Source logins
    public static final String SOURCE_DIRECT = "DirectSource";
    public static final String SOURCE_FACEBOOK = "Facebook";
    public static final String SOURCE_GOOGLE = "Google";

    // activity launch codes
    public static final int PREBOOK_PAYMENT = 1010;
    public static final String NO_BOOKING_MSG = "you don't have any booking transaction. " ;
    public static final String FAST_NETWORK = "FAST_NETWORK";
    public static final String DATA_SYNCED = "DATA_SYNCED";
    public static final String HOME_PAGE_NAME = "home_page";
    public static final String WEB_360_PAGE_NAME = "web360_page";
    public static final String GALLERY_PAGE_NAME = "gallery_page";
    public static final String FEATURE_GALLERY_PAGE_NAME = "feature_gallery_page";
    public static final String TEST_DRIVE_PAGE_NAME = "test_drive_page";
    public static final String BRAND_AMBASSADOR_PAGE_NAME = "brand_ambassador_page";
    public static final String ACCESSORIES_PAGE_NAME = "accessories_page";
    public static final String SPECIFICATION_PAGE_NAME = "specification_page";
    public static final String VERSIONS_DATA = "versions";
    public static final String COLORS_PAGE_NAME = "colors_page";
    public static final String COMPARE_PAGE_NAME = "compare_page";
    public static final String NEARBY_DEALERS_METHOD = "getNearDealer";
    public static final String DEALER_DATA = "DEALER_DATA";
    public static final String SELECTED_CITY = "SELECTED_CITY";
    public static final String SELECTED_VARIANT = "SELECTED_VARIANT";
    public static final String SELECTED_DEALERSHIP = "SELECTED_DEALERSHIP";
    public static final int SHARE_INTENT = 2012;
    public static final String SHARE_TEXT = "SHARE_TEXT";
    public static final String SHARE_TEXT_SUBJECT = "SHARE_TEXT_SUBJECT";
    public static final String SHARE_TEXT_CONTENT = "SHARE_TEXT_CONTENT";
    public static final String TAB_VALUES = "TAB_VALUES";
    public static final String TnC_METHOD = "gettermandcond";
    public static final String TAB_DATA = "TAB_DATA";
    public static final String CURRENT_SELECTED_COLOR = "current_selected_color";
    public static final String VERIFY_BOOKING_OTP_METHOD = "verifyOtpBooking";
    public static final String APP_VERSION_CODE = "APP_VERSION_CODE";
    public static final String APP_VERSION_NAME = "APP_VERSION_NAME";
    public static final String ANDROID_ID = "ANDROID_ID";
    public static final String VERSION_UPDATE_METHOD = "versionUpdate";
    public static final String FEATURE_VALUE_MODEL = "featureValueModel";
    public static final String CONTEST_PAGE_URL = "CONTEST_PAGE_URL";
    public static final String CONTEST_PLAYED = "contestPlayed";
    public static final String VIRTUAL_TESTDRIVE_FLAG = "virtualTestDriveFlag";
    public static final String CATEGORY_BOOK_NOW = "BOOK_NOW";
    public static final String ACTION_TAP = "ACTION_TAP";
    public static final String CATEGORY_HOME_NAVIGATION_DRAWER = "NAVIGATON_HAMBURGER_MENU";
    public static final String ACTION_GALLERY_TAP = "TAP_GALLERY";
    public static final String ACTION_360_TAP = "TAP_360_VIEW";
    public static final String ACTION_SPECIFICATION_TAP = "TAP_SPECIFICATION";
    public static final String ACTION_COMPARE_TAP = "TAP_COMPARE";
    public static final String ACTION_COLOR_TAP = "TAP_COLOR";
    public static final String ACTION_ACCESSORIES_TAP = "TAP_ACCESSORIES";
    public static final String ACTION_BUZZ_TAP = "TAP_BUZZ";
    public static final String ACTION_BOOKING_TAP = "TAP_BOOKING";
    public static final String ACTION_FEEL_TAP = "TAP_FEEL_THE_BIKE";
    public static final String ACTION_CONTACT_TAP = "TAP_CONTACT";
    public static final String ACTION_DEALER_TAP = "TAP_DEALERS";
    public static final String CUSTOMER_NAME = "CUSTOMER_NAME";
    public static final String CUSTOMER_EMAIL = "CUSTOMER_EMAIL";
    public static final String CUSTOMER_MOBILE = "CUSTOMER_MOBILE";
    public static final String LOGGING_METHOD = "logEvent";
    public static final String LOG_PARAMS = "params";
    public static final String CATEGORY_KWID_CONTEST = "KWID_CONTEST";
    public static final String ACTION_SLOGAN_SUBMIT = "TAP_SLOGAN_SUBMIT";
    public static final String DEVICE_NAME = "DEVICE_NAME";
    public static final String CASH_VISIBILITY = "CASH_VISIBILITY";
    public static final String FEATURE_CATEGORY_RESPONSE = "FEATURE_CATEGORY_RESPONSE";
    public static final String TnC_METHOD_CONTEST = "gettermandcondcontest";
    public static final String GALLERY_LIST = "GALLERY_LIST";
    public static final String BOOKINGS = "BOOKINGS";
    public static final String ACTION_PRICE_TAP = "TAP_PRICE";
    public static final String CITY_LIST = "CITY_LIST";
    public static final String VERSIONS_LIST = "VERSIONS_LIST";
    public static final String FETCH_PRICE_METHOD = "getversionprice";
    public static final String PRICE_IMAGE_URL = "PRICE_IMAGE_URL";
    public static final String NOT_ALLOWED_NAME_CHARS = "0123456789`~!@#$%^&*()_+-={}[]:;'<>?,./'|\\";
    public static final String KWID_CONTEST_METHOD = "saveContest";
    public static final int LOGIN_NOW = 2005;
    public static final String FETCH_PRICE_DISCLAIMER_METHOD = "getpricedisclaimer";
    public static final String ADVENTURE_PAGE_NAME = "adventure_page_name";
    public static final String ROUTE_MAP_PAGE_NAME = "route_map_page";
    public static final String GALLERY_IMAGE_FULL_SIZE = "gallery_image_size";
    public static final String EXTRA_ROUTE_DESTINATION_MODEL = "extra_route_model";
    public static final String EXTRA_ROUTE_DESTINATION_INDEX = "extra_destination_index";
    public static final String EXTRA_NOTIFICATION_TAG = "extra_notification_tag";
    public static final String METHOD_USER_LOGIN = "user_login";
    public static final String LOGIN_OBJECT = "login_response_model";
    public static final String METHOD_FORGOT_PASSWORD = "forgot_password";
    public static final String METHOD_RESET_PASSWORD = "reset_password";
    public static final String METHOD_DEALERS = "getdealers";
    public static final String METHOD_CHECKIN = "checkin";
    public static final String CHECKIN_DEALER = "Dealer";


    public final class FACEBOOK_CONSTANTS {
        public final static String PERMISSION_USER_ABOUT_ME = "user_about_me";
        public final static String PERMISSION_USER_EMAIL = "email";
        public final static String PERMISSION_USER_EDUCATION_HISTORY = "user_education_history";


        public final static String LINK_ME = "/me";

        public final static String FIELD_EDUCATION = "education";
        public final static String FIELD_EMAIL = "email";



    }

    public static final String N_SEEN = "SEEN";

    public final static Map<String,String[]> PERMISSION_FIELDS_MAP = new HashMap<>();

    static {
        PERMISSION_FIELDS_MAP.put("email",new String[]{"email"});
        PERMISSION_FIELDS_MAP.put("user_about_me",new String[]{"gender","first_name","last_name"});
        PERMISSION_FIELDS_MAP.put("user_friends",new String[]{"friends"});
        PERMISSION_FIELDS_MAP.put("user_education_history",new String[]{"education"});
    }

    public enum DATA_DOMAIN {PERMISSIONS,FIELDS}


    public static String USER_LOGGED_IN="USER_LOGGED_IN";
    public static final String DEVELOPER_KEY = "AIzaSyAKRwxZqHeeY_bUszTGGARU4neODeKUUFI";

    public static String CONTACT_US_EMAIL="kwidapp@renault-india.com";
    public static String CONTACT_US_SMS="53030";
    public static String CONTACT_US_CALL="180030044444";
    public static String AGENT="agent";

    public static int RANBIR_QUOTES_CHANGE_TIME  = 5000;//3 second
    public static int HOME_IMAGES_CHANGE_TIME  = 4000;//3 second

    public static final int YOUR_ADVENTURE_GUIDE = 0;
    public static final int LEAVE_THE_CITY_BEHIND = 1;
    public static final int FROM_SELECT_TOUR_FRAGMENT = 2;
    public static final int BEGIN_ROUTE_VIEW_PAGER = 3;

    public static final int START_ADVENTURE_VIDEOS = 4;


    public static final String SOURCE_CITY_INDEX = "source_city_index" ;
    public static final String DESTINATION_CITY_INDEX = "destination_city_index" ;

    public static final String ROUTE_DETAILS_VIEWPAGER_INDEX="route_details_viewpager_index";

    public static final String SPECIFICATION_TABLE_DATA = "specification_table_data" ;

    public static final int SPECEFICICATION_ITEM_WIDTH_IN_PIXAL = 150;


    public static final String ONE_SIGNAL_EMAIL_TAG="USER_EMAIL";
    public static final String ONE_SIGNAL_USER_ID_TAG="USER_ID";
    public static final String ONE_SIGNAL_USER_TYPE_TAG="USER_TYPE";
    public static final String ONE_SIGNAL_VERSION_CODE_TAG="VERSION_CODE";

    public static final String USER_TYPE_CONSUMER="user";
    public static final String USER_TYPE_DEALER="dealer";
}
