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
import com.omertron.fanarttvapi.enumeration.FTArtworkType;
import java.io.Serializable;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * JSON Wrapper class for Movie artwork from Fanart.TV
 *
 * @author stuart.boston
 */
public class FTMovie extends AbstractFanartTv implements Serializable {

    private static final Logger LOG = LoggerFactory.getLogger(FTMovie.class);

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

    public String getTmdbId() {
        return tmdbId;
    }

    public void setTmdbId(String tmdbId) {
        this.tmdbId = tmdbId;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    @JsonProperty("hdmovielogo")
    public void setHdmovielogo(List<FTArtwork> ftArtwork) {
        addArtwork(FTArtworkType.HDMOVIELOGO, ftArtwork);
    }

    @JsonProperty("hdmovieclearart")
    public void setHdmovieclearart(List<FTArtwork> ftArtwork) {
        addArtwork(FTArtworkType.HDMOVIECLEARART, ftArtwork);
    }

    @JsonProperty("movielogo")
    public void setMovielogo(List<FTArtwork> ftArtwork) {
        addArtwork(FTArtworkType.MOVIELOGO, ftArtwork);
    }

    @JsonProperty("moviedisc")
    public void setMoviedisc(List<FTArtwork> ftArtwork) {
        addArtwork(FTArtworkType.MOVIEDISC, ftArtwork);
    }

    @JsonProperty("moviebanner")
    public void setMoviebanner(List<FTArtwork> ftArtwork) {
        addArtwork(FTArtworkType.MOVIEBANNER, ftArtwork);
    }

    @JsonProperty("moviethumb")
    public void setMoviethumb(List<FTArtwork> ftArtwork) {
        addArtwork(FTArtworkType.MOVIETHUMB, ftArtwork);
    }

    @JsonProperty("moviebackground")
    public void setMoviebackground(List<FTArtwork> ftArtwork) {
        addArtwork(FTArtworkType.MOVIEBACKGROUND, ftArtwork);
    }

    @JsonProperty("movieposter")
    public void setMovieposter(List<FTArtwork> ftArtwork) {
        addArtwork(FTArtworkType.MOVIEPOSTER, ftArtwork);
    }

    @JsonProperty("movieart")
    public void setMovieart(List<FTArtwork> ftArtwork) {
        addArtwork(FTArtworkType.MOVIEART, ftArtwork);
    }

}
