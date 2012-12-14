/*
 *      Copyright (c) 2004-2012 Stuart Boston
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

/**
 * Exception type for Fanart.TV API
 *
 * @author stuart.boston
 */
public class FanartTvException extends Exception {

    private static final long serialVersionUID = -8952129102483143278L;

    public enum FanartTvExceptionType {

        UNKNOWN_CAUSE, INVALID_URL, HTTP_404_ERROR, ID_NOT_FOUND, MAPPING_FAILED, CONNECTION_ERROR;
    }
    private final FanartTvExceptionType exceptionType;
    private final String response;

    /**
     * Raise an exception with a response and a pre-existing stack
     *
     * @param exceptionType
     * @param response
     * @param cause
     */
    public FanartTvException(final FanartTvExceptionType exceptionType, final String response, final Throwable cause) {
        super(cause);
        this.exceptionType = exceptionType;
        this.response = response;
    }

    /**
     * Raise a new exception
     *
     * @param exceptionType
     * @param response
     */
    public FanartTvException(final FanartTvExceptionType exceptionType, final String response) {
        super();
        this.exceptionType = exceptionType;
        this.response = response;
    }

    /**
     * Get the type for the exception
     *
     * @return
     */
    public FanartTvExceptionType getExceptionType() {

        return exceptionType;
    }

    /**
     * Get the response for the exception
     *
     * @return
     */
    public String getResponse() {

        return response;
    }
}
