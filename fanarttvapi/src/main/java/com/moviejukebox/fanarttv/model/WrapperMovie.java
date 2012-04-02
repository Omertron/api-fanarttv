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

import java.util.List;
import org.apache.log4j.Logger;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonProperty;

public class WrapperMovie {

    private static final Logger LOGGER = Logger.getLogger(WrapperMovie.class);
    @JsonProperty("tmdb_id")
    private int tmdbId;
    @JsonProperty("imdb_id")
    private String imdbId;
    @JsonProperty("movielogo")
    private List<FanartTvArtwork> movieLogo;
    @JsonProperty("moviedisc")
    private List<FanartTvArtwork> movieDisc;

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public int getTmdbId() {
        return tmdbId;
    }

    public void setTmdbId(int tmdbId) {
        this.tmdbId = tmdbId;
    }

    public List<FanartTvArtwork> getMovieDisc() {
        return movieDisc;
    }

    public void setMovieDisc(List<FanartTvArtwork> movieDisc) {
        this.movieDisc = movieDisc;
    }

    public List<FanartTvArtwork> getMovieLogo() {
        return movieLogo;
    }

    public void setMovieLogo(List<FanartTvArtwork> movieLogo) {
        this.movieLogo = movieLogo;
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
