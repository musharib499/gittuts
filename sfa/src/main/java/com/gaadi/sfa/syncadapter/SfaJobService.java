package com.gaadi.sfa.syncadapter;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;

import com.gaadi.sfa.utils.Logger;


/**
 * Created by vinodtakhar on 9/2/16.
 */
@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public class SfaJobService extends JobService {
    private static final int JOB_ID = 100;
    private JobParameters jobParameters;
    private static final String TAG = "SfaJobService.java";

    @Override
    public boolean onStartJob(JobParameters params) {
        jobParameters=params;
        new JobAsyncTask().execute(params);
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return true;
    }

    private class JobAsyncTask extends AsyncTask<JobParameters, Void, Boolean> {

        @Override
        protected Boolean doInBackground(JobParameters... params) {

            try {
                Bundle bundle=new Bundle();
                PersistableBundle persistableBundle=params[0].getExtras();

                bundle.putInt(SfaSyncManager.EXTRA_SYNC_MODE,persistableBundle.getInt(SfaSyncManager.EXTRA_SYNC_MODE,SfaSyncManager.SYNC_MODE_LIVE));
                bundle.putInt(SfaSyncManager.EXTRA_SYNC_SCOPE,persistableBundle.getInt(SfaSyncManager.EXTRA_SYNC_SCOPE,SfaSyncManager.SYNC_SCOPE_ALL));

                SfaSyncManager.startSynchronized(SfaJobService.this,bundle);
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }

            return true;
        }

        @Override
        protected void onPostExecute(Boolean result) {
            jobFinished(jobParameters,!result);
        }
    }

    public static void scheduleJob(Context context){
        ComponentName serviceName = new ComponentName(context, SfaJobService.class);
        JobInfo jobInfo = new JobInfo.Builder(JOB_ID, serviceName)
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
                .setRequiresDeviceIdle(false)
                .setRequiresCharging(false)
                .setPeriodic(AlarmManager.INTERVAL_DAY)
                .setOverrideDeadline(1000 * 10)
                .build();

        JobScheduler scheduler = (JobScheduler) context.getSystemService(Context.JOB_SCHEDULER_SERVICE);

        scheduler.cancel(JOB_ID);

        int result = scheduler.schedule(jobInfo);

        if (result == JobScheduler.RESULT_SUCCESS)
            Logger.d(TAG, "Job scheduled successfully!");
    }
}
