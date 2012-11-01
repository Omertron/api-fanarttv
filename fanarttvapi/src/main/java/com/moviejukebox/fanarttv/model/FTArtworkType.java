/*
 *      Copyright (c) 2004-2012 Stuart Boston
 *
 *      This software is licensed under a Creative Commons License
 *      See the LICENCE.txt file included in this package
 *
 *      For any reuse or distribution, you must make clear to others the
 *      license terms of this work.
 */
package com.moviejukebox.fanarttv.model;

import org.apache.commons.lang3.StringUtils;

/**
 * List if the artwork types for Fanart.TV Artwork
 *
 * @author Stuart
 */
public enum FTArtworkType {

    ALL(FTSourceType.ALL),
    // TV Artwork
    CLEARART(FTSourceType.TV),
    CLEARLOGO(FTSourceType.TV),
    SEASONTHUMB(FTSourceType.TV),
    TVTHUMB(FTSourceType.TV),
    CHARACTERART(FTSourceType.TV),
    SHOWBACKGROUND(FTSourceType.TV),
    HDTVLOGO(FTSourceType.TV),
    HDCLEARART(FTSourceType.TV),
    // Movie Artwork Types
    MOVIELOGO(FTSourceType.MOVIE),
    MOVIEDISC(FTSourceType.MOVIE),
    MOVIEART(FTSourceType.MOVIE),
    MOVIEBACKGROUND(FTSourceType.MOVIE),
    MOVIETHUMB(FTSourceType.MOVIE),
    MOVIEBANNER(FTSourceType.MOVIE),
    HDMOVIELOGO(FTSourceType.MOVIE),
    // Music Artwork Types
    CDART(FTSourceType.MUSIC),
    ARTISTBACKGROUND(FTSourceType.MUSIC),
    ALBUMCOVER(FTSourceType.MUSIC),
    MUSICLOGO(FTSourceType.MUSIC);
    private FTSourceType sourceType;

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
