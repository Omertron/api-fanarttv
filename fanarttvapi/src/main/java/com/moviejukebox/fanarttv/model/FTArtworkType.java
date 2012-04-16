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

/**
 * List if the artwork types for Fanart.TV Artwork
 *
 * @author Stuart
 */
public enum FTArtworkType {

    ALL,
    // TV Artwork
    CLEARART,
    CLEARLOGO,
    SEASONTHUMB,
    TVTHUMB,
    CHARACTERART,
    // Movie Artwork Types
    MOVIELOGO,
    MOVIEDISC,
    MOVIEART,
    // Music Artwork Types
    CDART,
    ARTISTBACKGROUNDS,
    ALBUMCOVER,
    MUSICLOGOS;

    public static FTArtworkType fromString(String artworkType) {
        if (artworkType != null) {
            try {
                return FTArtworkType.valueOf(artworkType.trim().toUpperCase());
            } catch (IllegalArgumentException ex) {
                throw new IllegalArgumentException("No FTArtworkType " + artworkType + " exists");
            }
        }
        throw new IllegalArgumentException("No FTArtworkType " + artworkType + " exists");
    }

}
