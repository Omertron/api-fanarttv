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
import com.moviejukebox.fanarttv.model.WrapperMovie;
import com.moviejukebox.fanarttv.model.WrapperSeries;
import com.moviejukebox.fanarttv.tools.FilteringLayout;
import com.moviejukebox.fanarttv.tools.WebBrowser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
     * Get the artwork for a specific video
     *
     * @param searchUrl
     * @return
     */
    private List<FanartTvArtwork> readTvArtwork(String searchUrl) throws FanartTvException {
        String webPage;
        try {
            webPage = WebBrowser.request(searchUrl);
        } catch (IOException ex) {
            throw new FanartTvException(FanartTvExceptionType.INVALID_URL, searchUrl, ex);
        }

        // Strip the wrapper from the json returned
        JsonNode jn;
        try {
            jn = mapper.readTree(webPage);
        } catch (JsonProcessingException ex) {
            throw new FanartTvException(FanartTvExceptionType.MAPPING_FAILED, "Failed processing JSON Node", ex);
        } catch (IOException ex) {
            throw new FanartTvException(FanartTvExceptionType.MAPPING_FAILED, "Failed processing JSON Node", ex);
        }

        Iterator<String> ftNode = jn.getFieldNames();
        while (ftNode.hasNext()) {
            WrapperSeries ws;
            try {
                ws = mapper.readValue(jn.get(ftNode.next()), WrapperSeries.class);
            } catch (JsonParseException ex) {
                throw new FanartTvException(FanartTvExceptionType.MAPPING_FAILED, null, ex);
            } catch (JsonMappingException ex) {
                throw new FanartTvException(FanartTvExceptionType.MAPPING_FAILED, null, ex);
            } catch (IOException ex) {
                throw new FanartTvException(FanartTvExceptionType.MAPPING_FAILED, null, ex);
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
     * Get the artwork for a specific video
     *
     * @param searchUrl
     * @return
     */
    private List<FanartTvArtwork> readMovieArtwork(String searchUrl) throws FanartTvException {
        String webPage;
        try {
            webPage = WebBrowser.request(searchUrl);
        } catch (IOException ex) {
            throw new FanartTvException(FanartTvExceptionType.INVALID_URL, searchUrl, ex);
        }

        // Strip the wrapper from the json returned
        JsonNode jn;
        try {
            jn = mapper.readTree(webPage);
        } catch (JsonProcessingException ex) {
            throw new FanartTvException(FanartTvExceptionType.MAPPING_FAILED, "Failed processing JSON Node", ex);
        } catch (IOException ex) {
            throw new FanartTvException(FanartTvExceptionType.MAPPING_FAILED, "Failed processing JSON Node", ex);
        }

        Iterator<String> ftNode = jn.getFieldNames();
        while (ftNode.hasNext()) {
            WrapperMovie ws;
            try {
                ws = mapper.readValue(jn.get(ftNode.next()), WrapperMovie.class);
            } catch (JsonParseException ex) {
                throw new FanartTvException(FanartTvExceptionType.MAPPING_FAILED, null, ex);
            } catch (JsonMappingException ex) {
                throw new FanartTvException(FanartTvExceptionType.MAPPING_FAILED, null, ex);
            } catch (IOException ex) {
                throw new FanartTvException(FanartTvExceptionType.MAPPING_FAILED, null, ex);
            }
            ArrayList<FanartTvArtwork> artwork = new ArrayList<FanartTvArtwork>();

            if (ws.getMovieLogo() != null) {
                for (FanartTvArtwork ftSingle : ws.getMovieLogo()) {
                    ftSingle.setType(FanartTvArtwork.TYPE_MOVIELOGO);
                    artwork.add(ftSingle);
                }
            }

            if (ws.getMovieDisc() != null) {
                for (FanartTvArtwork ftSingle : ws.getMovieDisc()) {
                    ftSingle.setType(FanartTvArtwork.TYPE_MOVIEDISC);
                    artwork.add(ftSingle);
                }
            }
            return artwork;
        }
        throw new FanartTvException(FanartTvExceptionType.MAPPING_FAILED, "No JSON data found");
    }

    /**
     * Get all the artwork of a type for a TVDb ID
     *
     * @param tvdbId
     * @param artworkType
     * @param artworkSortBy
     * @param artworkLimit
     * @return
     */
    public List<FanartTvArtwork> getTvArtwork(int tvdbId, String artworkType, int artworkSortBy, int artworkLimit) throws FanartTvException {
        return readTvArtwork(buildSeriesUrl(tvdbId, artworkType, artworkSortBy, artworkLimit));
    }

    /**
     * Get all the artwork of a type for a TVDb ID
     *
     * @param tvdbId
     * @param artworkType
     * @param artworkSortBy
     * @return
     */
    public List<FanartTvArtwork> getTvArtwork(int tvdbId, String artworkType, int artworkSortBy) throws FanartTvException {
        return getTvArtwork(tvdbId, artworkType, artworkSortBy, DEFAULT_ARTWORK_LIMIT);
    }

    /**
     * Get all the artwork of a type for a TVDb ID
     *
     * @param tvdbId
     * @param artworkType
     * @return
     */
    public List<FanartTvArtwork> getTvArtwork(int tvdbId, String artworkType) throws FanartTvException {
        return getTvArtwork(tvdbId, artworkType, DEFAULT_ARTWORK_SORT);
    }

    /**
     * Get all the artwork for a specific TVDb ID
     *
     * @param tvdbId
     * @return
     */
    public List<FanartTvArtwork> getTvArtwork(int tvdbId) throws FanartTvException {
        return getTvArtwork(tvdbId, DEFAULT_ARTWORK_TYPE);
    }

    /**
     * Get all the artwork for a specific TheMovieDb ID
     *
     * @param tmdbId
     * @return
     * @throws FanartTvException
     */
    public List<FanartTvArtwork> getMovieArtwork(int tmdbId) throws FanartTvException {
        return getMovieArtwork(tmdbId, DEFAULT_ARTWORK_TYPE);
    }

    /**
     * Get all the artwork for a specific TheMovieDb ID
     *
     * @param tmdbId
     * @param artworkType
     * @return
     * @throws FanartTvException
     */
    public List<FanartTvArtwork> getMovieArtwork(int tmdbId, String artworkType) throws FanartTvException {
        return getMovieArtwork(tmdbId, artworkType, DEFAULT_ARTWORK_SORT);
    }

    /**
     * Get all the artwork for a specific TheMovieDb ID
     *
     * @param tmdbId
     * @param artworkType
     * @param artworkSortBy
     * @return
     * @throws FanartTvException
     */
    public List<FanartTvArtwork> getMovieArtwork(int tmdbId, String artworkType, int artworkSortBy) throws FanartTvException {
        return getMovieArtwork(tmdbId, artworkType, artworkSortBy, DEFAULT_ARTWORK_LIMIT);
    }

    /**
     * Get all the artwork for a specific TheMovieDb ID
     *
     * @param tmdbId
     * @param artworkType
     * @param artworkSortBy
     * @param artworkLimit
     * @return
     * @throws FanartTvException
     */
    public List<FanartTvArtwork> getMovieArtwork(int tmdbId, String artworkType, int artworkSortBy, int artworkLimit) throws FanartTvException {
        return readMovieArtwork(buildMovieUrl(tmdbId, artworkType, artworkSortBy, artworkLimit));
    }

    /**
     * Get all the artwork for a specific IMDB ID
     *
     * @param imdbId
     * @return
     * @throws FanartTvException
     */
    public List<FanartTvArtwork> getMovieArtwork(String imdbId) throws FanartTvException {
        return getMovieArtwork(imdbId, DEFAULT_ARTWORK_TYPE);
    }

    /**
     * Get all the artwork for a specific IMDB ID
     *
     * @param imdbId
     * @param artworkType
     * @return
     * @throws FanartTvException
     */
    public List<FanartTvArtwork> getMovieArtwork(String imdbId, String artworkType) throws FanartTvException {
        return getMovieArtwork(imdbId, artworkType, DEFAULT_ARTWORK_SORT);
    }

    /**
     * Get all the artwork for a specific IMDB ID
     *
     * @param imdbId
     * @param artworkType
     * @param artworkSortBy
     * @return
     * @throws FanartTvException
     */
    public List<FanartTvArtwork> getMovieArtwork(String imdbId, String artworkType, int artworkSortBy) throws FanartTvException {
        return getMovieArtwork(imdbId, artworkType, artworkSortBy, DEFAULT_ARTWORK_LIMIT);
    }

    /**
     * Get all the artwork for a specific IMDB ID
     *
     * @param imdbId
     * @param artworkType
     * @param artworkSortBy
     * @param artworkLimit
     * @return
     * @throws FanartTvException
     */
    public List<FanartTvArtwork> getMovieArtwork(String imdbId, String artworkType, int artworkSortBy, int artworkLimit) throws FanartTvException {
        return readMovieArtwork(buildMovieUrl(imdbId, artworkType, artworkSortBy, artworkLimit));
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
     * Build the URL that is used to get the XML from Fanart.tv
     *
     * @param baseUrl
     * @param videoId The id for the video, one of TheMovieDB, IMDB or TheTVDb
     * @param artworkType The type of the artwork to limit the search too.
     * "all"/Blank/null gets all artwork
     * @param artworkSortBy Added for completeness, but not used
     * @return The search URL
     *
     */
    private String buildUrl(String baseUrl, String videoId, String artworkType, int artworkSortBy, int artworkLimit) {
        //http://fanart.tv/webservice/series/apikey/thetvdb_id/format/type/sort/limit/
        StringBuilder searchUrl = new StringBuilder(API_SITE);

        searchUrl.append(baseUrl);

        searchUrl.append(apiKey).append("/");
        searchUrl.append(videoId).append("/");
        searchUrl.append(API_FORMAT).append("/");

        if (FanartTvArtwork.validateType(artworkType)) {
            searchUrl.append(artworkType).append("/");
        }

        // SortBy can be 1, 2 or 3
        searchUrl.append(artworkSortBy > 0 && artworkSortBy < 4 ? artworkSortBy : DEFAULT_ARTWORK_SORT).append("/");

        if (artworkLimit > 0) {
            searchUrl.append(Math.max(artworkLimit, 2)).append("/");
        }

        LOGGER.debug("Search URL: " + searchUrl);
        return searchUrl.toString();
    }

    private String buildSeriesUrl(int tvdbId, String artworkType, int artworkSortBy, int artworkLimit) {
        String idString = String.valueOf(tvdbId < 0 ? 0 : tvdbId);
        return buildUrl(API_SERIES, idString, artworkType, artworkSortBy, artworkLimit);
    }

    private String buildMovieUrl(int tmdbId, String artworkType, int artworkSortBy, int artworkLimit) {
        String idString = String.valueOf(tmdbId < 0 ? 0 : tmdbId);
        return buildMovieUrl(idString, artworkType, artworkSortBy, artworkLimit);
    }

    private String buildMovieUrl(String imdbId, String artworkType, int artworkSortBy, int artworkLimit) {
        return buildUrl(API_MOVIE, imdbId, artworkType, artworkSortBy, artworkLimit);
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
