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
package com.moviejukebox.fanarttv;

import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.moviejukebox.fanarttv.model.FanartTvArtwork;
import com.moviejukebox.fanarttv.tools.FanartTvParser;
import com.moviejukebox.fanarttv.tools.LogFormatter;
import com.moviejukebox.fanarttv.tools.WebBrowser;

/**
 * This is the main class for the API to connect to Fanart.TV
 * http://fanarttv.org/api
 * 
 * @author Stuart.Boston
 * @version 1.1
 * 
 * TODO Allow a selection of the artwork types to be selected rather than 1 or ALL
 */
public class FanartTv {

    private static Logger logger = null;
    private static LogFormatter logFormatter = new LogFormatter();
    private static ConsoleHandler logConsoleHandler = new ConsoleHandler();
    
    private static final String API_SITE = "http://fanart.tv/api/fanart.php?";

    static {
        setLogger(Logger.getLogger("FanartTv"));
    }
    
    public FanartTv() {
    }
    
    /**
     * Get the artwork for a specific TVDb ID, limited by type and/or sorted
     * @param tvdbid
     * @param artworkType
     * @param artworkSortBy
     * @return
     */
    public List<FanartTvArtwork> getArtwork(int tvdbid, String artworkType, String artworkSortBy) {
        String searchUrl = buildUrl(tvdbid, artworkType, artworkSortBy);
        return FanartTvParser.parseArtwork(searchUrl);
    }
    
    /**
     * Get all the artwork for a specific TVDb ID
     * @param tvdbid
     * @return
     */
    public List<FanartTvArtwork> getArtwork(int tvdbid) {
        return getArtwork(tvdbid, null, null);
    }

    public static Logger getLogger() {
        return logger;
    }
    
    public static void setLogger(Logger logger) {
        if (logger == null) {
            return;
        }

        FanartTv.logger = logger;
        logConsoleHandler.setFormatter(logFormatter);
        logConsoleHandler.setLevel(Level.FINE);
        logger.addHandler(logConsoleHandler);
        logger.setUseParentHandlers(false);
        logger.setLevel(Level.ALL);
    }

    /**
     * Set proxy parameters.
     * @param host proxy host URL
     * @param port proxy port
     * @param username proxy username
     * @param password proxy password
     */
    public void setProxy(String host, String port, String username, String password) {
        WebBrowser.setProxyHost(host);
        WebBrowser.setProxyPort(port);
        WebBrowser.setProxyUsername(username);
        WebBrowser.setProxyPassword(password);
    }

    /**
     * Set web browser timeout.
     * @param webTimeoutConnect
     * @param webTimeoutRead
     */
    public void setTimeout(int webTimeoutConnect, int webTimeoutRead) {
        WebBrowser.setWebTimeoutConnect(webTimeoutConnect);
        WebBrowser.setWebTimeoutRead(webTimeoutRead);
    }

    /**
     * Build the URL that is used to get the XML from TMDb.
     *
     * @param tvdbid        The tvdbid to search with (mandatory)
     * @param artworkType   The type of the artwork to limit the search too. Blank/null gets all artwork
     * @param artworkSortBy Added for completeness, but not used
     * @return              The search URL
     */
    private static String buildUrl(int tvdbid, String artworkType, String artworkSortBy) {
        String searchUrl = API_SITE + "id=" + (tvdbid < 0 ? 0 : tvdbid);

        if (FanartTvArtwork.validateType(artworkType)) {
            searchUrl += "&type=" + artworkType;
        }
        
        if (isValidString(artworkSortBy)) {
            searchUrl += "&sort=" + artworkSortBy;
        }

        logger.finest("Search URL: " + searchUrl);
        return searchUrl;
    }

    /**
     * Check the string passed to see if it contains a value.
     * @param testString The string to test
     * @return False if the string is empty, null or UNKNOWN, True otherwise
     */
    public static boolean isValidString(String testString) {
        if ((testString == null)
                || ("".equals(testString.trim()))
                || (FanartTvArtwork.UNKNOWN.equalsIgnoreCase(testString))) {
            return false;
        }
        return true;
    }
}
