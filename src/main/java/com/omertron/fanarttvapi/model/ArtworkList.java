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

import com.fasterxml.jackson.annotation.JsonSetter;
import com.omertron.fanarttvapi.enumeration.FTArtworkType;
import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

/**
 * Abstract class to implement the common artwork methods
 *
 * @author Stuart.Boston
 */
public class ArtworkList extends AbstractJsonMapping implements IArtworkList, Serializable {

    private final Map<FTArtworkType, List<FTArtwork>> artwork = new EnumMap<FTArtworkType, List<FTArtwork>>(FTArtworkType.class);

    /**
     * Add artwork to the list
     *
     * @param artworkType
     * @param artworkList
     */
    public void addArtwork(FTArtworkType artworkType, List<FTArtwork> artworkList) {
        artwork.put(artworkType, artworkList);
    }

    /**
     * Get a map of the artwork types keyed by the artwork type
     *
     * @return
     */
    @Override
    public Map<FTArtworkType, List<FTArtwork>> getArtwork() {
        return artwork;
    }

    /**
     * Get a specific type of artwork
     *
     * @param artworkType
     * @return
     */
    @Override
    public List<FTArtwork> getArtwork(FTArtworkType artworkType) {
        if (artwork.containsKey(artworkType)) {
            return artwork.get(artworkType);
        }
        return Collections.emptyList();
    }

