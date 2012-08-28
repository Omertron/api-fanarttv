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

import java.io.Serializable;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Artwork from Fanart.TV
 *
 * @author stuart.boston
 */
public class FanartTvArtwork implements Serializable {

    private static final Logger LOGGER = Logger.getLogger(FanartTvArtwork.class);
    private static final long serialVersionUID = 1L;

    /*
     * Static Types
     */
    public static final String UNKNOWN = "UNKNOWN";
    /*
     * Versions
     */
    public static final int VERSION_IMAGE = 3;
    public static final int VERSION_CHARACTER = 4;
    /*
     * Data model
     */
    private FTArtworkType type;
    @JsonProperty("id")
    private int id;
    @JsonProperty("url")
    private String url;
    @JsonProperty("lang")
    private String language;
    @JsonProperty("likes")
    private int likes;
    private int season;
    @JsonProperty("disc")
    private int disc;
    @JsonProperty("disc_type")
    private String discType;

    /**
     * Constructor for artwork using type and URL
     *
     * @param type
     * @param url
     */
    public FanartTvArtwork(String type, String url) {
        this.type = FTArtworkType.fromString(type);
        this.url = url;
    }

    /**
     * Constructor for default artwork. Will have a type of "ALL"
     */
    public FanartTvArtwork() {
        this.type = FTArtworkType.ALL;
        this.url = UNKNOWN;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type.toString();
    }

    /**
     * @param type the type to set
     */
    @JsonProperty("type")
    public void setType(String type) {
        if (validateType(type)) {
            this.type = FTArtworkType.fromString(type);
        }
    }

    /**
     * @param type the type to set
     */
    public void setType(FTArtworkType type) {
        this.type = type;
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
     * @return the ID of the artwork
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the ID of the artwork
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return Language of the artwork
     */
    public String getLanguage() {
        return language;
    }

    /**
     *
     * @param language Language of the artwork
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     *
     * @return How many likes the artwork has
     */
    public int getLikes() {
        return likes;
    }

    /**
     *
     * @param likes Set how many likes the artwork has
     */
    public void setLikes(int likes) {
        this.likes = likes;
    }

    /**
     *
     * @return Season for the artwork
     */
    public int getSeason() {
        return season;
    }

    /**
     *
     * @param season Season for the artwork
     */
    @JsonProperty("season")
    public void setSeason(String season) {
        if (StringUtils.isNumeric(season)) {
            this.season = Integer.parseInt(season);
        } else {
            this.season = -1;
        }
    }

    /**
     *
     * @return Disc number for the artwork
     */
    public int getDisc() {
        return disc;
    }

    /**
     *
     * @param disc Disc number for the artwork
     */
    public void setDisc(int disc) {
        this.disc = disc;
    }

    /**
     *
     * @return Disc type for the artwork
     */
    public String getDiscType() {
        return discType;
    }

    /**
     *
     * @param discType Disc type for the artwork
     */
    public void setDiscType(String discType) {
        this.discType = discType;
    }

    /**
     * Validate that the artworkType is one of the known values
     *
     * @param artworkType
     * @return
     */
    public static boolean validateType(String artworkType) {
        try {
            // Try and convert the type to a type.
            FTArtworkType.fromString(artworkType);
            return true;
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }

    /**
     * Validate that the artworkSort is one of the known values
     *
     * @param artworkSort
     * @return
     */
    public static boolean validateSort(String artworkSort) {
        try {
            // Try and convert the sort to a type.
            FTArtworkSort.fromString(artworkSort);
            return true;
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }

    /**
     * @return String representation of the object
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[FanartTvArtwork=[");
        builder.append("[type=").append(type);
        builder.append("],[id=").append(id);
        builder.append("],[url=").append(url);
        builder.append("],[lang=").append(language);
        builder.append("],[likes=").append(likes);
        builder.append("],[season=").append(season);
        builder.append("],[disc=").append(disc);
        builder.append("],[discType=").append(discType);
        builder.append("]]");
        return builder.toString();
    }

    /**
     * Handle unknown properties and print a message
     *
     * @param key
     * @param value
     */
    @JsonAnySetter
    public void handleUnknown(String key, Object value) {
        StringBuilder sb = new StringBuilder();
        sb.append("Unknown property: '").append(key);
        sb.append("' value: '").append(value).append("'");
        LOGGER.warn(sb.toString());
    }
}
