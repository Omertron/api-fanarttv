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

    public int getValue() {
        return sortType;
    }

    public static FTArtworkSort fromString(String artworkSort) {
        if (artworkSort != null) {
            try {
                return FTArtworkSort.valueOf(artworkSort.trim().toUpperCase());
            } catch (IllegalArgumentException ex) {
                throw new IllegalArgumentException("No FTArtworkSort " + artworkSort + " exists");
            }
        }
        throw new IllegalArgumentException("No FTArtworkSort " + artworkSort + " exists");
    }
}