    /**
     * Determines if there is any artwork associated with the series
     *
     * @return
     */
    @Override
    public boolean hasArtwork() {
        for (FTArtworkType at : FTArtworkType.values()) {
            // We're not countin the artwork, we're seeing if any exists, so quit when we find something
            if (hasArtwork(at) && !artwork.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Determines if the series has a specific type of artwork
     *
     * @param artworkType
     * @return
     */
    @Override
    public boolean hasArtwork(FTArtworkType artworkType) {
        if (artwork.containsKey(artworkType) && !artwork.get(artworkType).isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * Set the Artist Background artwork
     *
     * @param ftArtwork
     */
    @JsonSetter("artistbackground")
    public void setArtistBackground(List<FTArtwork> ftArtwork) {
        addArtwork(FTArtworkType.ARTISTBACKGROUND, ftArtwork);
    }

    /**
     * Set the Album Cover artwork
     *
     * @param ftArtwork
     */
    @JsonSetter("albumcover")
    public void setAlbumCover(List<FTArtwork> ftArtwork) {
        addArtwork(FTArtworkType.ALBUMCOVER, ftArtwork);
    }

    /**
     * Set the Music Logo artwork list
     *
     * @param ftArtwork
     */
    @JsonSetter("musiclogo")
    public void setMusiclogo(List<FTArtwork> ftArtwork) {
        addArtwork(FTArtworkType.MUSICLOGO, ftArtwork);
    }

    /**
     * Set the HD Music Logo artwork list
     *
     * @param ftArtwork
     */
    @JsonSetter("hdmusiclogo")
    public void setHdMusicLogo(List<FTArtwork> ftArtwork) {
        addArtwork(FTArtworkType.HDMUSICLOGO, ftArtwork);
    }

    /**
     * Set the CD Art artwork list
     *
     * @param ftArtwork
     */
    @JsonSetter("cdart")
    public void setCdArt(List<FTArtwork> ftArtwork) {
        addArtwork(FTArtworkType.CDART, ftArtwork);
    }

    /**
     * Set the Artist Thumb artwork list
     *
     * @param ftArtwork
     */
    @JsonSetter("artistthumb")
    public void setArtistThumb(List<FTArtwork> ftArtwork) {
        addArtwork(FTArtworkType.ARTISTTHUMB, ftArtwork);
    }

    /**
     * Set the Music Banner artwork list
     *
     * @param ftArtwork
     */
    @JsonSetter("musicbanner")
    public void setMusicBanner(List<FTArtwork> ftArtwork) {
        addArtwork(FTArtworkType.MUSICBANNER, ftArtwork);
    }

    /**
     * Set the ClearArt artwork list
     *
     * @param ftArtwork
     */
    @JsonSetter("clearart")
    public void setClearArt(List<FTArtwork> ftArtwork) {
        addArtwork(FTArtworkType.CLEARART, ftArtwork);
    }

    /**
     * Set the ClearLogo artwork list
     *
     * @param ftArtwork
     */
    @JsonSetter("clearlogo")
    public void setClearLogo(List<FTArtwork> ftArtwork) {
        addArtwork(FTArtworkType.CLEARLOGO, ftArtwork);
    }

    /**
     * Set the SeasonThumb artwork list
     *
     * @param ftArtwork
     */
    @JsonSetter("seasonthumb")
    public void setSeasonThumb(List<FTArtwork> ftArtwork) {
        addArtwork(FTArtworkType.SEASONTHUMB, ftArtwork);
    }

    /**
     * Set the TvThumb artwork list
     *
     * @param ftArtwork
     */
    @JsonSetter("tvthumb")
    public void setTvThumb(List<FTArtwork> ftArtwork) {
        addArtwork(FTArtworkType.TVTHUMB, ftArtwork);
    }

    /**
     * Set the CharacterArt artwork list
     *
     * @param ftArtwork
     */
    @JsonSetter("characterart")
    public void setCharacterArt(List<FTArtwork> ftArtwork) {
        addArtwork(FTArtworkType.CHARACTERART, ftArtwork);
    }

    /**
     * Set the ShowBackground artwork list
     *
     * @param ftArtwork
     */
    @JsonSetter("showbackground")
    public void setShowBackground(List<FTArtwork> ftArtwork) {
        addArtwork(FTArtworkType.SHOWBACKGROUND, ftArtwork);
    }

    /**
     * Set the HDClearArt artwork list
     *
     * @param ftArtwork
     */
    @JsonSetter("hdclearart")
    public void setHdClearArt(List<FTArtwork> ftArtwork) {
        addArtwork(FTArtworkType.HDCLEARART, ftArtwork);
    }

    /**
     * Set the HD TV Logo artwork list
     *
     * @param ftArtwork
     */
    @JsonSetter("hdtvlogo")
    public void setHdTvLogo(List<FTArtwork> ftArtwork) {
        addArtwork(FTArtworkType.HDTVLOGO, ftArtwork);
    }

    /**
     * Set the TV Banner artwork list
     *
     * @param ftArtwork
     */
    @JsonSetter("tvbanner")
    public void setTvBanner(List<FTArtwork> ftArtwork) {
        addArtwork(FTArtworkType.TVBANNER, ftArtwork);
    }

    /**
     * Set the TV Poster artwork list
     *
     * @param ftArtwork
     */
    @JsonSetter("tvposter")
    public void setTvPoster(List<FTArtwork> ftArtwork) {
        addArtwork(FTArtworkType.TVPOSTER, ftArtwork);
    }

    /**
     * Set the TV Season poster artwork list
     *
     * @param ftArtwork
     */
    @JsonSetter("seasonposter")
    public void setSeasonPoster(List<FTArtwork> ftArtwork) {
        addArtwork(FTArtworkType.SEASONPOSTER, ftArtwork);
    }

    /**
     * Set the TV Season banner artwork list
     *
     * @param ftArtwork
     */
    @JsonSetter("seasonbanner")
    public void setSeasonBanner(List<FTArtwork> ftArtwork) {
        addArtwork(FTArtworkType.SEASONBANNER, ftArtwork);
    }

    /**
     * Set the HD Movie Logo artwork
     *
     * @param ftArtwork
     */
    @JsonSetter("hdmovielogo")
    public void setHdMovieLogo(List<FTArtwork> ftArtwork) {
        addArtwork(FTArtworkType.HDMOVIELOGO, ftArtwork);
    }

    /**
     * Set the HD Movie Clear Art artwork
     *
     * @param ftArtwork
     */
    @JsonSetter("hdmovieclearart")
    public void setHdMovieClearArt(List<FTArtwork> ftArtwork) {
        addArtwork(FTArtworkType.HDMOVIECLEARART, ftArtwork);
    }

    /**
     * Set the Movie Logo artwork
     *
     * @param ftArtwork
     */
    @JsonSetter("movielogo")
    public void setMovieLogo(List<FTArtwork> ftArtwork) {
        addArtwork(FTArtworkType.MOVIELOGO, ftArtwork);
    }

    /**
     * Set the Movie Disc artwork
     *
     * @param ftArtwork
     */
    @JsonSetter("moviedisc")
    public void setMovieDisc(List<FTArtwork> ftArtwork) {
        addArtwork(FTArtworkType.MOVIEDISC, ftArtwork);
    }

    /**
     * Set the Movie Banner artwork
     *
     * @param ftArtwork
     */
    @JsonSetter("moviebanner")
    public void setMovieBanner(List<FTArtwork> ftArtwork) {
        addArtwork(FTArtworkType.MOVIEBANNER, ftArtwork);
    }

    /**
     * Set the Movie Thumb artwork
     *
     * @param ftArtwork
     */
    @JsonSetter("moviethumb")
    public void setMovieThumb(List<FTArtwork> ftArtwork) {
        addArtwork(FTArtworkType.MOVIETHUMB, ftArtwork);
    }

    /**
     * Set the Movie Background artwork
     *
     * @param ftArtwork
     */
    @JsonSetter("moviebackground")
    public void setMovieBackground(List<FTArtwork> ftArtwork) {
        addArtwork(FTArtworkType.MOVIEBACKGROUND, ftArtwork);
    }

    /**
     * Set the Movie Poster artwork
     *
     * @param ftArtwork
     */
    @JsonSetter("movieposter")
    public void setMoviePoster(List<FTArtwork> ftArtwork) {
        addArtwork(FTArtworkType.MOVIEPOSTER, ftArtwork);
    }

    /**
     * Set the Movie Art artwork
     *
     * @param ftArtwork
     */
    @JsonSetter("movieart")
    public void setMovieArt(List<FTArtwork> ftArtwork) {
        addArtwork(FTArtworkType.MOVIEART, ftArtwork);
    }
}
