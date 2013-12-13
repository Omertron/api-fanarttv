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
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

/**
 * JSON Wrapper class for Movie artwork from Fanart.TV Not intended for use outside of the API
 *
 * @author stuart.boston
 */
public class WrapperMusic extends AbstractJsonMapping implements IArtworkList {

    @JsonProperty("mbid_id")
    private String mbidId;
    @JsonProperty("albumcover")
    private List<FanartTvArtwork> albumCover = Collections.emptyList();
    @JsonProperty("artistbackground")
    private List<FanartTvArtwork> artistBackground = Collections.emptyList();
    @JsonProperty("cdart")
    private List<FanartTvArtwork> cdArt = Collections.emptyList();
    @JsonProperty("musiclogo")
    private List<FanartTvArtwork> musicLogo = Collections.emptyList();
    @JsonProperty("artistthumb")
    private List<FanartTvArtwork> artistThumb = Collections.emptyList();
    @JsonProperty("albums")
    private Map<String, WrapperAlbum> albums = Collections.emptyMap();
    @JsonProperty("hdmusiclogo")
    private List<FanartTvArtwork> hdMusicLogo = Collections.emptyList();
    @JsonProperty("musicbanner")
    private List<FanartTvArtwork> musicBanner = Collections.emptyList();

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
     * Set the ArtistThumb artwork list
     *
     * @param artistThumb
     */
    public void setArtistThumb(List<FanartTvArtwork> artistThumb) {
        this.artistThumb = artistThumb;
    }

    /**
     * Set the Albums artwork list
     *
     * @param albums
     */
    public void setAlbums(Map<String, WrapperAlbum> albums) {
        this.albums = albums;
    }

    /**
     * Set the HD Music Logo artwork list
     *
     * @param hdMusicLogo
     */
    public void setHdMusicLogo(List<FanartTvArtwork> hdMusicLogo) {
        this.hdMusicLogo = hdMusicLogo;
    }

    /**
     * Set the Music Banner artwork list
     *
     * @param musicBanner
     */
    public void setMusicBanner(List<FanartTvArtwork> musicBanner) {
        this.musicBanner = musicBanner;
    }

    /**
     * Get a map of the artwork types keyed by the artwork type
     *
     * @return
     */
    public Map<FTArtworkType, List<FanartTvArtwork>> getArtwork() {
        Map<FTArtworkType, List<FanartTvArtwork>> artwork = new EnumMap<FTArtworkType, List<FanartTvArtwork>>(FTArtworkType.class);

        artwork.put(FTArtworkType.ARTISTBACKGROUND, artistBackground);
        artwork.put(FTArtworkType.MUSICLOGO, musicLogo);
        artwork.put(FTArtworkType.ARTISTTHUMB, artistThumb);
        artwork.put(FTArtworkType.HDMUSICLOGO, hdMusicLogo);
        artwork.put(FTArtworkType.MUSICBANNER, musicBanner);

        cdArt = new ArrayList<FanartTvArtwork>();
        albumCover = new ArrayList<FanartTvArtwork>();

        for (Map.Entry<String, WrapperAlbum> album : albums.entrySet()) {
            String albumId = album.getKey();
            album.getValue().addAlbumId(albumId);

            Map<FTArtworkType, List<FanartTvArtwork>> albumArtwork = album.getValue().getArtwork();
            cdArt.addAll(albumArtwork.get(FTArtworkType.CDART));
            albumCover.addAll(albumArtwork.get(FTArtworkType.ALBUMCOVER));
        }
        artwork.put(FTArtworkType.ALBUMCOVER, albumCover);
        artwork.put(FTArtworkType.CDART, cdArt);

        return artwork;
    }
}
