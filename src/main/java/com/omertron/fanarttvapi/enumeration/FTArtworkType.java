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
import static com.omertron.fanarttvapi.enumeration.FTSourceType.*;

/**
 * List if the artwork types for Fanart.TV Artwork
 *
 * @author Stuart
 */
public enum FTArtworkType {

    // TV Artwork
    CLEARART(TV),
    CLEARLOGO(TV),
    SEASONTHUMB(TV),
    TVTHUMB(TV),
    CHARACTERART(TV),
    SHOWBACKGROUND(TV),
    HDTVLOGO(TV),
    HDCLEARART(TV),
    TVPOSTER(TV),
    TVBANNER(TV),
    SEASONPOSTER(TV),
    SEASONBANNER(TV),
    // Movie Artwork Types
    MOVIELOGO(MOVIE),
    MOVIEDISC(MOVIE),
    MOVIEART(MOVIE),
    MOVIEBACKGROUND(MOVIE),
    MOVIETHUMB(MOVIE),
    MOVIEBANNER(MOVIE),
    HDMOVIELOGO(MOVIE),
    HDMOVIECLEARART(MOVIE),
    MOVIEPOSTER(MOVIE),
    // Music Artwork Types
    CDART(MUSIC),
    ARTISTBACKGROUND(MUSIC),
    ALBUMCOVER(MUSIC),
    MUSICLOGO(MUSIC),
    ARTISTTHUMB(MUSIC),
    HDMUSICLOGO(MUSIC),
    MUSICBANNER(MUSIC);

    private final FTSourceType sourceType;

    private FTArtworkType(FTSourceType sourceType) {
        this.sourceType = sourceType;
    }

    /**
     * Get the source type for the artwork type
     *
     * @return
     */
    public FTSourceType getSourceType() {
        return sourceType;
    }

    /**
     * Get the source type for the artwork type
     *
     * @return
     */
    public FTSourceType source() {
        return getSourceType();
    }

    /**
     * Convert a string into an Enum type.
     *
     * @param artworkType
     * @return
     * @throws IllegalArgumentException If type is not recognised
     */
    public static FTArtworkType fromString(String artworkType) {
        if (StringUtils.isNotBlank(artworkType)) {
            try {
                return FTArtworkType.valueOf(artworkType.trim().toUpperCase());
            } catch (IllegalArgumentException ex) {
                throw new IllegalArgumentException("FTArtworkType " + artworkType + " does not exist.", ex);
            }
        }
        throw new IllegalArgumentException("FTArtworkType must not be null");
    }
}
