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

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.omertron.fanarttvapi.model.FTArtworkType;
import com.omertron.fanarttvapi.model.FanartTvArtwork;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * JSON Wrapper class for Movie artwork from Fanart.TV Not intended for use outside of the API
 *
 * @author stuart.boston
 */
public class WrapperAlbum {

    private static final Logger LOG = LoggerFactory.getLogger(WrapperAlbum.class);
    @JsonProperty("albumcover")
    private List<FanartTvArtwork> albumCover = Collections.EMPTY_LIST;
    @JsonProperty("cdart")
    private List<FanartTvArtwork> cdArt = Collections.EMPTY_LIST;

    /**
     * Set the AlbumCover artwork list
     *
     * @param albumCover
     */
    public void setAlbumCover(List<FanartTvArtwork> albumCover) {
        this.albumCover = albumCover;
    }

    /**
     * Set the CdArt artwork list
     *
     * @param cdArt
     */
    public void setCdArt(List<FanartTvArtwork> cdArt) {
        this.cdArt = cdArt;
    }

    /**
     * Get a map of the artwork types keyed by the artwork type
     *
     * @return
     */
    public Map<FTArtworkType, List<FanartTvArtwork>> getArtwork() {
        Map<FTArtworkType, List<FanartTvArtwork>> artwork = new EnumMap<FTArtworkType, List<FanartTvArtwork>>(FTArtworkType.class);

        artwork.put(FTArtworkType.ALBUMCOVER, albumCover);
        artwork.put(FTArtworkType.CDART, cdArt);

        return artwork;
    }

    /**
     * Add the album ID to all the artwork
     *
     * @param albumId
     */
    public void addAlbumId(String albumId) {
        addAlbumId(albumCover, albumId);
        addAlbumId(cdArt, albumId);
    }

    /**
     * Add the album Id to each artwork in the list
     *
     * @param artworkList
     * @param albumId
     */
    private void addAlbumId(List<FanartTvArtwork> artworkList, String albumId) {
        for (FanartTvArtwork artwork : artworkList) {
            artwork.setAlbumId(albumId);
        }
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
        LOG.debug(sb.toString());
    }
}
