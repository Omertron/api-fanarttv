/*
 *      Copyright (c) 2004-2012 YAMJ Members
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

import com.moviejukebox.fanarttv.FanartTvException.FanartTvExceptionType;
import com.moviejukebox.fanarttv.model.FanartTvArtwork;
import com.moviejukebox.fanarttv.model.WrapperSeries;
import com.moviejukebox.fanarttv.tools.FilteringLayout;
import com.moviejukebox.fanarttv.tools.WebBrowser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * This is the main class for the API to connect to Fanart.TV
 * http://fanart.tv/api-info/
 *
 * @author Stuart.Boston
 * @version 1.1
 *
 * TODO Allow a selection of the artwork types to be selected rather than 1 or
 * ALL
 */
public class FanartTv {

    private static final Logger LOGGER = Logger.getLogger(FanartTv.class);
    private String apiKey;
    private static final String API_FORMAT = "json";
    /*
     * URL for the API
     */
    private static final String API_SITE = "http://fanart.tv/webservice/";
    private static final String API_SERIES = "series/";
    private static final String API_MOVIE = "movie/";
    private static final String API_MUSIC = "music/";
    /*
     * Defaults for the API
     */
    private static final int DEFAULT_ARTWORK_LIMIT = 2;
    private static final int DEFAULT_ARTWORK_SORT = 1;
    private static final String DEFAULT_ARTWORK_TYPE = "all";

    /*
     * Jackson JSON configuration
     */
    private static ObjectMapper mapper = new ObjectMapper();

    public FanartTv(String apiKey) {
        this.apiKey = apiKey;
        FilteringLayout.addApiKey(apiKey);
    }

    /**
     * Get the artwork for a specific TVDb ID, limited by type and/or sorted
     *
     * @param tvdbid
     * @param artworkType
     * @param artworkSortBy
     * @return
     */
    public List<FanartTvArtwork> getArtwork(int tvdbid, String artworkType, int artworkSortBy, int artworkLimit) throws FanartTvException {
        String searchUrl = buildSeriesUrl(tvdbid, artworkType, artworkSortBy, artworkLimit);

        String webPage;
        try {
            webPage = WebBrowser.request(searchUrl);
        } catch (IOException ex) {
            throw new FanartTvException(FanartTvExceptionType.INVALID_URL, searchUrl);
        }

        JsonNode jn;
        try {
            jn = mapper.readTree(webPage);
        } catch (JsonProcessingException ex) {
            throw new FanartTvException(FanartTvExceptionType.MAPPING_FAILED, "Failed processing JSON Node");
        } catch (IOException ex) {
            throw new FanartTvException(FanartTvExceptionType.MAPPING_FAILED, "Failed processing JSON Node");
        }

        Iterator<String> ftNode = jn.getFieldNames();
        while (ftNode.hasNext()) {
            WrapperSeries ws;
            try {
                ws = mapper.readValue(jn.get(ftNode.next()), WrapperSeries.class);
            } catch (JsonParseException ex) {
                throw new FanartTvException(FanartTvExceptionType.MAPPING_FAILED, ex.getMessage());
            } catch (JsonMappingException ex) {
                throw new FanartTvException(FanartTvExceptionType.MAPPING_FAILED, ex.getMessage());
            } catch (IOException ex) {
                throw new FanartTvException(FanartTvExceptionType.MAPPING_FAILED, ex.getMessage());
            }
            ArrayList<FanartTvArtwork> artwork = new ArrayList<FanartTvArtwork>();

            if (ws.getClearArt() != null) {
                for (FanartTvArtwork ftSingle : ws.getClearArt()) {
                    ftSingle.setType(FanartTvArtwork.TYPE_CLEARART);
                    artwork.add(ftSingle);
                }
            }

            if (ws.getClearLogo() != null) {
                for (FanartTvArtwork ftSingle : ws.getClearLogo()) {
                    ftSingle.setType(FanartTvArtwork.TYPE_CLEARLOGO);
                    artwork.add(ftSingle);
                }
            }

            if (ws.getSeasonThumb() != null) {
                for (FanartTvArtwork ftSingle : ws.getSeasonThumb()) {
                    ftSingle.setType(FanartTvArtwork.TYPE_SEASONTHUMB);
                    artwork.add(ftSingle);
                }
            }

            if (ws.getTvThumb() != null) {
                for (FanartTvArtwork ftSingle : ws.getTvThumb()) {
                    ftSingle.setType(FanartTvArtwork.TYPE_TVTHUMB);
                    artwork.add(ftSingle);
                }
            }
            return artwork;
        }
        throw new FanartTvException(FanartTvExceptionType.MAPPING_FAILED, "No JSON data found");
    }

