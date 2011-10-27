/*
 *      Copyright (c) 2004-2011 YAMJ Members
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

import java.util.ArrayList;
import java.util.List;

import com.moviejukebox.fanarttv.FanartTv;

public class FanartTvArtwork {

    private String type;
    private String url;
    
    public static final String UNKNOWN = "UNKNOWN";
    
    public static final String TYPE_CLEARART    = "clearart";
    public static final String TYPE_CLEARLOGO   = "clearlogo";
    public static final String TYPE_SEASONTHUMB = "seasonthumb";
    public static final String TYPE_TVTHUMB     = "tvthumb";
    
    public static final String SORT_NAME_ASC    = "nameasc";
    public static final String SORT_NAME_DESC   = "namedesc";
    public static final String SORT_FAV_ASC     = "favasc";
    public static final String SORT_FAV_DESC    = "favdesc";
    
    public static final int VERSION_IMAGE       = 3;
    public static final int VERSION_CHARACTER   = 4;
    
    private static List<String> artworkTypes = new ArrayList<String>();
    private static List<String> artworkSorts = new ArrayList<String>();
    
    static {
        artworkTypes.add(TYPE_CLEARART);
        artworkTypes.add(TYPE_CLEARLOGO);
        artworkTypes.add(TYPE_SEASONTHUMB);
        artworkTypes.add(TYPE_TVTHUMB);
        
        artworkSorts.add(SORT_FAV_ASC);
        artworkSorts.add(SORT_FAV_DESC);
        artworkSorts.add(SORT_NAME_ASC);
        artworkSorts.add(SORT_NAME_DESC);
    }
    
    public FanartTvArtwork(String type, String url) {
        this.type = type;
        this.url = url;
    }

    public FanartTvArtwork() {
        this.type = UNKNOWN;
        this.url = UNKNOWN;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        if (validateType(type)) {
            this.type = type.toLowerCase();
        }
    }

    /**
     * @return the URL
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the URL to set
     */
    public void setUrl(String url) {
        this.url = url;
    }
    
    /**
     * Validate that the artworkType is one of the known values
     * @param artworkType
     * @return
     */
    public static boolean validateType(String artworkType) {
        if (!FanartTv.isValidString(artworkType)) {
            return false;
        }

        if (artworkTypes.contains(artworkType.toLowerCase())) {
            return true;
        }
        
        return false;
    }
    
    /**
     * Validate that the artworkSort is one of the known values
     * @param artworkSort
     * @return
     */
    public static boolean validateSort(String artworkSort) {
        if (!FanartTv.isValidString(artworkSort)) {
            return false;
        }
        
        if (artworkSorts.contains(artworkSort.toLowerCase())) {
            return true;
        }
        
        return false;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[FanartTvArtwork=[type=");
        builder.append(type);
        builder.append("][url=");
        builder.append(url);
        builder.append("]]");
        return builder.toString();
    }

}
