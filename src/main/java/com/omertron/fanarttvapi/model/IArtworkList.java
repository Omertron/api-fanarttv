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

import com.omertron.fanarttvapi.enumeration.FTArtworkType;
import java.util.List;
import java.util.Map;

/**
 * Interface to present a list of the artwork
 *
 * @author stuart.boston
 */
public interface IArtworkList {

    /**
     * Return a map of all artwork
     *
     * @return
     */
    Map<FTArtworkType, List<FTArtwork>> getArtwork();

    /**
     * Return a list of a specific artwork type
     *
     * @param artworkType
     * @return
     */
    List<FTArtwork> getArtwork(FTArtworkType artworkType);

    /**
     * Check to see if the object has any artwork
     *
     * @return
     */
    boolean hasArtwork();

    /**
     * Check to see if the object has artwork of a specific type
     *
     * @param artworkType
     * @return
     */
    boolean hasArtwork(FTArtworkType artworkType);
}