    /**
     * Get all the artwork of a type for a TVDb ID, sorted.
     *
     * @param tvdbid
     * @param artworkType
     * @param artworkSortBy
     * @return
     */
    public List<FanartTvArtwork> getArtwork(int tvdbid, String artworkType, int artworkSortBy) throws FanartTvException {
        return getArtwork(tvdbid, artworkType, artworkSortBy, DEFAULT_ARTWORK_LIMIT);
    }

    /**
     * Get all the artwork of a type for a TVDb ID
     *
     * @param tvdbid
     * @param artworkType
     * @return
     */
    public List<FanartTvArtwork> getArtwork(int tvdbid, String artworkType) throws FanartTvException {
        return getArtwork(tvdbid, artworkType, DEFAULT_ARTWORK_SORT, DEFAULT_ARTWORK_LIMIT);
    }

    /**
     * Get all the artwork for a specific TVDb ID
     *
     * @param tvdbid
     * @return
     */
    public List<FanartTvArtwork> getArtwork(int tvdbid) throws FanartTvException {
        return getArtwork(tvdbid, DEFAULT_ARTWORK_TYPE, DEFAULT_ARTWORK_SORT, DEFAULT_ARTWORK_LIMIT);
    }

    /**
     * Set proxy parameters.
     *
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
     *
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
     * Basic Usage:
     * http://fanart.tv/api/fanart.php?id=<thetvdb_id>[&type=type][&sort=sortby][&v=version]
     * The <id> is mandatory and must correspond to a shows id on the thetvdb
     * website. Both [type] and [sortby] are optional, if neither is specified,
     * by default a list of all will be returned, sorted by name ascending. The
     * v argument can either be omitted, set at 3 or 4. If set at 3 the image id
     * is added to the xml for scripts that integrate with the like feature. The
     * script needs to be set to 4 in order to show CharacterART, this is to
     * ensure backwards compatability.
     *
     * @param tvdbid The tvdbid to search with (mandatory)
     * @param artworkType The type of the artwork to limit the search too.
     * Blank/null gets all artwork
     * @param artworkSortBy Added for completeness, but not used
     * @return The search URL
     */
    private String buildSeriesUrl(int tvdbid, String artworkType, int artworkSortBy, int artworkLimit) {
        //http://fanart.tv/webservice/series/apikey/thetvdb_id/format/type/sort/limit/
        StringBuilder searchUrl = new StringBuilder(API_SITE);

        searchUrl.append(API_SERIES);

        searchUrl.append(apiKey).append("/");
        searchUrl.append(tvdbid < 0 ? 0 : tvdbid).append("/");
        searchUrl.append(API_FORMAT).append("/");

        if (FanartTvArtwork.validateType(artworkType)) {
            searchUrl.append(artworkType).append("/");
        }

        // SortBy can be 1,2 or 3
        if (artworkSortBy > 0) {
            if (artworkSortBy > 3) {
                searchUrl.append(0);
            } else {
                searchUrl.append(artworkSortBy).append("/");
            }
        }

        if (artworkLimit > 0) {
            searchUrl.append(Math.max(artworkLimit, 2)).append("/");
        }

        LOGGER.debug("Search URL: " + searchUrl);
        return searchUrl.toString();
    }

    /**
     * Check the string passed to see if it contains a value.
     *
     * @param testString The string to test
     * @return False if the string is empty, null or UNKNOWN, True otherwise
     */
    public static boolean isValidString(String testString) {
        if (StringUtils.isBlank(testString) || (FanartTvArtwork.UNKNOWN.equalsIgnoreCase(testString))) {
            return false;
        }
        return true;
    }
}
