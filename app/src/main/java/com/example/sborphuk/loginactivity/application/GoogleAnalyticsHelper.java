package com.example.sborphuk.loginactivity.application;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;


public class GoogleAnalyticsHelper
    {

        private static GoogleAnalyticsHelper mTrackerUtility;

        public static synchronized GoogleAnalyticsHelper getInstance()
            {
                if(mTrackerUtility == null)
                    {
                        mTrackerUtility = new GoogleAnalyticsHelper();
                        return mTrackerUtility;
                    }else
                    {
                        return mTrackerUtility;
                    }
            }

        private GoogleAnalyticsHelper()
            {
            }

        /***
         * Function to track screen view (Activity or Fragment).
         *
         * @param screenName screen name to be displayed on GA dashboard
         */
        public void trackScreenView(String screenName)
            {
                Tracker t = AnalyticsApplication.getApplictaionInstance().getDefaultTracker();

                // Set screen name.
                t.setScreenName(screenName);

                // Send a screen view.
                t.send(new HitBuilders.ScreenViewBuilder().build());

                GoogleAnalytics.getInstance(AnalyticsApplication.getApplictaionInstance()).dispatchLocalHits();


            }

        /***
         * Function to track exceptions using try & catch.
         *
         * @param e exception to be tracked
         */
        public void trackException(Exception e)
            {
                if (e != null)
                    {
                        Tracker t = AnalyticsApplication.getApplictaionInstance().getDefaultTracker();

                        t.send(new HitBuilders.ExceptionBuilder()
                                        .setDescription(
                                                new AnalyticsExceptionParser().getDescription(Thread.currentThread().getName(), e))
                                                        .setFatal(false)
                                                        .build()
                                        );
                    }
            }

        /***
         * Function to track event
         *
         * @param category event category
         * @param action   action of the event
         * @param label    label
         */
        public void trackEvent(String category, String action, String label)
            {
                Tracker t = AnalyticsApplication.getApplictaionInstance().getDefaultTracker();

                // Build and send an Event.
                t.send(new HitBuilders.EventBuilder().setCategory(category).setAction(action).setLabel(label).build());
            }

        /***
         * Function to track Social Interaction
         *
         * @param name social network name
         * @param action   action of the social network
         */
        public void trackSocialInteraction(String name, String action)
            {
                Tracker t = AnalyticsApplication.getApplictaionInstance().getDefaultTracker();

                // Build and send social interaction.
                t.send(new HitBuilders.SocialBuilder().setNetwork(name).setAction(action).build());
            }
       /* // Sends the ecommerce data.
        public void sendDataToTwoTrackers(Map<String, String> params) {

            ApplicationState.getApplictaionInstance().getDefaultTracker().send(params);

        }*/

        /***
         * Function to track Social Interaction
         *
         *
         */
        public void trackEcommerce(HitBuilders.ScreenViewBuilder builder )
            {
                Tracker t = AnalyticsApplication.getApplictaionInstance().getDefaultTracker();
                // t.setScreenName("transaction");
                t.set("&cu", "AUD");
                t.send(builder.build());

            }
    }
