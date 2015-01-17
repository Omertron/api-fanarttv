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

/**
 * Enumeration for the possible errors returned by the API
 *
 * @author Stuart.Boston
 */
public enum ApiExceptionType {

    /**
     * Unknown error occured
     */
    UNKNOWN_CAUSE,
    /**
     * URL is invalid
     */
    INVALID_URL,
    /**
     * The ID was not found
     */
    ID_NOT_FOUND,
    /**
     * Mapping failed from target to internal objects
     */
    MAPPING_FAILED,
    /**
     * Error connecting to the service
     */
    CONNECTION_ERROR,
    /**
     * Image was invalid
     */
    INVALID_IMAGE,
    /**
     * Autorisation rejected
     */
    AUTHORISATION_FAILURE,
    /**
     * Page not found
     */
    HTTP_404_ERROR,
    /**
     * Service Unavailable, usually temporary
     */
    HTTP_503_ERROR;

}
