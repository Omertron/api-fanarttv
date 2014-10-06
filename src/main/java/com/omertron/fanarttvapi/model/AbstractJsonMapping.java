/*
 *      Copyright (c) 2004-2014 Stuart Boston
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
package com.omertron.fanarttvapi.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Abstract class to handle any unknown properties by outputting a log message
 *
 * @author stuart.boston
 */
public abstract class AbstractJsonMapping implements Serializable {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    /*
     * Error fields
     */
    @JsonProperty("status")
    private String status;
    @JsonProperty("error message")
    private String errorMessage;
    private boolean error = Boolean.FALSE;

    /**
     * Handle unknown properties and print a message
     *
     * @param key
     * @param value
     */
    @JsonAnySetter
    protected void handleUnknown(String key, Object value) {
        StringBuilder unknown = new StringBuilder(this.getClass().getSimpleName());
        unknown.append(": Unknown property='").append(key);
        unknown.append("' value='").append(value).append("'");

        log.trace(unknown.toString());
    }

    @Override
    public String toString() {
        final ReflectionToStringBuilder reflectionToStringBuilder
                = new ReflectionToStringBuilder(this);
        reflectionToStringBuilder.setExcludeFieldNames(
                new String[]{"status", "errorMessage", "error", "log"});
        return reflectionToStringBuilder.toString();
//        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
        this.error = Boolean.TRUE;  // Set the error to true
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        this.error = Boolean.TRUE;  // Set the error to true
    }

    public boolean isError() {
        return error;
    }
}
