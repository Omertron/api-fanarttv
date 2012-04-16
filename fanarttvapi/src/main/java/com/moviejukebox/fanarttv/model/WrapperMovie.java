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

public class WrapperMovie {

    private static final Logger LOGGER = Logger.getLogger(WrapperMovie.class);
    @JsonProperty("tmdb_id")
    private int tmdbId;
    @JsonProperty("imdb_id")
    private String imdbId;
    @JsonProperty("movieart")
    private List<FanartTvArtwork> movieArt;
    @JsonProperty("moviedisc")
    private List<FanartTvArtwork> movieDisc;
    @JsonProperty("movielogo")
    private List<FanartTvArtwork> movieLogo;

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

    public void setMovieDisc(List<FanartTvArtwork> movieDisc) {
        this.movieDisc = movieDisc;
    }

    public void setMovieLogo(List<FanartTvArtwork> movieLogo) {
        this.movieLogo = movieLogo;
    }

    public void setMovieArt(List<FanartTvArtwork> movieArt) {
        this.movieArt = movieArt;
    }

    public Map<FTArtworkType, List<FanartTvArtwork>> getArtwork() {
        Map<FTArtworkType, List<FanartTvArtwork>> artwork = new EnumMap<FTArtworkType, List<FanartTvArtwork>>(FTArtworkType.class);

        artwork.put(FTArtworkType.MOVIEART, movieArt);
        artwork.put(FTArtworkType.MOVIEDISC, movieDisc);
        artwork.put(FTArtworkType.MOVIELOGO, movieLogo);

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
