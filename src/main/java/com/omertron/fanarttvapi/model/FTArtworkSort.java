/*
 *      Copyright (c) 2004-2012 Stuart Boston
 *
 *      This software is licensed under a Creative Commons License
 *      See the LICENCE.txt file included in this package
 *
 *      For any reuse or distribution, you must make clear to others the
 *      license terms of this work.
 */
package com.omertron.fanarttvapi.model;

import org.apache.commons.lang3.StringUtils;

/**
 * List if the artwork sorts for Fanart.TV Artwork
 *
 * @author Stuart
 */
public enum FTArtworkSort {

    DEFAULT(1), POPULAR(1), NEWEST(2), OLDEST(3);
    private int sortType;

    private FTArtworkSort(int sortType) {
        this.sortType = sortType;
    }

    /**
     * Get the numerical sort value for the sort
     *
     * @return
     */
    public int getValue() {
        return sortType;
    }

    /**
     * Convert a string into an Enum type
     *
     * @param artworkSort
     * @return
     * @throws IllegalArgumentException If type is not recognised
     *
     */
    public static FTArtworkSort fromString(String artworkSort) {
        if (StringUtils.isNotBlank(artworkSort)) {
            try {
                return FTArtworkSort.valueOf(artworkSort.trim().toUpperCase());
            } catch (IllegalArgumentException ex) {
                throw new IllegalArgumentException("FTArtworkSort " + artworkSort + " does not exist.", ex);
            }
        }
        throw new IllegalArgumentException("FTArtworkSort must not be null");
    }
}
