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
package com.omertron.fanarttvapi.wrapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.omertron.fanarttvapi.model.AbstractJsonMapping;
import com.omertron.fanarttvapi.model.FTArtworkType;
import com.omertron.fanarttvapi.model.FanartTvArtwork;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

/**
 * JSON Wrapper class for Movie artwork from Fanart.TV Not intended for use outside of the API
 *
 * @author stuart.boston
 */
public class WrapperSeries extends AbstractJsonMapping {

    @JsonProperty("thetvdb_id")
    private String tvdbid;
    @JsonProperty("clearlogo")
    private List<FanartTvArtwork> clearLogo = Collections.EMPTY_LIST;
    @JsonProperty("clearart")
    private List<FanartTvArtwork> clearArt = Collections.EMPTY_LIST;
    @JsonProperty("tvthumb")
    private List<FanartTvArtwork> tvThumb = Collections.EMPTY_LIST;
    @JsonProperty("seasonthumb")
    private List<FanartTvArtwork> seasonThumb = Collections.EMPTY_LIST;
    @JsonProperty("characterart")
    private List<FanartTvArtwork> characterArt = Collections.EMPTY_LIST;
    @JsonProperty("showbackground")
    private List<FanartTvArtwork> showBackground = Collections.EMPTY_LIST;
    @JsonProperty("hdclearart")
    private List<FanartTvArtwork> hdClearart = Collections.EMPTY_LIST;
    @JsonProperty("hdtvlogo")
    private List<FanartTvArtwork> hdTvLogo = Collections.EMPTY_LIST;
    @JsonProperty("tvbanner")
    private List<FanartTvArtwork> tvBanner = Collections.EMPTY_LIST;
    @JsonProperty("tvposter")
    private List<FanartTvArtwork> tvPoster = Collections.EMPTY_LIST;

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
     * @param clearArt
     */
    public void setClearArt(List<FanartTvArtwork> clearArt) {
        this.clearArt = clearArt;
    }

    /**
     * Set the ClearLogo artwork list
     *
     * @param clearLogo
     */
    public void setClearLogo(List<FanartTvArtwork> clearLogo) {
        this.clearLogo = clearLogo;
    }

    /**
     * Set the SeasonThumb artwork list
     *
     * @param seasonThumb
     */
    public void setSeasonThumb(List<FanartTvArtwork> seasonThumb) {
        this.seasonThumb = seasonThumb;
    }

    /**
     * Set the TvThumb artwork list
     *
     * @param tvThumb
     */
    public void setTvThumb(List<FanartTvArtwork> tvThumb) {
        this.tvThumb = tvThumb;
    }

    /**
     * Set the CharacterArt artwork list
     *
     * @param characterArt
     */
    public void setCharacterArt(List<FanartTvArtwork> characterArt) {
        this.characterArt = characterArt;
    }

    /**
     * Set the ShowBackground artwork list
     *
     * @param showBackground
     */
    public void setShowBackground(List<FanartTvArtwork> showBackground) {
        this.showBackground = showBackground;
    }

    /**
     * Set the HDClearArt artwork list
     *
     * @param hdClearart
     */
    public void setHdClearart(List<FanartTvArtwork> hdClearart) {
        this.hdClearart = hdClearart;
    }

    /**
     * Set the HD TV Logo artwork list
     *
     * @param hdTvLogo
     */
    public void setHdTvLogo(List<FanartTvArtwork> hdTvLogo) {
        this.hdTvLogo = hdTvLogo;
    }

    /**
     * Set the TV Banner artwork list
     *
     * @param tvBanner
     */
    public void setTvBanner(List<FanartTvArtwork> tvBanner) {
        this.tvBanner = tvBanner;
    }

    /**
     * Set the TV Poster artwork list
     *
     * @param tvPoster
     */
    public void setTvPoster(List<FanartTvArtwork> tvPoster) {
        this.tvPoster = tvPoster;
    }

    /**
     * Get a map of the artwork types keyed by the artwork type
     *
     * @return
     */
    public Map<FTArtworkType, List<FanartTvArtwork>> getArtwork() {
        Map<FTArtworkType, List<FanartTvArtwork>> artwork = new EnumMap<FTArtworkType, List<FanartTvArtwork>>(FTArtworkType.class);

        artwork.put(FTArtworkType.CHARACTERART, characterArt);
        artwork.put(FTArtworkType.CLEARART, clearArt);
        artwork.put(FTArtworkType.CLEARLOGO, clearLogo);
        artwork.put(FTArtworkType.SEASONTHUMB, seasonThumb);
        artwork.put(FTArtworkType.TVTHUMB, tvThumb);
        artwork.put(FTArtworkType.SHOWBACKGROUND, showBackground);
        artwork.put(FTArtworkType.HDCLEARART, hdClearart);
        artwork.put(FTArtworkType.HDTVLOGO, hdTvLogo);
        artwork.put(FTArtworkType.TVBANNER, tvBanner);
        artwork.put(FTArtworkType.TVPOSTER, tvPoster);

        return artwork;
    }
}
