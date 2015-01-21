/*
 *      Copyright (c) 2004-2015 Stuart Boston
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
import java.util.Collections;
import java.util.Map;

/**
 * JSON Wrapper class for TV Music Artist artwork from Fanart.TV
 *
 * @author stuart.boston
 */
public class FTMusicArtist extends ArtworkList {

    private static final long serialVersionUID = 1L;

    @JsonProperty("name")
    private String name;
    @JsonProperty("mbid_id")
    private String mbidId;
    @JsonProperty("albums")
    private Map<String, ArtworkList> albums = Collections.emptyMap();

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

    /**
     * Get a list of the albums associated with the Artist
     *
     * @return
     */
    public Map<String, ArtworkList> getAlbums() {
        return albums;
    }

    /**
     * Set the list of albums for the artist
     *
     * @param albums
     */
    public void setAlbums(Map<String, ArtworkList> albums) {
        this.albums = albums;
    }

}
