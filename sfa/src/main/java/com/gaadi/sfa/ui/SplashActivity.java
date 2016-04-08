package com.gaadi.sfa.ui;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.Space;

import com.gaadi.sfa.R;
import com.gaadi.sfa.syncadapter.SfaSyncManager;
import com.gaadi.sfa.utils.AppPrefrences;

import org.json.JSONException;

/**
 * Created by kanishroshan on 28/1/16.
 */
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);

        syncAndProceed();
    }

    private void syncAndProceed(){
        new AsyncTask<Void,Void,Void>(){

            @Override
            protected Void doInBackground(Void... params) {

                Bundle bundle=new Bundle();
                bundle.putInt(SfaSyncManager.EXTRA_SYNC_MODE,SfaSyncManager.SYNC_MODE_LIVE);

                try {
                    SfaSyncManager.startSynchronized(SplashActivity.this,bundle);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                return null;
            }

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);

                if(AppPrefrences.getLoginResponseModel(SplashActivity.this).isResultSuccess())
                    startActivity(new Intent(SplashActivity.this,LandingDboard.class));
                else
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));

                SplashActivity.this.finish();
            }
        }.execute();
    }
}
