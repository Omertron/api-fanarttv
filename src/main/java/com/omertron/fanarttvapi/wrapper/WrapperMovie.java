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
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

/**
 * JSON Wrapper class for Movie artwork from Fanart.TV Not intended for use outside of the API
 *
 * @author stuart.boston
 */
public class WrapperMovie extends AbstractJsonMapping {

    @JsonProperty("tmdb_id")
    private int tmdbId;
    @JsonProperty("imdb_id")
    private String imdbId;
    @JsonProperty("movieart")
    private List<FanartTvArtwork> movieArt = Collections.EMPTY_LIST;
    @JsonProperty("moviedisc")
    private List<FanartTvArtwork> movieDisc = Collections.EMPTY_LIST;
    @JsonProperty("movielogo")
    private List<FanartTvArtwork> movieLogo = Collections.EMPTY_LIST;
    @JsonProperty("moviebackground")
    private List<FanartTvArtwork> movieBackground = Collections.EMPTY_LIST;
    @JsonProperty("moviethumb")
    private List<FanartTvArtwork> movieThumb = Collections.EMPTY_LIST;
    @JsonProperty("hdmovielogo")
    private List<FanartTvArtwork> hdMovieLogo = Collections.EMPTY_LIST;
    @JsonProperty("moviebanner")
    private List<FanartTvArtwork> movieBanner = Collections.EMPTY_LIST;
    @JsonProperty("hdmovieclearart")
    private List<FanartTvArtwork> movieClearArt = Collections.EMPTY_LIST;
    @JsonProperty("movieposter")
    private List<FanartTvArtwork> moviePoster = Collections.EMPTY_LIST;

    /**
     * Get the ID for IMDB
     *
     * @return
     */
    public String getImdbId() {
        return imdbId;
    }

    /**
     * Set the ID for IMDB
     *
     * @param imdbId
     */
    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    /**
     * Get the ID for TheMovieDB
     *
     * @return
     */
    public int getTmdbId() {
        return tmdbId;
    }

    /**
     * Set the ID for TheMovieDB
     *
     * @param tmdbId
     */
    public void setTmdbId(int tmdbId) {
        this.tmdbId = tmdbId;
    }

    /**
     * Set the MovieDisc artwork list
     *
     * @param movieDisc
     */
    public void setMovieDisc(List<FanartTvArtwork> movieDisc) {
        this.movieDisc = movieDisc;
    }

    /**
     * Set the MovieLogo artwork list
     *
     * @param movieLogo
     */
    public void setMovieLogo(List<FanartTvArtwork> movieLogo) {
        this.movieLogo = movieLogo;
    }

    /**
     * Set the MovieArt artwork list
     *
     * @param movieArt
     */
    public void setMovieArt(List<FanartTvArtwork> movieArt) {
        this.movieArt = movieArt;
    }

    /**
     * Set the MovieBackground artwork list
     *
     * @param movieBackground
     */
    public void setMovieBackground(List<FanartTvArtwork> movieBackground) {
        this.movieBackground = movieBackground;
    }

    /**
     * Set the MovieThumb artwork list
     *
     * @param movieThumb
     */
    public void setMovieThumb(List<FanartTvArtwork> movieThumb) {
        this.movieThumb = movieThumb;
    }

    /**
     * Set the HD Movie Logo artwork list
     *
     * @param hdMovieLogo
     */
    public void setHdMovieLogo(List<FanartTvArtwork> hdMovieLogo) {
        this.hdMovieLogo = hdMovieLogo;
    }

    /**
     * Set the MovieBanner artwork list
     *
     * @param movieBanner
     */
    public void setMovieBanner(List<FanartTvArtwork> movieBanner) {
        this.movieBanner = movieBanner;
    }

    /**
     * Set the MovieClearArt artwork list
     *
     * @param movieClearArt
     */
    public void setMovieClearArt(List<FanartTvArtwork> movieClearArt) {
        this.movieClearArt = movieClearArt;
    }

    /**
     * Set the MoviePoster artwork list
     *
     * @param moviePoster
     */
    public void setMoviePoster(List<FanartTvArtwork> moviePoster) {
        this.moviePoster = moviePoster;
    }

    /**
     * Get a map of the artwork types keyed by the artwork type
     *
     * @return
     */
    public Map<FTArtworkType, List<FanartTvArtwork>> getArtwork() {
        Map<FTArtworkType, List<FanartTvArtwork>> artwork = new EnumMap<FTArtworkType, List<FanartTvArtwork>>(FTArtworkType.class);

        artwork.put(FTArtworkType.MOVIEART, movieArt);
        artwork.put(FTArtworkType.MOVIEDISC, movieDisc);
        artwork.put(FTArtworkType.MOVIELOGO, movieLogo);
        artwork.put(FTArtworkType.MOVIEBACKGROUND, movieBackground);
        artwork.put(FTArtworkType.MOVIETHUMB, movieThumb);
        artwork.put(FTArtworkType.HDMOVIELOGO, hdMovieLogo);
        artwork.put(FTArtworkType.MOVIEBANNER, movieBanner);
        artwork.put(FTArtworkType.HDMOVIECLEARART, movieClearArt);
        artwork.put(FTArtworkType.MOVIEPOSTER, moviePoster);

        return artwork;
    }
}
