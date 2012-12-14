/*
 *      Copyright (c) 2004-2012 Stuart Boston
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
package com.omertron.fanarttv;

import com.omertron.fanarttvapi.FanartTvApi;
import com.omertron.fanarttvapi.model.FanartTvArtwork;
import com.omertron.fanarttvapi.tools.FilteringLayout;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class FanartTvApiTest {

    // Logger
    private static final Logger logger = Logger.getLogger(FanartTvApiTest.class);
    private FanartTvApi ft;
    private static final String APIKEY = "52fdc988539881c2ac1f3852ddfbfc5f";
    private static final ArrayList<Integer> ID_TVDB = new ArrayList<Integer>();
    private static final ArrayList<Integer> ID_TMDB = new ArrayList<Integer>();
    private static final ArrayList<String> ID_IMDB = new ArrayList<String>();
    private static final ArrayList<String> ID_MUSIC = new ArrayList<String>();
    private static final int ID_TVDB_NO_ARTWORK = 257256;// Love life (Unlikely to have artwork)

    @Before
    public void setUp() throws Exception {
        ft = new FanartTvApi(APIKEY);
        Logger.getRootLogger().setLevel(Level.TRACE);
        FilteringLayout.addApiKey("DO_NOT_MATCH");

        ID_TVDB.add(79349); // Dexter);
        ID_TVDB.add(ID_TVDB_NO_ARTWORK);

        ID_TMDB.add(78);    // Blade Runner
        ID_TMDB.add(19995); // Avatar

        ID_IMDB.add("tt0242653"); // Matrix Revolutions

        ID_MUSIC.add("122d63fc-8671-43e4-9752-34e846d62a9c"); // Katy Perry
    }

    /**
     * Test of getTvArtwork method, of class FanartTvApi.
     */
    @Test
    public void testGetTvArtwork() throws Exception {
        logger.info("getTvArtwork");
        List<FanartTvArtwork> resultList;
        for (int tvdbId : ID_TVDB) {
            resultList = ft.getTvArtwork(tvdbId);
            if (tvdbId == ID_TVDB_NO_ARTWORK) {
                assertTrue("Artwork found when should be empty!", resultList.isEmpty());
            } else {
                assertTrue("No TV Artwork found!", !resultList.isEmpty());
            }
        }
    }

    /**
     * Test of getMovieArtwork method, of class FanartTvApi.
     */
    @Test
    public void testGetMovieArtwork_TMDB() throws Exception {
        logger.info("getMovieArtwork (TMDB)");
        for (int tmdbId : ID_TMDB) {
            List<FanartTvArtwork> resultList = ft.getMovieArtwork(tmdbId);
            assertTrue("No Movie Artwork found!", !resultList.isEmpty());
        }
    }

    /**
     * Test of getMovieArtwork method, of class FanartTvApi.
     */
    @Test
    public void testGetMovieArtwork_IMDB() throws Exception {
        logger.info("getMovieArtwork (IMDB)");
        for (String imdbId : ID_IMDB) {
            List<FanartTvArtwork> resultList = ft.getMovieArtwork(imdbId);
            assertTrue("No Movie Artwork found!", !resultList.isEmpty());
        }
    }

}
