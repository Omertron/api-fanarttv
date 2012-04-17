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

public class FanartTvException extends Exception {

    private static final long serialVersionUID = -8952129102483143278L;

    public enum FanartTvExceptionType {

        UNKNOWN_CAUSE, INVALID_URL, HTTP_404_ERROR, ID_NOT_FOUND, MAPPING_FAILED, CONNECTION_ERROR;
    }
    private final FanartTvExceptionType exceptionType;
    private final String response;

    /**
     * Raise an exception with a response and a pre-existing stack
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
     * @return
     */
    public FanartTvExceptionType getExceptionType() {

        return exceptionType;
    }

    /**
     * Get the response for the exception
     * @return
     */
    public String getResponse() {

        return response;
    }
}
