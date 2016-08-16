package com.example.sborphuk.loginactivity.application;

import com.google.android.gms.analytics.ExceptionParser;

/**
 * Created by sariksin on 4/6/2016.
 */
public class AnalyticsExceptionParser implements ExceptionParser
    {
        @Override
        public String getDescription(String thread, Throwable throwable)
            {
                String stackTrace = StackTraceToString(throwable);
                return "Thread: " + thread + ", Exception: " + stackTrace;
            }

        /**
         * Convert the result of Exception.getStackTrace to a String
         * @param ex
         * @return
         */
        private String StackTraceToString(Throwable ex) {
            String result = ex.toString() + "\n";
            StackTraceElement[] trace = ex.getStackTrace();
            for (int i=0;i<trace.length;i++) {
                result += trace[i].toString() + "\n";
            }
            return result;
        }
    }
