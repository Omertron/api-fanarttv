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

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Artwork from Fanart.TV
 *
 * @author stuart.boston
 */
public class FanartTvArtwork extends AbstractJsonMapping implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final Logger LOG = LoggerFactory.getLogger(FanartTvArtwork.class);
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
    private int id = 0;
    @JsonProperty("url")
    private String url = "";
    @JsonProperty("lang")
    private String language = "";
    @JsonProperty("likes")
    private int likes = 0;
    private int season = 0;
    @JsonProperty("disc")
    private int disc = 0;
    @JsonProperty("disc_type")
    private String discType = "";
    private int size = 0;
    private String albumId = "";

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
     * Get the artwork type
     *
     * @return the type
     */
    public String getType() {
        return type.toString();
    }

    /**
     * Set the artwork type
     *
     * @param type the type to set
     */
    @JsonProperty("type")
    public void setType(String type) {
        if (validateType(type)) {
            this.type = FTArtworkType.fromString(type);
        }
    }

    /**
     * Set the artwork type
     *
     * @param type the type to set
     */
    public void setType(FTArtworkType type) {
        this.type = type;
    }

    /**
     * Get the artwork URL
     *
     * @return the URL
     */
    public String getUrl() {
        return url;
    }

    /**
     * Set the artwork URL
     *
     * @param url the URL to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Get the artwork ID
     *
     * @return the ID of the artwork
     */
    public int getId() {
        return id;
    }

    /**
     * Set the artwork ID
     *
     * @param id the ID of the artwork
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the language of the artwork
     *
     * @return Language of the artwork
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Set the language of the artwork
     *
     * @param language Language of the artwork
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * Get how many likes the artwork has
     *
     * @return How many likes the artwork has
     */
    public int getLikes() {
        return likes;
    }

    /**
     * Set how many likes the artwork has
     *
     * @param likes Set how many likes the artwork has
     */
    public void setLikes(int likes) {
        this.likes = likes;
    }

    /**
     * Get the season for the artwork
     *
     * @return Season for the artwork
     */
    public int getSeason() {
        return season;
    }

    /**
     * Get the music brainz album id
     *
     * @return
     */
    public String getAlbumId() {
        return albumId;
    }

    /**
     * Set the music brainz album id
     *
     * @param albumId
     */
    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    /**
     * Set the season for the artwork
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
     * Get the size of the artwork
     *
     * @return size of the artwork
     */
    public int getSize() {
        return size;
    }

    /**
     * Set the size of the artwork
     *
     * @param size Size of the artwork
     */
    @JsonProperty("size")
    public void setSize(String size) {
        if (StringUtils.isNumeric(size)) {
            this.size = Integer.parseInt(size);
        } else {
            this.size = 0;
        }
    }

    /**
     * Get the disc number for the artwork
     *
     * @return Disc number for the artwork
     */
    public int getDisc() {
        return disc;
    }

    /**
     * Set the disc number for the artwork
     *
     * @param disc Disc number for the artwork
     */
    public void setDisc(int disc) {
        this.disc = disc;
    }

    /**
     * Get the disc type for the artwork
     *
     * @return Disc type for the artwork
     */
    public String getDiscType() {
        return discType;
    }

    /**
     * Set the disc type for the artwork
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
            LOG.debug("Failed to convert '{}' to a valid artwork type", artworkType, ex);
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
            LOG.debug("Failed to convert '{}' to a valid artwork sort type", artworkSort, ex);
            return false;
        }
    }
}
