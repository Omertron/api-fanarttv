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
 * JSON Wrapper class for TV Music Label artwork from Fanart.TV
 *
 * @author stuart.boston
 */
public class FTMusicLabel extends AbstractFanartTv implements Serializable {

    private static final Logger LOG = LoggerFactory.getLogger(FTSeries.class);

    @JsonProperty("name")
    private String name;
    @JsonProperty("id")
    private String id;

    /**
     * Get the Artist Name
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Set the Artist Name
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set the ID
     *
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * Get the ID
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Set the Music Logo artwork list
     *
     * @param ftArtwork
     */
    @JsonSetter("musiclogo")
    public void setMusiclogo(List<FTArtwork> ftArtwork) {
        addArtwork(FTArtworkType.MUSICLOGO, ftArtwork);
    }

    /**
     * Set the HD Music Logo artwork list
     *
     * @param ftArtwork
     */
    @JsonSetter("hdmusiclogo")
    public void setHdmusiclogo(List<FTArtwork> ftArtwork) {
        addArtwork(FTArtworkType.HDMUSICLOGO, ftArtwork);
    }

    /**
     * Set the Artist Background artwork list
     *
     * @param ftArtwork
     */
    @JsonSetter("artistbackground")
    public void setArtistbackground(List<FTArtwork> ftArtwork) {
        addArtwork(FTArtworkType.ARTISTBACKGROUND, ftArtwork);
    }

    /**
     * Set the CD Art artwork list
     *
     * @param ftArtwork
     */
    @JsonSetter("cdart")
    public void setCdart(List<FTArtwork> ftArtwork) {
        addArtwork(FTArtworkType.CDART, ftArtwork);
    }

    /**
     * Set the Artist Thumb artwork list
     *
     * @param ftArtwork
     */
    @JsonSetter("artistthumb")
    public void setArtistthumb(List<FTArtwork> ftArtwork) {
        addArtwork(FTArtworkType.ARTISTTHUMB, ftArtwork);
    }

    /**
     * Set the Music Banner artwork list
     *
     * @param ftArtwork
     */
    @JsonSetter("musicbanner")
    public void setMusicbanner(List<FTArtwork> ftArtwork) {
        addArtwork(FTArtworkType.MUSICBANNER, ftArtwork);
    }

    /**
     * Set the Album Cover artwork list
     *
     * @param ftArtwork
     */
    @JsonSetter("albumcover")
    public void setAlbumcover(List<FTArtwork> ftArtwork) {
        addArtwork(FTArtworkType.ALBUMCOVER, ftArtwork);
    }

}
