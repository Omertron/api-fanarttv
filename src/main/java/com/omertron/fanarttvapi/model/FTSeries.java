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
import com.fasterxml.jackson.annotation.JsonSetter;
import com.omertron.fanarttvapi.enumeration.FTArtworkType;
import java.io.Serializable;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * JSON Wrapper class for TV Series artwork from Fanart.TV
 *
 * @author stuart.boston
 */
public class FTSeries extends AbstractFanartTv implements Serializable {

    private static final Logger LOG = LoggerFactory.getLogger(FTSeries.class);

    @JsonProperty("name")
    private String name;
    @JsonProperty("thetvdb_id")
    private String tvdbid;

    /**
     * Get the Show Name
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Set the Show Name
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the TheTVDB ID
     *
     * @return
     */
    public String getTvdbid() {
        return tvdbid;
    }

    /**
     * Set the TheTVDB ID
     *
     * @param tvdbid
     */
    public void setTvdbid(String tvdbid) {
        this.tvdbid = tvdbid;
    }

    /**
     * Set the ClearArt artwork list
     *
     * @param ftArtwork
     */
    @JsonSetter("clearart")
    public void setClearArt(List<FTArtwork> ftArtwork) {
        addArtwork(FTArtworkType.CLEARART, ftArtwork);
    }

    /**
     * Set the ClearLogo artwork list
     *
     * @param ftArtwork
     */
    @JsonSetter("clearlogo")
    public void setClearLogo(List<FTArtwork> ftArtwork) {
        addArtwork(FTArtworkType.CLEARLOGO, ftArtwork);
    }

    /**
     * Set the SeasonThumb artwork list
     *
     * @param ftArtwork
     */
    @JsonSetter("seasonthumb")
    public void setSeasonThumb(List<FTArtwork> ftArtwork) {
        addArtwork(FTArtworkType.SEASONTHUMB, ftArtwork);
    }

    /**
     * Set the TvThumb artwork list
     *
     * @param ftArtwork
     */
    @JsonSetter("tvthumb")
    public void setTvThumb(List<FTArtwork> ftArtwork) {
        addArtwork(FTArtworkType.TVTHUMB, ftArtwork);
    }

    /**
     * Set the CharacterArt artwork list
     *
     * @param ftArtwork
     */
    @JsonSetter("characterart")
    public void setCharacterArt(List<FTArtwork> ftArtwork) {
        addArtwork(FTArtworkType.CHARACTERART, ftArtwork);
    }

    /**
     * Set the ShowBackground artwork list
     *
     * @param ftArtwork
     */
    @JsonSetter("showbackground")
    public void setShowBackground(List<FTArtwork> ftArtwork) {
        addArtwork(FTArtworkType.SHOWBACKGROUND, ftArtwork);
    }

    /**
     * Set the HDClearArt artwork list
     *
     * @param ftArtwork
     */
    @JsonSetter("hdclearart")
    public void setHdClearart(List<FTArtwork> ftArtwork) {
        addArtwork(FTArtworkType.HDCLEARART, ftArtwork);
    }

    /**
     * Set the HD TV Logo artwork list
     *
     * @param ftArtwork
     */
    @JsonSetter("hdtvlogo")
    public void setHdTvLogo(List<FTArtwork> ftArtwork) {
        addArtwork(FTArtworkType.HDTVLOGO, ftArtwork);
    }

    /**
     * Set the TV Banner artwork list
     *
     * @param ftArtwork
     */
    @JsonSetter("tvbanner")
    public void setTvBanner(List<FTArtwork> ftArtwork) {
        addArtwork(FTArtworkType.TVBANNER, ftArtwork);
    }

    /**
     * Set the TV Poster artwork list
     *
     * @param ftArtwork
     */
    @JsonSetter("tvposter")
    public void setTvPoster(List<FTArtwork> ftArtwork) {
        addArtwork(FTArtworkType.TVPOSTER, ftArtwork);
    }

    /**
     * Set the TV Season poster artwork list
     *
     * @param ftArtwork
     */
    @JsonSetter("seasonposter")
    public void setSeasonPoster(List<FTArtwork> ftArtwork) {
        addArtwork(FTArtworkType.SEASONPOSTER, ftArtwork);
    }

    /**
     * Set the TV Season banner artwork list
     *
     * @param ftArtwork
     */
    @JsonSetter("seasonbanner")
    public void setSeasonBanner(List<FTArtwork> ftArtwork) {
        addArtwork(FTArtworkType.SEASONBANNER, ftArtwork);
    }

}
