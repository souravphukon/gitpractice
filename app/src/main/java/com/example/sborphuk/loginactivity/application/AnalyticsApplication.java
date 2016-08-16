package com.example.sborphuk.loginactivity.application;

import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.sborphuk.loginactivity.login.LoginActivity;
import com.google.android.gms.analytics.Tracker;

/**
 * Created by sborphuk on 8/11/2016.
 */
public class AnalyticsApplication extends Application
    {


        private static AnalyticsApplication applictaionInstance;

        @Override
        public void onCreate()
            {
                super.onCreate();
                applictaionInstance = this;
                // Setup handler for uncaught exceptions.

              Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler()
                {
                    @Override
                    public void uncaughtException(Thread thread, Throwable e)
                        {
                            GoogleAnalyticsHelper.getInstance().trackException((Exception) e);
                            handleUncaughtException(thread, e);
                        }


                });
                //EchoAppPreferenceClass.init(this);
            }

        /**
         * This is a subclass of {@link Application} used to provide shared objects for this app, such as
         * the {@link Tracker}.
         */


        public static AnalyticsApplication getApplictaionInstance()
            {
                return applictaionInstance;
            }


        /**
         * Gets the default {@link Tracker} for this {@link AnalyticsApplication}.
         *
         * @return tracker
         */
        synchronized public Tracker getDefaultTracker()
            {
                return MyAnalyticsTrackers.getInstance().get(MyAnalyticsTrackers.TrackerName.GLOBALTRACKER);
            }

        public static Context getAppContext()
            {
                return applictaionInstance.getApplicationContext();
            }

        private void handleUncaughtException(Thread thread, Throwable e)
            {
                // not all Android versions will print the stack trace automatically
                Log.i("", "^=======exception==" + e);

                PendingIntent myActivity = PendingIntent.getActivity(this,
                        0, new Intent(this, LoginActivity.class).putExtra("ERROR", "" + e),
                        PendingIntent.FLAG_ONE_SHOT);

               AlarmManager alarmManager;
                alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                        15000, myActivity);

                System.exit(2);
            }

    }
