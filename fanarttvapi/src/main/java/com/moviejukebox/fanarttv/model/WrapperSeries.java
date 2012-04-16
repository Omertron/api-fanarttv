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

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
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

    public void setClearArt(List<FanartTvArtwork> clearArt) {
        this.clearArt = clearArt;
    }

    public void setClearLogo(List<FanartTvArtwork> clearLogo) {
        this.clearLogo = clearLogo;
    }

    public void setSeasonThumb(List<FanartTvArtwork> seasonThumb) {
        this.seasonThumb = seasonThumb;
    }

    public void setTvThumb(List<FanartTvArtwork> tvThumb) {
        this.tvThumb = tvThumb;
    }

    public void setCharacterArt(List<FanartTvArtwork> characterArt) {
        this.characterArt = characterArt;
    }

    public Map<FTArtworkType, List<FanartTvArtwork>> getArtwork() {
        Map<FTArtworkType, List<FanartTvArtwork>> artwork = new EnumMap<FTArtworkType, List<FanartTvArtwork>>(FTArtworkType.class);

        artwork.put(FTArtworkType.CHARACTERART, characterArt);
        artwork.put(FTArtworkType.CLEARART, clearArt);
        artwork.put(FTArtworkType.CLEARLOGO, clearLogo);
        artwork.put(FTArtworkType.SEASONTHUMB, seasonThumb);
        artwork.put(FTArtworkType.TVTHUMB, tvThumb);

        return artwork;
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
