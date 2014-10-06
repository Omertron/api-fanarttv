/*
 *      Copyright (c) 2004-2014 Stuart Boston
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Artwork from Fanart.TV
 *
 * @author stuart.boston
 */
public class FTArtwork extends AbstractJsonMapping implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final Logger LOG = LoggerFactory.getLogger(FTArtwork.class);
    /*
     * Data model
     */
    @JsonProperty("id")
    private int id = 0;
    @JsonProperty("url")
    private String url = "";
    @JsonProperty("likes")
    private int likes = 0;
    @JsonProperty("colour")
    private String colour = "";
    @JsonProperty("lang")
    private String language = "";
    @JsonProperty("disc")
    private int discNumber = -1;
    @JsonProperty("disc_type")
    private String diskType = "";
    @JsonProperty("season")
    private String season = "";
    @JsonProperty("size")
    private int size = 0;

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
     * Get the artwork colour
     *
     * @return
     */
    public String getColour() {
        return colour;
    }

    /**
     * Set the artwork colour
     *
     * @param colour
     */
    public void setColour(String colour) {
        this.colour = colour;
    }

    /**
     * Get the artwork language
     *
     * @return
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Set the artwork language
     *
     * @param language
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * Get the disc number
     *
     * @return
     */
    public int getDiscNumber() {
        return discNumber;
    }

    /**
     * Set the disc number
     *
     * @param discNumber
     */
    public void setDiscNumber(int discNumber) {
        this.discNumber = discNumber;
    }

    /**
     * Get the type of the disc
     *
     * @return
     */
    public String getDiskType() {
        return diskType;
    }

    /**
     * Set the type of the disc
     *
     * @param diskType
     */
    public void setDiskType(String diskType) {
        this.diskType = diskType;
    }

    /**
     * Get the season for the artwork
     *
     * @return
     */
    public String getSeason() {
        return season;
    }

    /**
     * Set the season for the artwork
     *
     * @param season
     */
    public void setSeason(String season) {
        this.season = season;
    }

    /**
     * Get the size of the artwork
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * Set the size of the artwork
     *
     * @param size
     */
    public void setSize(int size) {
        this.size = size;
    }

}
