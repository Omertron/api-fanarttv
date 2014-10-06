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
package com.omertron.fanarttvapi;

import com.omertron.fanarttvapi.model.FTLatest;
import com.omertron.fanarttvapi.model.FTMovie;
import com.omertron.fanarttvapi.model.FTMusicAlbum;
import com.omertron.fanarttvapi.model.FTMusicArtist;
import com.omertron.fanarttvapi.model.FTMusicLabel;
import com.omertron.fanarttvapi.model.FTSeries;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FanartTvApiTest {

    // Logger
    private static final Logger LOG = LoggerFactory.getLogger(FanartTvApiTest.class);
    private static final String APIKEY = "52fdc988539881c2ac1f3852ddfbfc5f";
    private static final String CLIENT_KEY = "340b5ed125e407078ff183e9bf54f9b5";
    private static FanartTvApi ft;
    private static final ArrayList<Integer> ID_TVDB = new ArrayList<Integer>();
    private static final ArrayList<String> ID_TMDB = new ArrayList<String>();
    private static final ArrayList<String> ID_IMDB = new ArrayList<String>();
    private static final ArrayList<String> ID_MUSIC_ARTIST = new ArrayList<String>();
    private static final ArrayList<String> ID_MUSIC_ALBUM = new ArrayList<String>();
    private static final ArrayList<String> ID_MUSIC_LABEL = new ArrayList<String>();
    private static final int ID_TVDB_NO_ARTWORK = 257256;// Love life (Unlikely to have artwork)

    @BeforeClass
    public static void setUpClass() throws FanartTvException {
        ft = new FanartTvApi(APIKEY);
        TestLogger.Configure();

        ID_TVDB.add(79349); // Dexter);
        ID_TVDB.add(ID_TVDB_NO_ARTWORK);

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
    @Ignore("Done")
    public void testGetTvArtwork() throws FanartTvException {
        LOG.info("getTvArtwork");
        FanartTvApi api = new FanartTvApi(APIKEY);

        for (int id : ID_TVDB) {
            FTSeries result = api.getTvArtwork(Integer.toString(id));
            assertTrue("No artwork found for ID: " + id, result.hasArtwork());
        }
    }

    /**
     * Test of getTvLatest method, of class FanartTvApi.
     *
     * @throws com.omertron.fanarttvapi.FanartTvException
     */
    @Ignore("Done")
    public void testGetTvLatest() throws FanartTvException {
        LOG.info("getTvLatest");
        String date = "";
        FanartTvApi api = new FanartTvApi(APIKEY);

        List<FTLatest> result = api.getTvLatest(date);
        assertFalse("Empty latest results found", result.isEmpty());
        assertTrue("No latest results found", result.size() > 0);
    }

    /**
     * Test of getMovieArtwork method, of class FanartTvApi.
     *
     * @throws com.omertron.fanarttvapi.FanartTvException
     */
    @Ignore("Done")
    public void testGetMovieArtwork() throws FanartTvException {
        LOG.info("getMovieArtwork");
        FanartTvApi api = new FanartTvApi(APIKEY);

        for (String id : ID_TMDB) {
            FTMovie result = api.getMovieArtwork(id);
            assertTrue("No artwork found for ID: " + id, result.hasArtwork());
        }
    }

    /**
     * Test of getMovieLatest method, of class FanartTvApi.
     *
     * @throws com.omertron.fanarttvapi.FanartTvException
     */
    @Ignore("Done")
    public void testGetMovieLatest() throws FanartTvException {
        LOG.info("getMovieLatest");
        String date = "";
        FanartTvApi api = new FanartTvApi(APIKEY);
        List<FTLatest> result = api.getMovieLatest(date);
        assertFalse("Empty latest results found", result.isEmpty());
        assertTrue("No latest results found", result.size() > 0);
    }

    /**
     * Test of getMusicArtist method, of class FanartTvApi.
     *
     * @throws com.omertron.fanarttvapi.FanartTvException
     */
    @Ignore
    public void testGetMusicArtist() throws FanartTvException {
        LOG.info("getMusicArtist");
        FanartTvApi api = new FanartTvApi(APIKEY);

        for (String id : ID_MUSIC_ARTIST) {
            FTMusicArtist result = api.getMusicArtist(id);
            LOG.info(result.toString());
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
        FanartTvApi api = new FanartTvApi(APIKEY);

        for (String id : ID_MUSIC_ALBUM) {
            FTMusicAlbum result = api.getMusicAlbum(id);
            LOG.info(result.toString());
        }
    }

    /**
     * Test of getMusicLabel method, of class FanartTvApi.
     *
     * @throws com.omertron.fanarttvapi.FanartTvException
     */
    @Ignore("Done")
    public void testGetMusicLabel() throws FanartTvException {
        LOG.info("getMusicLabel");
        FanartTvApi api = new FanartTvApi(APIKEY);

        for (String id : ID_MUSIC_LABEL) {
            FTMusicLabel result = api.getMusicLabel(id);
            LOG.info(result.toString());
        }
    }

    /**
     * Test of getMusicArtistLatest method, of class FanartTvApi.
     *
     * @throws com.omertron.fanarttvapi.FanartTvException
     */
    @Ignore("Done")
    public void testGetMusicArtistLatest() throws FanartTvException {
        LOG.info("getMusicArtistLatest");
        String date = "";
        FanartTvApi api = new FanartTvApi(APIKEY);
        List<FTLatest> result = api.getMusicArtistLatest(date);
        assertFalse("Empty latest results found", result.isEmpty());
        assertTrue("No latest results found", result.size() > 0);
    }

}
