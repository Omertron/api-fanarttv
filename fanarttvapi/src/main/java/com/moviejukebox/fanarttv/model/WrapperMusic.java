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

public class WrapperMusic {

    private static final Logger LOGGER = Logger.getLogger(WrapperMusic.class);
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

    public String getImdbId() {
        return mbidId;
    }

    public void setImdbId(String imdbId) {
        this.mbidId = imdbId;
    }

    public void setAlbumCover(List<FanartTvArtwork> albumCover) {
        this.albumCover = albumCover;
    }

    public void setArtistBackground(List<FanartTvArtwork> artistBackground) {
        this.artistBackground = artistBackground;
    }

    public void setCdArt(List<FanartTvArtwork> cdArt) {
        this.cdArt = cdArt;
    }

    public void setMusicLogo(List<FanartTvArtwork> musicLogo) {
        this.musicLogo = musicLogo;
    }

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
        LOGGER.warn(sb.toString());
    }
}
