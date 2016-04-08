package com.gaadi.sfa.ui;

/**
 * Created by vinodtakhar on 15/2/16.
 */
public interface DealerItemCallback {
    public void onCall(int dealerItemPosition);
    public void onCheckIn(int dealerItemPosition);
    public void onPinUpdate(int dealerItemPosition);
}
