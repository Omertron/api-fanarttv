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
import java.util.List;
import org.apache.log4j.Logger;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class FanartTVTest {

    // Logger
    private static final Logger logger = Logger.getLogger(FanartTVTest.class);
    private FanartTv ft;
    private static final String APIKEY = "52fdc988539881c2ac1f3852ddfbfc5f";
    private static final int ID_TVDB = 79349; // Dexter
//    private static final int ID_TMDB = 78;    // Blade Runner
    private static final int ID_TMDB = 19995;    // Avatar
    private static final String ID_IMDB = "tt0242653";  // Matrix Revolutions

    @Before
    public void setUp() throws Exception {
        ft = new FanartTv(APIKEY);
    }

    /**
     * Test of getTvArtwork method, of class FanartTv.
     */
    @Test
    public void testGetTvArtwork_4args() throws Exception {
        logger.info("getTvArtwork");
        List<FanartTvArtwork> resultList = ft.getTvArtwork(ID_TVDB);
        assertTrue("No TV Artwork found!", !resultList.isEmpty());
    }

    /**
     * Test of getMovieArtwork method, of class FanartTv.
     */
    @Test
    public void testGetMovieArtwork_TMDB() throws Exception {
        logger.info("getMovieArtwork");
        List<FanartTvArtwork> resultList = ft.getMovieArtwork(ID_TMDB);
        assertTrue("No Movie Artwork found!", !resultList.isEmpty());
    }

    /**
     * Test of getMovieArtwork method, of class FanartTv.
     */
    @Test
    public void testGetMovieArtwork_IMDB() throws Exception {
        logger.info("getMovieArtwork (IMDB)");
        List<FanartTvArtwork> resultList = ft.getMovieArtwork(ID_IMDB);
        assertTrue("No Movie Artwork found!", !resultList.isEmpty());
    }
}
