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
package com.moviejukebox.fanarttv.tools;

import com.moviejukebox.fanarttv.model.FanartTvArtwork;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class FanartTvParser {

    protected FanartTvParser() {
        // This is a utility class, so don't instantiate it.
        throw new UnsupportedOperationException();
    }
    
    /**
     * Parse all the artwork returned by the searchUrl
     * @param searchUrl
     */
    public static List<FanartTvArtwork> parseArtwork(String searchUrl) {
        Document doc;
        List<FanartTvArtwork> artwork = new ArrayList<FanartTvArtwork>();
        
        try {
            doc = DOMHelper.getEventDocFromUrl(searchUrl);
        } catch (IOException e) {
            doc = null;
        } catch (ParserConfigurationException e) {
            doc = null;
        } catch (SAXException e) {
            doc = null;
        }
        
        if (doc == null) {
            return artwork;
        }
        
        // Parse the ClearLOGO
        artwork.addAll(parseFanart(doc, FanartTvArtwork.TYPE_CLEARLOGO));

        // Parse the ClearART
        artwork.addAll(parseFanart(doc, FanartTvArtwork.TYPE_CLEARART));

        // Parse the TV Thumbs
        artwork.addAll(parseFanart(doc, FanartTvArtwork.TYPE_TVTHUMB));

        // Parse the Season Thumbs
        artwork.addAll(parseFanart(doc, FanartTvArtwork.TYPE_SEASONTHUMB));
        
        return artwork;
        
    }

    /**
     * Parse the list for a single type of artwork
     * @param doc
     * @param artworkType
     * @return
     */
    private static List<FanartTvArtwork> parseFanart(Document doc, String artworkType) {
        FanartTvArtwork fanart;
        List<FanartTvArtwork> artwork = new ArrayList<FanartTvArtwork>();
        
        NodeList nlArtwork = doc.getElementsByTagName(artworkType);
        if (nlArtwork != null && nlArtwork.getLength() > 0) {
            for (int loop = 0; loop < nlArtwork.getLength(); loop++) {
                Node nArtwork = nlArtwork.item(loop);
                if (nArtwork.getNodeType() == Node.ELEMENT_NODE) {
                    Element eArtwork = (Element) nArtwork;
                    fanart = new FanartTvArtwork();
                    fanart.setType(artworkType);
                    fanart.setUrl(eArtwork.getAttribute("url"));
                    artwork.add(fanart);
                }
            }
        }
        
        return artwork;
    }
    
}
