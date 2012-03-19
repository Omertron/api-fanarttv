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
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class FanartTVTest {
    private FanartTv ft;
    private static final String APIKEY = "52fdc988539881c2ac1f3852ddfbfc5f";
    private static final int TV_ID = 80348;

    @Before
    public void setUp() throws Exception {
        ft = new FanartTv(APIKEY);
    }

    @Test
    public void testGetArtwork() {
        List<FanartTvArtwork> artworkList = ft.getArtwork(TV_ID);
        assertTrue(artworkList.size() > 0);
    }

    @Test
    public void testGetArtworkClearArt() {
        List<FanartTvArtwork> artworkList = ft.getArtwork(TV_ID, FanartTvArtwork.TYPE_CLEARART);
        assertTrue(artworkList.size() > 0);
    }

    @Test
    public void testGetArtworkClearLogo() {
        List<FanartTvArtwork> artworkList = ft.getArtwork(TV_ID, FanartTvArtwork.TYPE_CLEARLOGO);
        assertTrue(artworkList.size() > 0);
    }

    @Test
    public void testGetArtworkSeasonThumb() {
        List<FanartTvArtwork> artworkList = ft.getArtwork(TV_ID, FanartTvArtwork.TYPE_SEASONTHUMB);
        assertTrue(artworkList.size() > 0);
    }

    @Test
    public void testGetArtworkTvThumb() {
        List<FanartTvArtwork> artworkList = ft.getArtwork(TV_ID, FanartTvArtwork.TYPE_TVTHUMB);
        assertTrue(artworkList.size() > 0);
    }

}
