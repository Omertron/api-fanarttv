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

import java.util.List;
import org.apache.log4j.Logger;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonProperty;

public class WrapperSeries {

    private static final Logger LOGGER = Logger.getLogger(WrapperSeries.class);
    @JsonProperty("thetvdb_id")
    private String tvdbid;
    @JsonProperty("clearlogo")
    private List<FanartTvArtwork> clearLogo;
    @JsonProperty("clearart")
    private List<FanartTvArtwork> clearArt;
    @JsonProperty("tvthumb")
    private List<FanartTvArtwork> tvThumb;
    @JsonProperty("seasonthumb")
    private List<FanartTvArtwork> seasonThumb;
    @JsonProperty("characterart")
    private List<FanartTvArtwork> characterArt;

    public String getTvdbid() {
        return tvdbid;
    }

    public void setTvdbid(String tvdbid) {
        this.tvdbid = tvdbid;
    }

    public List<FanartTvArtwork> getClearArt() {
        return clearArt;
    }

    public void setClearArt(List<FanartTvArtwork> clearArt) {
        this.clearArt = clearArt;
    }

    public List<FanartTvArtwork> getClearLogo() {
        return clearLogo;
    }

    public void setClearLogo(List<FanartTvArtwork> clearLogo) {
        this.clearLogo = clearLogo;
    }

    public List<FanartTvArtwork> getSeasonThumb() {
        return seasonThumb;
    }

    public void setSeasonThumb(List<FanartTvArtwork> seasonThumb) {
        this.seasonThumb = seasonThumb;
    }

    public List<FanartTvArtwork> getTvThumb() {
        return tvThumb;
    }

    public void setTvThumb(List<FanartTvArtwork> tvThumb) {
        this.tvThumb = tvThumb;
    }

    public List<FanartTvArtwork> getCharacterArt() {
        return characterArt;
    }

    public void setCharacterArt(List<FanartTvArtwork> characterArt) {
        this.characterArt = characterArt;
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
