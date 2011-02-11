/*
 *      Copyright (c) 2004-2011 YAMJ Members
 *      http://code.google.com/p/moviejukebox/people/list 
 *  
 *      Web: http://code.google.com/p/moviejukebox/
 *  
 *      This software is licensed under a Creative Commons License
 *      See this page: http://code.google.com/p/moviejukebox/wiki/License
 *  
 *      For any reuse or distribution, you must make clear to others the 
 *      license terms of this work.  
 */

package com.moviejukebox.fanarttv.tools;

import java.security.PrivilegedAction;
import java.util.logging.LogRecord;

public class LogFormatter extends java.util.logging.Formatter {

    public LogFormatter() {
    }

    private static final String EOL = (String)java.security.AccessController.doPrivileged(new PrivilegedAction<Object>() {
        public Object run() {
            return System.getProperty("line.separator");
        }
    });

    public synchronized String format(LogRecord logRecord) {
        String logMessage = logRecord.getMessage();

        logMessage = "[FanartTV API] " + logMessage + EOL;
        
        Throwable thrown = logRecord.getThrown();
        if (thrown != null) { 
            logMessage = logMessage + thrown.toString(); 
        }
        return logMessage;
    }
    
}
