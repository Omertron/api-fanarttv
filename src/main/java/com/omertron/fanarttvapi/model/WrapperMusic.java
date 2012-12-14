/*
 *      Copyright (c) 2004-2012 Stuart Boston
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

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;

/**
 * JSON Wrapper class for Movie artwork from Fanart.TV Not intended for use
 * outside of the API
 *
 * @author stuart.boston
 */
public class WrapperMusic {

    private static final Logger logger = Logger.getLogger(WrapperMusic.class);
    @JsonProperty("mbid_id")
    private String mbidId;
    @JsonProperty("albumcover")
    private List<FanartTvArtwork> albumCover;
    @JsonProperty("artistbackground")
    private List<FanartTvArtwork> artistBackground;
    @JsonProperty("cdart")
    private List<FanartTvArtwork> cdArt;
    @JsonProperty("musiclogo")
    private List<FanartTvArtwork> musicLogo;

    /**
     * Get the Music Brainz ID
     *
     * @return
     */
    public String getMbidId() {
        return mbidId;
    }

    /**
     * Set the Music Brainz ID
     *
     * @param mbidId
     */
    public void setMbidId(String mbidId) {
        this.mbidId = mbidId;
    }

    /**
     * Set the AlbumCover artwork list
     *
     * @param albumCover
     */
    public void setAlbumCover(List<FanartTvArtwork> albumCover) {
        this.albumCover = albumCover;
    }

    /**
     * Set the ArtistBackground artwork list
     *
     * @param artistBackground
     */
    public void setArtistBackground(List<FanartTvArtwork> artistBackground) {
        this.artistBackground = artistBackground;
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
     * Set the MusicLogo artwork list
     *
     * @param musicLogo
     */
    public void setMusicLogo(List<FanartTvArtwork> musicLogo) {
        this.musicLogo = musicLogo;
    }

    /**
     * Get a map of the artwork types keyed by the artwork type
     *
     * @return
     */
    public Map<FTArtworkType, List<FanartTvArtwork>> getArtwork() {
        Map<FTArtworkType, List<FanartTvArtwork>> artwork = new EnumMap<FTArtworkType, List<FanartTvArtwork>>(FTArtworkType.class);

        artwork.put(FTArtworkType.ALBUMCOVER, albumCover);
        artwork.put(FTArtworkType.ARTISTBACKGROUND, artistBackground);
        artwork.put(FTArtworkType.CDART, cdArt);
        artwork.put(FTArtworkType.MUSICLOGO, musicLogo);

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
        logger.warn(sb.toString());
    }
}
