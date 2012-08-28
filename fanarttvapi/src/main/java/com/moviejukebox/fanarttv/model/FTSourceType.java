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
package com.moviejukebox.fanarttv.model;

import org.apache.commons.lang3.StringUtils;

/**
 * The list of video types the artwork is intended for
 *
 * @author stuart.boston
 */
public enum FTSourceType {

    ALL,
    TV,
    MOVIE,
    MUSIC;

    /**
     * Convert a string into an Enum type.
     *
     * @param artworkType
     * @return
     * @throws IllegalArgumentException If type is not recognised
     */
    public static FTSourceType fromString(String artworkType) {
        if (StringUtils.isNotBlank(artworkType)) {
            try {
                return FTSourceType.valueOf(artworkType.trim().toUpperCase());
            } catch (IllegalArgumentException ex) {
                throw new IllegalArgumentException("FTSource " + artworkType + " does not exist.", ex);
            }
        }
        throw new IllegalArgumentException("FTSource must not be null");
    }
}