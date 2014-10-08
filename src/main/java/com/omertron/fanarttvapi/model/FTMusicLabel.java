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
 * JSON Wrapper class for TV Music Label artwork from Fanart.TV
 *
 * @author stuart.boston
 */
public class FTMusicLabel extends ArtworkList {

    @JsonProperty("name")
    private String name;
    @JsonProperty("id")
    private String id;

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
     * Set the ID
     *
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * Get the ID
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

}
