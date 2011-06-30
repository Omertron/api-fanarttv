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
    
    public static final String CLEARART    = "clearart";
    public static final String CLEARLOGO   = "clearlogo";
    public static final String SEASONTHUMB = "seasonthumb";
    public static final String TVTHUMB     = "tvthumb";
    
    public static final String UNKNOWN     = "UNKNOWN";
    
    private static List<String> artworkTypes = new ArrayList<String>();
    
    static {
        artworkTypes.add(CLEARART);
        artworkTypes.add(CLEARLOGO);
        artworkTypes.add(SEASONTHUMB);
        artworkTypes.add(TVTHUMB);
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
     * Validate that the artworkType is one of the know values
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

}
