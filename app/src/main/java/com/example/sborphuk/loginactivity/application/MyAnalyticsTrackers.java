package com.example.sborphuk.loginactivity.application;

import com.example.sborphuk.loginactivity.R;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by Sourav borphukon on 9/29/2015.
 */
public final class MyAnalyticsTrackers
    {

        private static MyAnalyticsTrackers myAnalyticsTrackers;
        // The following line should be changed to include the correct property id.
       // private final String PROPERTY_ID = "UA-68206938-1";//UA-68206938-1(Martin)//UA-68225216-1(me)//UA-68206938-1


        public enum TrackerName
            {
                GLOBALTRACKER, APP,
                // Add more trackers here if you need, and update the code in #get(Target) below
            }




        public static synchronized MyAnalyticsTrackers getInstance()
            {
                if (myAnalyticsTrackers == null)
                    {
                        // throw new IllegalStateException("Call initialize() before getInstance()");
                        myAnalyticsTrackers = new MyAnalyticsTrackers();
                        return myAnalyticsTrackers;
                    } else
                    {
                        return myAnalyticsTrackers;
                    }
            }

        private final Map<TrackerName, Tracker> mTrackers = new HashMap<>();
        //private final Context mContext;


     /*  // private MyAnalyticsTrackers(Context context)
            {
                mContext = context.getApplicationContext();
            }*/

        public synchronized Tracker get(TrackerName trackerName)
            {
                if (!mTrackers.containsKey(trackerName))
                    {
                        Tracker tracker = null;
                        switch (trackerName)
                            {
                                case GLOBALTRACKER:
                                    GoogleAnalytics analytics = GoogleAnalytics.getInstance(AnalyticsApplication.getApplictaionInstance());
                                    //analytics.newTracker(PROPERTY_ID);
                                    tracker = analytics.newTracker(R.xml.global_tracker);

                                    break;

                               case APP:
                                    //tracker = GoogleAnalytics.getInstance(ApplicationState.getAppContext()).newTracker(R.xml.app_tracker);
                                    break;
                                default:
                                    throw new IllegalArgumentException("Unhandled analytics target " + trackerName);
                            }
                        mTrackers.put(trackerName, tracker);
                    }

                return mTrackers.get(trackerName);
            }


    }
