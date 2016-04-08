package com.gaadi.sfa.provider.offlinetable;

import com.gaadi.sfa.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * to offline data
 */
public interface OfflinetableModel extends BaseModel {

    /**
     * Name of Key
     * Cannot be {@code null}.
     */
    @NonNull
    String getKey();

    /**
     * json of record
     * Cannot be {@code null}.
     */
    @NonNull
    String getJsonData();
}
