/*
 *      Copyright (c) 2004-2013 Stuart Boston
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
