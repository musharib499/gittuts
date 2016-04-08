package com.gaadi.sfa.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;

import com.gaadi.sfa.R;

/**
 * Created by vinodtakhar on 7/1/16.
 */
public class HomePageActivity extends NavigationActivity{

    public void onCreate(Bundle bundle){
        super.onCreate(bundle);

        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        inflater.inflate(R.layout.home_activity, frameLayout);
    }
}
