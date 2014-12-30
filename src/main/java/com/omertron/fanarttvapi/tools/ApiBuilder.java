/*
 *      Copyright (c) 2004-2015 Stuart Boston
 *
 *      This file is part of the FanartTV API.
 *
 *      The FanartTV API is free software: you can redistribute it and/or modify
 *      it under the terms of the GNU General Public License as published by
 *      the Free Software Foundation, either version 3 of the License, or
 *      any later version.
 *
 *      The FanartTV API is distributed in the hope that it will be useful,
 *      but WITHOUT ANY WARRANTY; without even the implied warranty of
 *      MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *      GNU General Public License for more details.
 *
 *      You should have received a copy of the GNU General Public License
 *      along with the FanartTV API.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package com.omertron.fanarttvapi.tools;

import com.omertron.fanarttvapi.FanartTvException;
import com.omertron.fanarttvapi.enumeration.BaseType;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Build the API URL that is used to fetch the data
 *
 * @author stuart.boston
 */
public final class ApiBuilder {
    /*
     * Logger
     */

    private static final Logger LOG = LoggerFactory.getLogger(ApiBuilder.class);
    /*
     * FanartTV API Base URL
     */
    private static final String API_BASE = "http://webservice.fanart.tv/v3/";
    private static final String API_TV = "tv/";
    private static final String API_MOVIES = "movies/";
    private static final String API_MUSIC_ARTIST = "music/";
    private static final String API_MUSIC_ALBUMS = "music/albums/";
    private static final String API_MUSIC_LABELS = "music/labels/";
    private static final String API_LATEST = "latest";
    /*
     * API Keys
     */
    private final String apiKey;
    private final String clientKey;
    /*
     * Parameter configuration
     */
    private static final String DELIMITER = "?";
    private static final String DELIMITER_APIKEY = "?api_key=";
    private static final String DELIMITER_CLIENT_KEY = "&client_key=";
    /*
     * Constants
     */
    private static final String FAILED_TO_CREATE_URL = "Failed to create URL: {} - {}";
    private static final String URL = "URL: {}";

    public ApiBuilder(String apiKey) {
        this.apiKey = apiKey;
        this.clientKey = null;
    }

    public ApiBuilder(String apiKey, String clientKey) {
        this.apiKey = apiKey;
        this.clientKey = clientKey;
    }

    private StringBuilder getBaseUrl(BaseType baseType) {
        StringBuilder url = new StringBuilder(API_BASE);

        if (baseType == BaseType.TV) {
            url.append(API_TV);
        } else if (baseType == BaseType.MOVIE) {
            url.append(API_MOVIES);
        } else if (baseType == BaseType.ALBUM) {
            url.append(API_MUSIC_ALBUMS);
        } else if (baseType == BaseType.ARTIST) {
            url.append(API_MUSIC_ARTIST);
        } else if (baseType == BaseType.LABEL) {
            url.append(API_MUSIC_LABELS);
        }
        return url;
    }

    /**
     * Generate the URL for the artwork requests
     *
     * @param baseType
     * @param id
     * @return
     * @throws FanartTvException
     */
    public URL getImageUrl(BaseType baseType, String id) throws FanartTvException {
        StringBuilder url = getBaseUrl(baseType);

        // Add the ID
        url.append(id);

        // Add the API Key
        url.append(DELIMITER_APIKEY).append(apiKey);

        // Add the client API Key
        if (StringUtils.isNotBlank(clientKey)) {
            url.append(DELIMITER_CLIENT_KEY).append(clientKey);
        }

        return convertUrl(url);
    }

    /**
     * Generate the URL for the "latest" requests
     *
     * @param baseType
     * @param date
     * @return
     * @throws FanartTvException
     */
    public URL getLatestUrl(BaseType baseType, String date) throws FanartTvException {
        StringBuilder url = getBaseUrl(baseType);

        url.append(API_LATEST);

        // Add the API Key
        url.append(DELIMITER_APIKEY).append(apiKey);

        // Add the client API Key
        if (StringUtils.isNotBlank(clientKey)) {
            url.append(DELIMITER_CLIENT_KEY).append(clientKey);
        }

        // Add the Date
        url.append(DELIMITER).append(date);

        return convertUrl(url);
    }

    /**
     * Convert the string into a URL
     *
     * @param searchUrl
     * @return
     * @throws FanartTvException
     */
    private URL convertUrl(StringBuilder searchUrl) throws FanartTvException {
        try {
            LOG.trace(URL, searchUrl.toString());
            return new URL(searchUrl.toString());
        } catch (MalformedURLException ex) {
            LOG.warn(FAILED_TO_CREATE_URL, searchUrl.toString(), ex.toString());
            throw new FanartTvException(FanartTvException.FanartTvExceptionType.INVALID_URL, searchUrl.toString(), ex);
        }
    }

}
