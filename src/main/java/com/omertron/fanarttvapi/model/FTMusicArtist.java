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
 * JSON Wrapper class for TV Music Artist artwork from Fanart.TV
 *
 * @author stuart.boston
 */
public class FTMusicArtist extends AbstractFanartTv implements Serializable {

    private static final Logger LOG = LoggerFactory.getLogger(FTSeries.class);

    @JsonProperty("name")
    private String name;
    @JsonProperty("mbid_id")
    private String mbidId;
    @JsonProperty("albums")
    private List<String> albums;

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
     * Set the music brainz ID
     *
     * @return
     */
    public String getMbidId() {
        return mbidId;
    }

    /**
     * Get the music brainz ID
     *
     * @param mbidId
     */
    public void setMbidId(String mbidId) {
        this.mbidId = mbidId;
    }

    public List<String> getAlbums() {
        return albums;
    }

    public void setAlbums(List<String> albums) {
        this.albums = albums;
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
     * Set the Artist Thumb artwork list
     *
     * @param ftArtwork
     */
    @JsonSetter("artistthumb")
    public void setArtistthumb(List<FTArtwork> ftArtwork) {
        addArtwork(FTArtworkType.ARTISTTHUMB, ftArtwork);
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
     * Set the Music Banner artwork list
     *
     * @param ftArtwork
     */
    @JsonSetter("musicbanner")
    public void setMusicbanner(List<FTArtwork> ftArtwork) {
        addArtwork(FTArtworkType.MUSICBANNER, ftArtwork);
    }
}
