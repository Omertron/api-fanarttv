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
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class FanartTVTest {

    // Logger
    private static final Logger LOGGER = Logger.getLogger(FanartTVTest.class);
    private FanartTv ft;
    private static final String APIKEY = "52fdc988539881c2ac1f3852ddfbfc5f";
    private static ArrayList<Integer> ID_TVDB = new ArrayList<Integer>();
    private static ArrayList<Integer> ID_TMDB = new ArrayList<Integer>();
    private static ArrayList<String> ID_IMDB = new ArrayList<String>();

    @Before
    public void setUp() throws Exception {
        ft = new FanartTv(APIKEY);

        ID_TVDB.add(79349); // Dexter);

        ID_TMDB.add(78);    // Blade Runner
        ID_TMDB.add(19995); // Avatar

        ID_IMDB.add("tt0242653"); // Matrix Revolutions
    }

    /**
     * Test of getTvArtwork method, of class FanartTv.
     */
    @Test
    public void testGetTvArtwork() throws Exception {
        LOGGER.info("getTvArtwork");
        for (int tvdbid : ID_TVDB) {
            List<FanartTvArtwork> resultList = ft.getTvArtwork(tvdbid);
            assertTrue("No TV Artwork found!", !resultList.isEmpty());
        }
    }

    /**
     * Test of getMovieArtwork method, of class FanartTv.
     */
    @Test
    public void testGetMovieArtwork_TMDB() throws Exception {
        LOGGER.info("getMovieArtwork");
        for (int tmdbid : ID_TMDB) {
            List<FanartTvArtwork> resultList = ft.getMovieArtwork(tmdbid);
            assertTrue("No Movie Artwork found!", !resultList.isEmpty());
        }
    }

    /**
     * Test of getMovieArtwork method, of class FanartTv.
     */
    @Test
    public void testGetMovieArtwork_IMDB() throws Exception {
        LOGGER.info("getMovieArtwork (IMDB)");
        for (String imdbid : ID_IMDB) {
            List<FanartTvArtwork> resultList = ft.getMovieArtwork(imdbid);
            assertTrue("No Movie Artwork found!", !resultList.isEmpty());
        }
    }
}
