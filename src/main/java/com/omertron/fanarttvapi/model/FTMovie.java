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

/**
 * JSON Wrapper class for Movie artwork from Fanart.TV
 *
 * @author stuart.boston
 */
public class FTMovie extends ArtworkList {

    @JsonProperty("tmdb_id")
    private String tmdbId = "";
    @JsonProperty("imdb_id")
    private String imdbId = "";
    @JsonProperty("name")
    private String name;

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
     * Get TheMovieDB ID
     *
     * @return
     */
    public String getTmdbId() {
        return tmdbId;
    }

    /**
     * Set TheMovieDB ID
     *
     * @param tmdbId
     */
    public void setTmdbId(String tmdbId) {
        this.tmdbId = tmdbId;
    }

    /**
     * Get the IMDB ID
     *
     * @return
     */
    public String getImdbId() {
        return imdbId;
    }

    /**
     * Set the IMDB ID
     *
     * @param imdbId
     */
    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }
}
