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
package com.moviejukebox.fanarttv;

import com.moviejukebox.fanarttv.model.FanartTvArtwork;
import com.moviejukebox.fanarttv.tools.FilteringLayout;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class FanartTVTest {

    // Logger
    private static final Logger LOGGER = Logger.getLogger(FanartTVTest.class);
    private FanartTv ft;
    private static final String APIKEY = "52fdc988539881c2ac1f3852ddfbfc5f";
    private static final ArrayList<Integer> ID_TVDB = new ArrayList<Integer>();
    private static final ArrayList<Integer> ID_TMDB = new ArrayList<Integer>();
    private static final ArrayList<String> ID_IMDB = new ArrayList<String>();
    private static final ArrayList<String> ID_MUSIC = new ArrayList<String>();
    private static final int ID_TVDB_NO_ARTWORK = 257256;// Love life (Unlikely to have artwork)

    @Before
    public void setUp() throws Exception {
        ft = new FanartTv(APIKEY);
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
     * Test of getTvArtwork method, of class FanartTv.
     */
    @Test
    public void testGetTvArtwork() throws Exception {
        LOGGER.info("getTvArtwork");
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
     * Test of getMovieArtwork method, of class FanartTv.
     */
    @Test
    public void testGetMovieArtwork_TMDB() throws Exception {
        LOGGER.info("getMovieArtwork (TMDB)");
        for (int tmdbId : ID_TMDB) {
            List<FanartTvArtwork> resultList = ft.getMovieArtwork(tmdbId);
            assertTrue("No Movie Artwork found!", !resultList.isEmpty());
        }
    }

    /**
     * Test of getMovieArtwork method, of class FanartTv.
     */
    @Test
    public void testGetMovieArtwork_IMDB() throws Exception {
        LOGGER.info("getMovieArtwork (IMDB)");
        for (String imdbId : ID_IMDB) {
            List<FanartTvArtwork> resultList = ft.getMovieArtwork(imdbId);
            assertTrue("No Movie Artwork found!", !resultList.isEmpty());
        }
    }
    
}
