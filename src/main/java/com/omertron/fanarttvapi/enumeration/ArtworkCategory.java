/*
 *      Copyright (c) 2004-2016 Stuart Boston
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
package com.omertron.fanarttvapi.enumeration;

import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Stuart.Boston
 */
public enum ArtworkCategory {
    HDTVLOGO,
    HDCLEARART,
    CHARACTERART,
    CLEARLOGO,
    CLEARART,
    SHOWBACKGROUND,
    TVTHUMB,
    SEASONPOSTER,
    SEASONTHUMB,
    TVBANNER,
    TVPOSTER,
    SEASONBANNER;

    /**
     * Convert a string into an Enum type.
     *
     * @param category
     * @return
     * @throws IllegalArgumentException If type is not recognised
     */
    public static ArtworkCategory fromString(String category) {
        if (StringUtils.isNotBlank(category)) {
            try {
                return ArtworkCategory.valueOf(category.trim().toUpperCase());
            } catch (IllegalArgumentException ex) {
                throw new IllegalArgumentException("ArtworkCategory '" + category + "' does not exist.", ex);
            }
        }
        throw new IllegalArgumentException("ArtworkCategory must not be null");
    }
}
