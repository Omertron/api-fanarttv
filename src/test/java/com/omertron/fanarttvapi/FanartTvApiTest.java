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
package com.omertron.fanarttvapi;

import com.omertron.omdbapi.FanartTvException;
import com.omertron.fanarttvapi.model.FTLatest;
import com.omertron.fanarttvapi.model.FTMovie;
import com.omertron.fanarttvapi.model.FTMusicArtist;
import com.omertron.fanarttvapi.model.FTMusicLabel;
import com.omertron.fanarttvapi.model.FTSeries;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FanartTvApiTest {

    // Logger
    private static final Logger LOG = LoggerFactory.getLogger(FanartTvApiTest.class);
    // API Keys
    private static final String PROP_FIlENAME = "testing.properties";
    private static String API_KEY;
    private static String CLIENT_KEY;
    private static FanartTvApi ft;
    private static final ArrayList<Integer> ID_TVDB = new ArrayList<Integer>();
    private static final ArrayList<String> ID_TMDB = new ArrayList<String>();
    private static final ArrayList<String> ID_IMDB = new ArrayList<String>();
    private static final ArrayList<String> ID_MUSIC_ARTIST = new ArrayList<String>();
    private static final ArrayList<String> ID_MUSIC_ALBUM = new ArrayList<String>();
    private static final ArrayList<String> ID_MUSIC_LABEL = new ArrayList<String>();

    @BeforeClass
    public static void setUpClass() throws FanartTvException {
        TestLogger.Configure();

        Properties props = new Properties();
        File propertyFile = new File(PROP_FIlENAME);
        if (propertyFile.exists()) {
            LOG.info("Loading properties from '{}'", PROP_FIlENAME);
            TestLogger.loadProperties(props, propertyFile);

            API_KEY = props.getProperty("API_KEY");
            CLIENT_KEY = props.getProperty("CLIENT_KEY");
        } else {
            LOG.info("Property file '{}' not found, creating dummy file.", PROP_FIlENAME);

            props.setProperty("API_KEY", "INSERT_YOUR_API_KEY_HERE");
            props.setProperty("CLIENT_KEY", "INSERT_YOUR_CLIENT_KEY_HERE");

            TestLogger.saveProperties(props, propertyFile, "Properties file for tests");
            fail("Failed to get key information from properties file '" + PROP_FIlENAME + "'");
        }

        ft = new FanartTvApi(API_KEY, CLIENT_KEY);

        ID_TVDB.add(79349); // Dexter);
        ID_TVDB.add(80379); // Big Bang Theory

        ID_TMDB.add("78");    // Blade Runner
        ID_TMDB.add("19995"); // Avatar

        ID_IMDB.add("tt0242653"); // Matrix Revolutions

        ID_MUSIC_ARTIST.add("122d63fc-8671-43e4-9752-34e846d62a9c"); // Katy Perry
        ID_MUSIC_ARTIST.add("a35237a0-4f47-40a6-b6f3-1e786db23402"); // Rod Stewart

        ID_MUSIC_ALBUM.add("4a28692f-37ab-39e8-97aa-a3f352f32010"); // Rod Stewart
        ID_MUSIC_ALBUM.add("88f14b0b-f8d1-31b4-87ab-199145fc12d3"); // Katy Perry

        ID_MUSIC_LABEL.add("a35237a0-4f47-40a6-b6f3-1e786db23402"); // Rod Stewart
    }

    @AfterClass
    public static void tearDownClass() throws FanartTvException {
    }

    @Before
    public void setUp() throws FanartTvException {
    }

    @After
    public void tearDown() throws FanartTvException {
    }

    /**
     * Test of getTvArtwork method, of class FanartTvApi.
     *
     * @throws FanartTvException
     */
    @Test
    public void testGetTvArtwork() throws FanartTvException {
        LOG.info("getTvArtwork");

        for (int id : ID_TVDB) {
            FTSeries result = ft.getTvArtwork(Integer.toString(id));
            assertTrue("No artwork found for ID: " + id, result.hasArtwork());
        }
    }

    /**
     * Test of getTvLatest method, of class FanartTvApi.
     *
     * @throws com.omertron.fanarttvapi.FanartTvException
     */
    @Test
    public void testGetTvLatest() throws FanartTvException {
        LOG.info("getTvLatest");
        String date = "";

        List<FTLatest> result = ft.getTvLatest(date);
        assertFalse("Empty latest results found", result.isEmpty());
        assertTrue("No latest results found", result.size() > 0);
    }

    /**
     * Test of getMovieArtwork method, of class FanartTvApi.
     *
     * @throws com.omertron.fanarttvapi.FanartTvException
     */
    @Test
    public void testGetMovieArtwork() throws FanartTvException {
        LOG.info("getMovieArtwork");

        for (String id : ID_TMDB) {
            FTMovie result = ft.getMovieArtwork(id);
            assertTrue("No artwork found for TMDB ID: " + id, result.hasArtwork());
        }

        for (String id : ID_IMDB) {
            FTMovie result = ft.getMovieArtwork(id);
            assertTrue("No artwork found for IMDB ID: " + id, result.hasArtwork());
        }
    }

    /**
     * Test of getMovieLatest method, of class FanartTvApi.
     *
     * @throws com.omertron.fanarttvapi.FanartTvException
     */
    @Test
    public void testGetMovieLatest() throws FanartTvException {
        LOG.info("getMovieLatest");
        String date = "";
        List<FTLatest> result = ft.getMovieLatest(date);
        assertFalse("Empty latest results found", result.isEmpty());
        assertTrue("No latest results found", result.size() > 0);
    }

    /**
     * Test of getMusicArtist method, of class FanartTvApi.
     *
     * @throws com.omertron.fanarttvapi.FanartTvException
     */
    @Test
    public void testGetMusicArtist() throws FanartTvException {
        LOG.info("getMusicArtist");

        for (String id : ID_MUSIC_ARTIST) {
            FTMusicArtist result = ft.getMusicArtist(id);
            assertTrue("No artwork found for ID: " + id, result.hasArtwork());
        }
    }

    /**
     * Test of getMusicAlbum method, of class FanartTvApi.
     *
     * @throws com.omertron.fanarttvapi.FanartTvException
     */
    @Test
    public void testGetMusicAlbum() throws FanartTvException {
        LOG.info("getMusicAlbum");

        for (String id : ID_MUSIC_ALBUM) {
            FTMusicArtist result = ft.getMusicAlbum(id);
            assertTrue("No album found for ID: " + id, result.getAlbums().size() > 0);
        }
    }

    /**
     * Test of getMusicLabel method, of class FanartTvApi.
     *
     * @throws com.omertron.fanarttvapi.FanartTvException
     */
    @Test
    public void testGetMusicLabel() throws FanartTvException {
        LOG.info("getMusicLabel");

        for (String id : ID_MUSIC_LABEL) {
            FTMusicLabel result = ft.getMusicLabel(id);
            assertTrue("No artwork found for ID: " + id, result.hasArtwork());
        }
    }

    /**
     * Test of getMusicArtistLatest method, of class FanartTvApi.
     *
     * @throws com.omertron.fanarttvapi.FanartTvException
     */
    @Test
    public void testGetMusicArtistLatest() throws FanartTvException {
        LOG.info("getMusicArtistLatest");
        String date = "";

        List<FTLatest> result = ft.getMusicArtistLatest(date);
        assertFalse("Empty latest results found", result.isEmpty());
        assertTrue("No latest results found", result.size() > 0);
    }

}
