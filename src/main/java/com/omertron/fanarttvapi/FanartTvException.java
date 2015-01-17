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
package com.omertron.fanarttvapi;

import java.net.URL;

public class FanartTvException extends Exception {

    private static final long serialVersionUID = 1L;

    private final ApiExceptionType exceptionType;
    private final String response;
    private final int responseCode;
    private final String url;

    public FanartTvException(final ApiExceptionType exceptionType, final String response) {
        this(exceptionType, response, 0, "");
    }

    public FanartTvException(final ApiExceptionType exceptionType, final String response, final URL url) {
        this(exceptionType, response, 0, url.toExternalForm());
    }

    public FanartTvException(final ApiExceptionType exceptionType, final String response, final int responseCode, final URL url) {
        this(exceptionType, response, responseCode, url.toExternalForm());
    }

    public FanartTvException(final ApiExceptionType exceptionType, final String response, final String url) {
        this(exceptionType, response, 0, url);
    }

    public FanartTvException(final ApiExceptionType exceptionType, final String response, final int responseCode, final String url) {
        super();
        this.exceptionType = exceptionType;
        this.response = response;
        this.responseCode = responseCode;
        this.url = url;
    }

    public FanartTvException(final ApiExceptionType exceptionType, final String response, final URL url, final Throwable cause) {
        this(exceptionType, response, 0, url.toExternalForm(), cause);
    }

    public FanartTvException(final ApiExceptionType exceptionType, final String response, final int responseCode, final URL url, final Throwable cause) {
        this(exceptionType, response, responseCode, url.toExternalForm(), cause);
    }

    public FanartTvException(final ApiExceptionType exceptionType, final String response, final String url, final Throwable cause) {
        this(exceptionType, response, 0, url, cause);
    }

    public FanartTvException(final ApiExceptionType exceptionType, final String response, final int responseCode, final String url, final Throwable cause) {
        super(cause);
        this.exceptionType = exceptionType;
        this.response = response;
        this.responseCode = responseCode;
        this.url = url;
    }

    //<editor-fold defaultstate="collapsed" desc="Property getters">
    public ApiExceptionType getExceptionType() {
        return exceptionType;
    }

    public String getResponse() {
        return response;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public String getUrl() {
        return url;
    }
    //</editor-fold>
}
