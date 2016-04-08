package com.gaadi.sfa.utils;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;

import com.gaadi.sfa.BuildConfig;
import com.gaadi.sfa.syncadapter.GenericAccountService;


/**
 * Created by vinodtakhar on 10/11/15.
 */
public class SyncUtils {

    private static final String TAG = "SyncUtils.java";
    private static long DAYS_TO_SYNC = 1 * AlarmManager.INTERVAL_DAY; // run sync per day
    private static String PREF_SETUP_COMPLETE = "setup_complete";
    public static String ACCOUNT_TYPE = BuildConfig.ACCOUNT_TYPE;
    public static final String CONTENT_AUTHORITY = BuildConfig.ACCOUNT_AUTHORITY;

    /**
     * Create an entry for this application in the system account list, if it isn't already there.
     *
     * @param context Context
     */
    @TargetApi(Build.VERSION_CODES.FROYO)
    public static boolean createSyncAccountIfNotExistOrDisabled(Context context,Bundle bundle) {

        boolean newAccount = false;

        boolean setupComplete = PreferenceManager
                .getDefaultSharedPreferences(context).getBoolean(PREF_SETUP_COMPLETE, false);

        // Create account, if it's missing. (Either first run, or user has deleted account.)
        Logger.e(TAG + " account Type: ");

        Account account = GenericAccountService.GetAccount(ACCOUNT_TYPE);

        AccountManager accountManager =
                (AccountManager) context.getSystemService(Context.ACCOUNT_SERVICE);

        if(!hasAccountAdded(accountManager)) {

            Logger.e("Account does not exist. Adding now");

            if (accountManager.addAccountExplicitly(account, null, null)) {

                ContentResolver.setIsSyncable(account, CONTENT_AUTHORITY, 1);
                ContentResolver.setSyncAutomatically(account, CONTENT_AUTHORITY, true);
                ContentResolver.addPeriodicSync(
                        account, CONTENT_AUTHORITY, new Bundle(), DAYS_TO_SYNC);

                newAccount = true;

                startSync(bundle);
            }

            // Schedule an initial sync if we detect problems with either our account or our local
            // data has been deleted. (Note that it's possible to clear app data WITHOUT affecting
            // the account list, so wee need to check both.)
            if (newAccount || !setupComplete) {
                //TriggerRefresh();
                PreferenceManager.getDefaultSharedPreferences(context).edit()
                        .putBoolean(PREF_SETUP_COMPLETE, true).commit();
            }
        }else {
            Logger.e("Account already added");

            if(ContentResolver.getIsSyncable(account, CONTENT_AUTHORITY)!=1 || !ContentResolver.getSyncAutomatically(account, CONTENT_AUTHORITY)){
                Logger.e("Account was removed to be sync, add it again");

                ContentResolver.setIsSyncable(account, CONTENT_AUTHORITY, 1);
                ContentResolver.setSyncAutomatically(account, CONTENT_AUTHORITY, true);
                ContentResolver.addPeriodicSync(
                        account, CONTENT_AUTHORITY, new Bundle(), DAYS_TO_SYNC);
            }
        }


        return newAccount;
    }

    private static boolean hasAccountAdded(AccountManager accountManager){

        Account accounts[]=accountManager.getAccountsByType(ACCOUNT_TYPE);

        return accounts!=null && accounts.length>0;
    }

    public static void startSync(Bundle bundle) {

        ContentResolver.requestSync(GenericAccountService.GetAccount(SyncUtils.ACCOUNT_TYPE),
                SyncUtils.CONTENT_AUTHORITY, bundle);
    }
}
