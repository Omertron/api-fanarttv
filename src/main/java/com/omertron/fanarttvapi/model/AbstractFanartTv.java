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
public class AbstractFanartTv extends AbstractJsonMapping implements IArtworkList, Serializable {

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
            if (hasArtwork(at) && artwork.get(at).size() > 0) {
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
        if (artwork.containsKey(artworkType) && artwork.get(artworkType) != null) {
            return artwork.get(artworkType).size() > 0;
        }
        return false;
    }
}
